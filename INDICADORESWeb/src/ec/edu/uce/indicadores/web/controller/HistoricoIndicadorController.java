package ec.edu.uce.indicadores.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.EvidenciaDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.web.datamanager.IndicadorDataManager;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "historicoIndicadorController")
public class HistoricoIndicadorController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	@ManagedProperty(value="#{indicadorDataManager}")
	private IndicadorDataManager indicadorDataManager;

	
	private HistoricoIndicadorDTO historicoIndicadorDTO;
	private HistoricoIndicadorDTO hisIndTemp;
	private EvidenciaDTO evidenciaDTO;
	
	private IndicadorDTO indicadorDTO;
	private IndicadorDTO indTemp;
	
	private Object modelo;
	private Object ies;
	
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private List<HistoricoIndicadorDTO> historicoIndicadorList;
	private List<EvidenciaDTO> evidenciaList;
	
	
	private CartesianChartModel categoryModel;  
	
	@PostConstruct
	private void init() throws IndicadoresException
	{
		indicadorDTO=new IndicadorDTO();
		modelo=indicadorDataManager.getModelo();
		ies=indicadorDataManager.getIes();
		obtenerArbol();
		historicoIndicadorList=new ArrayList<HistoricoIndicadorDTO>();
		historicoIndicadorDTO=new HistoricoIndicadorDTO();
		evidenciaDTO=new EvidenciaDTO();
		evidenciaList=new ArrayList<EvidenciaDTO>();
		initChart();
	}
	
	public void setIndicadorDataManager(IndicadorDataManager indicadorDataManager) {
		this.indicadorDataManager = indicadorDataManager;
	}

	public Object getModelo() {
		return modelo;
	}

	public void setModelo(Object modelo) {
		this.modelo = modelo;
	}

	public Object getIes() {
		return ies;
	}

	public void setIes(Object ies) {
		this.ies = ies;
	}
	
	public IndicadorDTO getIndicadorDTO() {
		return indicadorDTO;
	}

	public void setIndicadorDTO(IndicadorDTO indicadorDTO) {
		this.indicadorDTO = indicadorDTO;
	}
	
	public HistoricoIndicadorDTO getHistoricoIndicadorDTO() {
		return historicoIndicadorDTO;
	}


	public void setHistoricoIndicadorDTO(HistoricoIndicadorDTO historicoIndicadorDTO) {
		this.historicoIndicadorDTO = historicoIndicadorDTO;
	}


	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	
	public TreeNode getSelectedNode() {
		return selectedNode;
	}


	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}


	public EvidenciaDTO getEvidenciaDTO() {
		return evidenciaDTO;
	}


	public void setEvidenciaDTO(EvidenciaDTO evidenciaDTO) {
		this.evidenciaDTO = evidenciaDTO;
	}


	public List<HistoricoIndicadorDTO> getHistoricoIndicadorList() {
		return historicoIndicadorList;
	}


	public void setHistoricoIndicadorList(
			List<HistoricoIndicadorDTO> historicoIndicadorList) {
		this.historicoIndicadorList = historicoIndicadorList;
	}


	public List<EvidenciaDTO> getEvidenciaList() {
		return evidenciaList;
	}


	public void setEvidenciaList(List<EvidenciaDTO> evidenciaList) {
		this.evidenciaList = evidenciaList;
	}

	public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    } 

	public void obtenerArbol()
	{
		try {
			IesDTO iesDTO=new IesDTO();
			ModeloDTO modeloDTO=new ModeloDTO();
			if(getIes()!=null)
				iesDTO.setIesCodigo(Integer.parseInt(getIes().toString()));
			else
				return;
			if(getModelo()!=null)
				modeloDTO.setModCodigo(Integer.parseInt(getModelo().toString()));
			else
				return;
			getIndicadorDTO().setIndy(iesDTO);
			getIndicadorDTO().setIndModeloBean(modeloDTO);
			List<IndicadorDTO> indicaList=indicadorService.obtenerRaizIndicador(getIndicadorDTO());
			rootNode=new DefaultTreeNode(new IndicadorDTO(),null);
			if(indicaList!=null)
			{
				for(IndicadorDTO ind:indicaList)
				{
					newNodeWithChildren(ind, rootNode);
				}
			}			
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	@SuppressWarnings("unused")
	public TreeNode newNodeWithChildren(IndicadorDTO ttParent, TreeNode parent){
		parent.setExpanded(true);
        TreeNode newNode= new DefaultTreeNode(ttParent, parent);
        for (IndicadorDTO tt : ttParent.getIndIndicadors()){
             TreeNode newNode2= newNodeWithChildren(tt, newNode);
             
        }
        return newNode;
   }

//	public void onNodeSelect() {
//		try {
//			IndicadorDTO ind=(IndicadorDTO) selectedNode.getData();
//			indTemp=new IndicadorDTO();
//			indTemp=ind;
//			if(ind.getIndIndicadors().isEmpty()){
//				RequestContext rc = RequestContext.getCurrentInstance();
//				rc.execute("PF('dlgValor').show();");
//				
//				historicoIndicadorList=indicadorService.obtenerValores(indTemp);
//			}
//			else{
//				JsfUtil.addErrorMessage("Solo se permite en los nudos finales");
//			}
//		}
//		 catch (IndicadoresException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	public void onNodeSelect() {
		try {
			IndicadorDTO ind=(IndicadorDTO) selectedNode.getData();
			indTemp=new IndicadorDTO();
			indTemp=ind;
			setIndicadorDTO(new IndicadorDTO());
			setIndicadorDTO(indTemp);
			RequestContext rc = RequestContext.getCurrentInstance();
			if(ind.getIndIndicadors().isEmpty())
			{
				historicoIndicadorList=indicadorService.obtenerValores(indTemp);
				if(historicoIndicadorList!=null)
				{
					rc.execute("PF('dlgValorReporte').show();");
					createChartLine(historicoIndicadorList);
				}
				else
					JsfUtil.addErrorMessage("No existen datos en historial");
			}
			else
			{
				indicadorService.actualizarValores(indTemp);
				rc.execute("PF('dlgValorReporte').show();");
				indTemp=indicadorService.obtenerIndicador(indTemp.getIndCodigo());
				createChartLinePatern(indTemp.getIndIndicadors());
			}
		}
		 catch (Exception e) {
			 JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	
	  private void createChartLine(List<HistoricoIndicadorDTO> list)
      {
		  categoryModel = new CartesianChartModel();  
               
          ChartSeries data1 = new ChartSeries();  
          data1.setLabel("Indicador");  

	      for(HistoricoIndicadorDTO his:list)
	      {
	          data1.set(his.getHinFecha().toString(), his.getHinValor());
	      }
	     
	      categoryModel.addSeries(data1);    
      }

     
      private void createChartLinePatern(List<IndicadorDTO> list)
      {
          categoryModel = new CartesianChartModel();  
               
	      ChartSeries data1 = new ChartSeries();  
	      data1.setLabel("Indicador");  
	
	      for(IndicadorDTO ind:list)
	      {
	          data1.set(ind.getIndNombreCorto(), ind.getIndValorActual());
	      }
	     
	      categoryModel.addSeries(data1);    
      }


	private void initChart()
	{
		categoryModel = new CartesianChartModel();  
		  
        ChartSeries data1 = new ChartSeries();  
        data1.setLabel("Indicador");  
  
        
         data1.set("0", 1);
        
        
        categoryModel.addSeries(data1);    		
	}
	
	public void agregarValor()
	{
		try {
			getHistoricoIndicadorDTO().setHinFecha(new Timestamp(new Date().getTime()));
			getHistoricoIndicadorDTO().setIndIndicador(indTemp);
			indicadorService.agregarValor(getHistoricoIndicadorDTO());
			historicoIndicadorList=indicadorService.obtenerValores(indTemp);
			historicoIndicadorDTO=new HistoricoIndicadorDTO();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void buscarEvidencias(HistoricoIndicadorDTO his)
	{
		try {
			hisIndTemp=his;
			evidenciaList=indicadorService.obtenerEvidencias(hisIndTemp);
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void agregarEvidencia()
	{
		try {
			getEvidenciaDTO().setIndHistoricoIndicador(hisIndTemp);
			indicadorService.agregarEvidencia(getEvidenciaDTO());
			evidenciaDTO=new EvidenciaDTO();
			buscarEvidencias(hisIndTemp);
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void handleFileUpload(FileUploadEvent event) {  
		getEvidenciaDTO().setEviArchivo(event.getFile().getContents());
	    JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
	}

	
	public void descargarEvidencia(EvidenciaDTO evi)
	{
		if(evi.getEviArchivo()!=null)
		{
		byte[] pdfData = evi.getEviArchivo();
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

	    // Initialize response.
	    response.reset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
	    response.setContentType(JsfUtil.getTypeFile(pdfData)); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ServletContext#getMimeType() for auto-detection based on filename.
	    response.setHeader("Content-disposition", "attachment; filename=\"name.pdf\""); // The Save As popup magic is done here. You can give it any filename you want, this only won't work in MSIE, it will use current request URL as filename instead.

	    // Write file to response.
	    OutputStream output;
		try {
			output = response.getOutputStream();
		    output.write(pdfData);
		    output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}

	    // Inform JSF to not take the response in hands.
	    facesContext.responseComplete(); // Important! Else JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
		}
	}
	
}
