package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "reporteIndicadorController")
public class ReporteIndicadorController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	private Object modelo;
	private Object ies;
	
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private IndicadorDTO indicadorDTO;
	private IndicadorDTO indTemp;
	
	private List<HistoricoIndicadorDTO> historicoIndicadorList;
	
	private CartesianChartModel categoryModel;  
	
	public ReporteIndicadorController() {
		categoryModel=new CartesianChartModel();
		initChart();
	}
	
	@PostConstruct
	private void init()
	{
		indicadorDTO=new IndicadorDTO();
		historicoIndicadorList=new ArrayList<HistoricoIndicadorDTO>();
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

	public List<HistoricoIndicadorDTO> getHistoricoIndicadorList() {
		return historicoIndicadorList;
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
}
