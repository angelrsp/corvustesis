package ec.edu.uce.indicadores.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.web.datamanager.IndicadorDataManager;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "indicadorController")
public class IndicadorController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private IndicadorService indicadorService;
	
	@ManagedProperty(value="#{indicadorDataManager}")
	private IndicadorDataManager indicadorDataManager;
	
	private IndicadorDTO indicadorDTO;
	
	private Object modelo;
	private Object ies;
	
	private int predecesor;
	
	List<IndicadorDTO> indicadorList;
	
	private TreeNode rootNode;

	private Boolean disabled;
	
	private TreeNode selectedNode;
	
	private Object tipoIndicador;
	
	@PostConstruct
	private void init() throws IndicadoresException
	{
		indicadorDTO=new IndicadorDTO();
		indicadorList=new ArrayList<IndicadorDTO>();
//		indicadorList=indicadorService.obtenerIndicador();
		
		if(indicadorDataManager.getIes()!=null)
			ies=indicadorDataManager.getIes();
		else{
			try {
				JsfUtil.redirect("home.jsf");
			} catch (IOException e) {
				JsfUtil.addErrorMessage(e.toString());
			}
		}
		
		
		modelo=indicadorDataManager.getModelo();
		
		obtenerArbol();
		disabled=true;
	}

	public void setIndicadorDataManager(IndicadorDataManager indicadorDataManager) {
		this.indicadorDataManager = indicadorDataManager;
	}

	public IndicadorDTO getIndicadorDTO() {
		return indicadorDTO;
	}

	public void setIndicadorDTO(IndicadorDTO indicadorDTO) {
		this.indicadorDTO = indicadorDTO;
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
	
	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public List<IndicadorDTO> getIndicadorList() {
		return indicadorList;
	}

	public void setIndicadorList(List<IndicadorDTO> indicadorList) {
		this.indicadorList = indicadorList;
	}

	public int getPredecesor() {
		return predecesor;
	}

	public void setPredecesor(int predecesor) {
		this.predecesor = predecesor;
	}

	public Object getTipoIndicador() {
		return tipoIndicador;
	}

	public void setTipoIndicador(Object tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void agregarIndicador()
	{
		try {
			IesDTO iesDTO=new IesDTO();
			ModeloDTO modeloDTO=new ModeloDTO();
			IndicadorDTO predecesor=new IndicadorDTO();
			
			if(getPredecesor()>0){
				predecesor.setIndCodigo(getPredecesor());
				getIndicadorDTO().setIndIndicador(predecesor);
			}
			
			if(getIndicadorDTO().getIndValorIdeal().doubleValue()<getIndicadorDTO().getIndValorObjetivo().doubleValue())
			{
				JsfUtil.addErrorMessage("El valor ideal no puede ser menor al valor objetivo");
				return;
			}
			
			
			iesDTO.setIesCodigo(Integer.parseInt(getIes().toString()));
			modeloDTO.setModCodigo(Integer.parseInt(getModelo().toString()));
			getIndicadorDTO().setIndy(iesDTO);
			getIndicadorDTO().setIndModeloBean(modeloDTO);
			getIndicadorDTO().setIndTipo(Integer.valueOf(getTipoIndicador().toString()));
			indicadorService.createOrUpdateIndicador(getIndicadorDTO());
			indicadorDTO=new IndicadorDTO();
			obtenerArbol();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
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
			indicadorList=indicadorService.obtenerIndicador(modeloDTO);
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
		TreeNode newNode= new DefaultTreeNode(ttParent, parent);
        try {
    		parent.setExpanded(true);
			for (IndicadorDTO tt : indicadorService.obtenerHijosIndicador(ttParent)){
			     TreeNode newNode2= newNodeWithChildren(tt, newNode);
			}
		} catch (IndicadoresException e) {
			e.printStackTrace();
		}
        return newNode;
   }

	public void delete()
	{
		try {
			if(getIndicadorDTO().getIndCodigo()!=null)
				indicadorService.deleteIndicador(getIndicadorDTO());
			else
				JsfUtil.addErrorMessage("Selecione indicador a eliminar");
			obtenerArbol();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void cancel()
	{
		setIndicadorDTO(new IndicadorDTO());
		setPredecesor(0);
	}
	
	public void onNodeSelect() {
		//try {
			IndicadorDTO ind=(IndicadorDTO) selectedNode.getData();
			setIndicadorDTO(ind);
			if(ind.getIndIndicador()!=null)
				setPredecesor(ind.getIndIndicador().getIndCodigo());
			else
				setPredecesor(0);	
			setTipoIndicador(ind.getIndTipo());			
//		} catch (Exception e) {
//			JsfUtil.addErrorMessage(e.toString());
//		}
		
	}
	
}
