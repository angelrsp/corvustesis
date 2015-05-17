package ec.edu.uce.besg.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.panel.Panel;
import org.primefaces.component.panelgrid.PanelGrid;

import ec.edu.uce.besg.common.util.ApplicationUtility;
import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;
import ec.edu.uce.besg.ejb.service.CandidatoService;
import ec.edu.uce.besg.ejb.service.CuestionarioService;
import ec.edu.uce.besg.web.datamanager.EncuestaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@SessionScoped
@ManagedBean(name = "encuestaController")
public class EncuestaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CuestionarioService cuestionarioService;

	@EJB
	private CandidatoService candidatoService;

	
	@ManagedProperty(value="#{encuestaDataManager}")
	private EncuestaDataManager encuestaDataManager;

	
	private PanelGrid panelGrid;
	
	public EncuestaController() {
	
	}
	
	public CuestionarioService getCuestionarioService() {
		return cuestionarioService;
	}

	public void setCuestionarioService(CuestionarioService cuestionarioService) {
		this.cuestionarioService = cuestionarioService;
	}

	public PanelGrid getPanelGrid() {

		if(panelGrid==null)
		{
			HtmlOutputText label;
		    InputTextarea txtArea;
		    InputText txt;
		    Calendar calendar;
		    HtmlSelectOneRadio htmlSelectOneRadio;
		    HtmlSelectManyCheckbox htmlSelectManyCheckbox;
		    
			ResultadoDTO resultadoDTO;
			RespuestaDTO respuesta;
			
			Integer numero,index = null;
			String expresion;
			
			EncuestaDTO encuesta;
			CategoriaDTO categoria;
			PreguntaDTO pregunta;
			Boolean primero=Boolean.FALSE;
			ResultadoViewDTO resultadoViewDTO;
			try {
				panelGrid=new PanelGrid();
				panelGrid.setColumns(2);
				//panelGrid.setStyleClass("pnlGrid");
			    
			    encuesta=new EncuestaDTO();
			    encuesta.setEncHabilitado(true);
			    
			    for(EncuestaDTO encuestaDTO:cuestionarioService.readEncuesta(encuesta))
			    {
			    	resultadoViewDTO=new ResultadoViewDTO();
			    	resultadoViewDTO.setCatEncuesta(encuestaDTO.getEncCodigo());
			    	resultadoViewDTO.setRsuCandidato(encuestaDataManager.getCandidatoDTO().getCanCodigo());
			    	if(cuestionarioService.readResultadoView(resultadoViewDTO).isEmpty())
			    	{
			    		encuestaDataManager.setDisableSave(false);
			    		
				    	numero=0;
				    	categoria=new CategoriaDTO();
				    	categoria.setCueEncuesta(encuestaDTO);
				    	
				    	for(CategoriaDTO categoriaDTO:cuestionarioService.readCategoria(categoria))
				    	{
						    pregunta=new PreguntaDTO();
						    pregunta.setCueCategoria(categoriaDTO);
						    
						    label=new HtmlOutputText();
						    label.setValue(categoriaDTO.getCatDescripcion());
						    label.setStyle("font-weight:bold;font-size:10pt;");
						    
						    panelGrid.getChildren().add(label);
						    
						    label=new HtmlOutputText();
						    label.setValue("");
						    
						    panelGrid.getChildren().add(label);
						    
							for(PreguntaDTO preguntaDTO:cuestionarioService.readPregunta(pregunta))
							{

								label=new HtmlOutputText();
								label.setValue(preguntaDTO.getPreDescripcion());
								panelGrid.getChildren().add(label);	
								
								if(preguntaDTO.getCueControl().getConCodigo().equals(3))
								{
									respuesta=new RespuestaDTO();
									respuesta.setCuePregunta(preguntaDTO);
									
									for(RespuestaDTO respuestaDTO:cuestionarioService.readRespuesta(respuesta))
									{
										txtArea = new InputTextarea();
										txtArea.setAutoResize(false);
										
										resultadoDTO=new ResultadoDTO();
										resultadoDTO.setCueRespuesta(respuestaDTO);
										resultadoDTO.setBemCandidato(encuestaDataManager.getCandidatoDTO());
										encuestaDataManager.getResultadoList().add(resultadoDTO);
										
										txtArea.setId("respuesta"+numero.toString()); // Must be unique!
										expresion=ApplicationUtility.getInstance().appendStringBuilder("#{encuestaDataManager.resultadoList["+numero+"].resValorString}").toString();
									    txtArea.setValueExpression("value", createValueExpression(expresion, String.class));
									    
									    if(preguntaDTO.getPreRequerido())
									    {
									    	txtArea.setRequired(preguntaDTO.getPreRequerido());
									    	txtArea.setLabel(preguntaDTO.getPreDescripcion());
									    }
									    	
									        
									    panelGrid.getChildren().add(txtArea);
									}
									numero=numero+1;
								}
								//textbox
								else if(preguntaDTO.getCueControl().getConCodigo().equals(2))
								{
									respuesta=new RespuestaDTO();
									respuesta.setCuePregunta(preguntaDTO);
									
									for(RespuestaDTO respuestaDTO:cuestionarioService.readRespuesta(respuesta))
									{
										txt = new InputText();
										
										resultadoDTO=new ResultadoDTO();
										resultadoDTO.setCueRespuesta(respuestaDTO);
										resultadoDTO.setBemCandidato(encuestaDataManager.getCandidatoDTO());
										encuestaDataManager.getResultadoList().add(resultadoDTO);
										
										txt.setId("respuesta"+numero.toString()); // Must be unique!
										expresion=ApplicationUtility.getInstance().appendStringBuilder("#{encuestaDataManager.resultadoList["+numero+"].resValorString}").toString();
									    txt.setValueExpression("value", createValueExpression(expresion, String.class));
									    
									    if(preguntaDTO.getPreRequerido())
									    {
									    	txt.setRequired(preguntaDTO.getPreRequerido());
									    	txt.setLabel(preguntaDTO.getPreDescripcion());
									    }

									    panelGrid.getChildren().add(label);	    
									    panelGrid.getChildren().add(txt);
									}
									numero=numero+1;
								}
								//Radio
								else if(preguntaDTO.getCueControl().getConCodigo().equals(4))
								{
									htmlSelectOneRadio=new HtmlSelectOneRadio();
									
									ArrayList<SelectItem> radioBtnOptionsList = new ArrayList<SelectItem>();
									
									respuesta=new RespuestaDTO();
									respuesta.setCuePregunta(preguntaDTO);
									
									for(RespuestaDTO respuestaDTO:cuestionarioService.readRespuesta(respuesta))
									{
										if(!primero)
										{
											index=respuestaDTO.getResCodigo();
											primero=Boolean.TRUE;
											resultadoDTO=new ResultadoDTO();
											resultadoDTO.setCueRespuesta(respuestaDTO);
											resultadoDTO.setBemCandidato(encuestaDataManager.getCandidatoDTO());
											encuestaDataManager.getResultadoList().add(resultadoDTO);										
										}									
										radioBtnOptionsList.add(new SelectItem(respuestaDTO.getResCodigo(),respuestaDTO.getResDescripcion()));
									}
									primero=Boolean.FALSE;
									
									if(index!=null)
									{
										if(preguntaDTO.getPreRequerido())
										{
											htmlSelectOneRadio.setValue(new Integer(index));
											htmlSelectOneRadio.setRequired(preguntaDTO.getPreRequerido());
											htmlSelectOneRadio.setLabel(preguntaDTO.getPreDescripcion());
										}
									}
										
									
									UISelectItems radioBtnOptions = new UISelectItems();
									radioBtnOptions.setValue(radioBtnOptionsList);
									// Add radioButton options.
									htmlSelectOneRadio.getChildren().add(radioBtnOptions);
									expresion=ApplicationUtility.getInstance().appendStringBuilder("#{encuestaDataManager.resultadoList["+numero+"].resValorInt}").toString();

									htmlSelectOneRadio.setValueExpression("value", createValueExpression(expresion, String.class));
									htmlSelectOneRadio.setLayout("pageDirection");
									
									
									panelGrid.getChildren().add(label);
									panelGrid.getChildren().add(htmlSelectOneRadio);
									
									numero=numero+1;
								}
								//calendario
								else if(preguntaDTO.getCueControl().getConCodigo().equals(6))
								{
									respuesta=new RespuestaDTO();
									respuesta.setCuePregunta(preguntaDTO);
									
									for(RespuestaDTO respuestaDTO:cuestionarioService.readRespuesta(respuesta))
									{
										calendar=new Calendar();
										resultadoDTO=new ResultadoDTO();
										resultadoDTO.setCueRespuesta(respuestaDTO);
										resultadoDTO.setBemCandidato(encuestaDataManager.getCandidatoDTO());
										encuestaDataManager.getResultadoList().add(resultadoDTO);
																			
										calendar.setId("respuesta"+numero.toString()); // Must be unique!
										expresion=ApplicationUtility.getInstance().appendStringBuilder("#{encuestaDataManager.resultadoList["+numero+"].resValorDate}").toString();
									    calendar.setValueExpression("value", createValueExpressionDate(expresion, Date.class));
									    
									    if(preguntaDTO.getPreRequerido())
									    {
									    	calendar.setRequired(preguntaDTO.getPreRequerido());
									    	calendar.setLabel(preguntaDTO.getPreDescripcion());
									    }
									    	
									    calendar.setPattern("yyyy-MM-dd");
									    calendar.setNavigator(true);

									    panelGrid.getChildren().add(label);	    
									    panelGrid.getChildren().add(calendar);
									}
									
									numero=numero+1;
								}
								
								else if(preguntaDTO.getCueControl().getConCodigo().equals(7))
								{
									label.setValue(preguntaDTO.getPreDescripcion());
									
									htmlSelectManyCheckbox=new HtmlSelectManyCheckbox();
									
									if(preguntaDTO.getPreRequerido())
									{
										htmlSelectManyCheckbox.setRequired(preguntaDTO.getPreRequerido());
										htmlSelectManyCheckbox.setLabel(preguntaDTO.getPreDescripcion());
									}
										
									
									ArrayList<SelectItem> checkBoxList = new ArrayList<SelectItem>();
									
									respuesta=new RespuestaDTO();
									respuesta.setCuePregunta(preguntaDTO);
									
									List<RespuestaDTO> respuestaTmpList=cuestionarioService.readRespuesta(respuesta);
									
									for(RespuestaDTO respuestaDTO:respuestaTmpList)
									{
										if(!primero)
										{
											primero=Boolean.TRUE;
											resultadoDTO=new ResultadoDTO();
											resultadoDTO.setCueRespuesta(respuestaDTO);
											resultadoDTO.setBemCandidato(encuestaDataManager.getCandidatoDTO());
											resultadoDTO.setResArrayString(new String[respuestaTmpList.size()]);
											encuestaDataManager.getResultadoList().add(resultadoDTO);
										}
										checkBoxList.add(new SelectItem(respuestaDTO.getResCodigo(),respuestaDTO.getResDescripcion()));
									}
									primero=Boolean.FALSE;
																	
									UISelectItems checkBoxs = new UISelectItems();
									checkBoxs.setValue(checkBoxList);
									// Add radioButton options.
									htmlSelectManyCheckbox.getChildren().add(checkBoxs);
									expresion=ApplicationUtility.getInstance().appendStringBuilder("#{encuestaDataManager.resultadoList["+numero+"].resArrayString}").toString();

									htmlSelectManyCheckbox.setValueExpression("value", createValueExpressionStringArray(expresion, String[].class));
									htmlSelectManyCheckbox.setLayout("pageDirection");
									
									
									panelGrid.getChildren().add(label);
									panelGrid.getChildren().add(htmlSelectManyCheckbox);
									
									numero=numero+1;
								}
							}
				    	}
					}
				}
			} catch (Exception e) {
				JsfUtil.addErrorMessage(e.toString());
			}
			
		}
		return panelGrid;
	}
	public void setPanelGrid(PanelGrid panelGrid) {
		this.panelGrid = panelGrid;
	}

	public EncuestaDataManager getEncuestaDataManager() {
		return encuestaDataManager;
	}

	public void setEncuestaDataManager(EncuestaDataManager encuestaDataManager) {
		this.encuestaDataManager = encuestaDataManager;
	}

	private ValueExpression createValueExpression(String binding, Class<String> clazz) {
        final ValueExpression ve = getExpressionFactory()
                .createValueExpression(getELContext(), binding, String.class);

        return ve;
    }
	
	private ValueExpression createValueExpressionDate(String binding, Class<Date> clazz) {
        final ValueExpression ve = getExpressionFactory()
                .createValueExpression(getELContext(), binding, Date.class);

        return ve;
    }
	
	private ValueExpression createValueExpressionStringArray(String binding, Class<String[]> clazz) {
        final ValueExpression ve = getExpressionFactory()
                .createValueExpression(getELContext(), binding, String[].class);

        return ve;
    }
	
	public static ExpressionFactory getExpressionFactory() {
		return getApplication().getExpressionFactory();
	}

    public static Application getApplication() {
        return FacesContext.getCurrentInstance().getApplication();
    }
    
    public static ELContext getELContext() {
        return FacesContext.getCurrentInstance().getELContext();
    }
	
    @PostConstruct
    private void init()
    {
    	readCandidato();
    }
    
	private void readCandidato()
	{
		try {
			encuestaDataManager.setUsuarioDTO((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			encuestaDataManager.getCandidatoDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			encuestaDataManager.setCandidatoDTO(candidatoService.readCandidato(encuestaDataManager.getCandidatoDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

    
    public void onClickSave()
    {
    	List<ResultadoDTO> res;
    	try {
    		res= encuestaDataManager.getResultadoList();
			cuestionarioService.createOrUpdateResultado(res);
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			encuestaDataManager.setDisableSave(Boolean.TRUE);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
    }
	    
}
