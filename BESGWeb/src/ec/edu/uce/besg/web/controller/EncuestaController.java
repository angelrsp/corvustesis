package ec.edu.uce.besg.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import ec.edu.uce.besg.common.util.ApplicationUtility;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;
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
	
	@ManagedProperty(value="#{encuestaDataManager}")
	private EncuestaDataManager encuestaDataManager;

	
	private HtmlPanelGrid htmlPanelGrid;
	
	public EncuestaController() {
	
	}
	
	public CuestionarioService getCuestionarioService() {
		return cuestionarioService;
	}

	public void setCuestionarioService(CuestionarioService cuestionarioService) {
		this.cuestionarioService = cuestionarioService;
	}

	public HtmlPanelGrid getHtmlPanelGrid() {
		if(htmlPanelGrid==null)
		{
			UIOutput label;
		    UIInput txtArea;
		    
			List<PreguntaDTO> preguntaList;
			ResultadoDTO resultadoDTO;
			RespuestaDTO respuesta;
			
			Integer numero;
			String expresion;
			
			HtmlSelectOneRadio htmlSelectOneRadio;
			try {
				htmlPanelGrid=new HtmlPanelGrid();
			    htmlPanelGrid.setColumns(2);
			    htmlPanelGrid.setStyleClass("pnlGrid");
			    
			    numero=0;
			    preguntaList=cuestionarioService.readPregunta(new PreguntaDTO());
				for(PreguntaDTO preguntaDTO:preguntaList)
				{
					label=new HtmlOutputText();
					txtArea = new HtmlInputTextarea();
					
					
					if(preguntaDTO.getPreControl().equals(2))
					{
						label.setValue(preguntaDTO.getPreDescripcion());
						
						respuesta=new RespuestaDTO();
						respuesta.setCuePregunta(preguntaDTO);
						
						for(RespuestaDTO respuestaDTO:cuestionarioService.readRespuesta(respuesta))
						{
							resultadoDTO=new ResultadoDTO();
							resultadoDTO.setCueRespuesta(respuestaDTO);
							encuestaDataManager.getResultadoList().add(resultadoDTO);
							
							txtArea.setId("respuesta"+numero.toString()); // Must be unique!
							expresion=ApplicationUtility.getInstance().appendStringBuilder("#{encuestaDataManager.resultadoList["+numero+"].resValor}").toString();
						    txtArea.setValueExpression("value", createValueExpression(expresion, String.class));

						    htmlPanelGrid.getChildren().add(label);	    
						    htmlPanelGrid.getChildren().add(txtArea);
						}
					}
					else if(preguntaDTO.getPreControl().equals(4))
					{
						label.setValue(preguntaDTO.getPreDescripcion());
						
						htmlSelectOneRadio=new HtmlSelectOneRadio();
						
						ArrayList<SelectItem> radioBtnOptionsList = new ArrayList<SelectItem>();
						
						respuesta=new RespuestaDTO();
						respuesta.setCuePregunta(preguntaDTO);
						
						
						for(RespuestaDTO respuestaDTO:cuestionarioService.readRespuesta(respuesta))
						{
							radioBtnOptionsList.add(new SelectItem(respuestaDTO.getResCodigo(),respuestaDTO.getResDescripcion()));
							
							resultadoDTO=new ResultadoDTO();
							resultadoDTO.setCueRespuesta(respuestaDTO);
							encuestaDataManager.getResultadoList().add(resultadoDTO);
						}
						UISelectItems radioBtnOptions = new UISelectItems();
						radioBtnOptions.setValue(radioBtnOptionsList);
						// Add radioButton options.
						htmlSelectOneRadio.getChildren().add(radioBtnOptions);
						expresion=ApplicationUtility.getInstance().appendStringBuilder("#{encuestaDataManager.resultadoList["+numero+"].cueRespuesta.resCodigo}").toString();

						htmlSelectOneRadio.setValueExpression("value", createValueExpression(expresion, String.class));
						
						htmlPanelGrid.getChildren().add(label);
						htmlPanelGrid.getChildren().add(htmlSelectOneRadio);
					}
				    
				    numero=numero+1;
				}
			} catch (Exception e) {
				JsfUtil.addErrorMessage(e.toString());
			}
			
		}
		return htmlPanelGrid;
	}
	public void setHtmlPanelGrid(HtmlPanelGrid htmlPanelGrid) {
		this.htmlPanelGrid = htmlPanelGrid;
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
	
	public static ExpressionFactory getExpressionFactory() {
		return getApplication().getExpressionFactory();
	}

    public static Application getApplication() {
        return FacesContext.getCurrentInstance().getApplication();
    }
    
    public static ELContext getELContext() {
        return FacesContext.getCurrentInstance().getELContext();
    }
	  
    
    public void onClickSave()
    {
    	List<ResultadoDTO> res= encuestaDataManager.getResultadoList();
    	if(res.isEmpty())
    	{
    		
    	}
    }
	    
}
