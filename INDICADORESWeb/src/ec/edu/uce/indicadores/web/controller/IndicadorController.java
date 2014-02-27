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
			
			iesDTO.setIesCodigo(Integer.parseInt(getIes().toString()));
			modeloDTO.setModCodigo(Integer.parseInt(getModelo().toString()));
			getIndicadorDTO().setIndy(iesDTO);
			getIndicadorDTO().setIndModeloBean(modeloDTO);
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
			indicadorList=indicadorService.obtenerIndicador();
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
		IndicadorDTO ind=(IndicadorDTO) selectedNode.getData();
		setIndicadorDTO(ind);
		setPredecesor(ind.getIndIndicador().getIndCodigo());
	}
	
}
