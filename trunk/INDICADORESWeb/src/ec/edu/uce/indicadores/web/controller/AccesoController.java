package ec.edu.uce.indicadores.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
import ec.edu.uce.indicadores.web.datamanager.IndicadorDataManager;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name="accesoController")
public class AccesoController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	@EJB
	private IndicadorService indicadorService;
	
	@ManagedProperty(value="#{indicadorDataManager}")
	private IndicadorDataManager indicadorDataManager;

	
	private Object pefilSelect;
	
	private List<PerfilDTO> perfilList;
	
	private List<String> opcionSelect;
	
	private List<OpcionDTO> opcionCheck;
	
	private Map<String,OpcionDTO> checkList; 
	
	private Object modelo;
	private Object ies;

	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private TreeNode[] selectedNodes;
	
	private IndicadorDTO indicadorDTO;
	
	private Boolean disabled;
	
	public AccesoController() {
	}
	
	@PostConstruct
	private void init()	{
		indicadorDTO=new IndicadorDTO();
		perfilList=new ArrayList<PerfilDTO>(); 
		opcionCheck=new ArrayList<OpcionDTO>();
		opcionSelect=new ArrayList<String>();
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
	
	public IndicadorDataManager getIndicadorDataManager() {
		return indicadorDataManager;
	}

	public void setIndicadorDataManager(IndicadorDataManager indicadorDataManager) {
		this.indicadorDataManager = indicadorDataManager;
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

	public IndicadorDTO getIndicadorDTO() {
		return indicadorDTO;
	}

	public void setIndicadorDTO(IndicadorDTO indicadorDTO) {
		this.indicadorDTO = indicadorDTO;
	}
	
	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
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
	
	public Object getPefilSelect() {
		return pefilSelect;
	}

	public void setPefilSelect(Object pefilSelect) {
		this.pefilSelect = pefilSelect;
	}
	
	public List<PerfilDTO> getPerfilList() {
		try {
			perfilList=administracionService.readPerfil();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return perfilList;
	}

	public void setPerfilList(List<PerfilDTO> perfilList) {
		this.perfilList = perfilList;
	}


	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public Map<String, OpcionDTO> getCheckList() {
		return checkList;
	}

	public List<OpcionDTO> getOpcionCheck() {
		return opcionCheck;
	}

	public void setOpcionCheck(List<OpcionDTO> opcionCheck) {
		this.opcionCheck = opcionCheck;
	}

	public List<String> getOpcionSelect() {
		return opcionSelect;
	}

	public void setOpcionSelect(List<String> opcionSelect) {
		this.opcionSelect = opcionSelect;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public void readAcceso()
	{
		PerfilDTO perfil;
		try {
			checkList=new HashMap<String,OpcionDTO>();
			perfil=new PerfilDTO();
			perfil.setPerCodigo(Integer.valueOf(getPefilSelect().toString()));
			opcionCheck=administracionService.readOpcion();

			opcionSelect=new ArrayList<String>();
			for(OpcionDTO opt: administracionService.readOpcion(perfil))
			{
				opcionSelect.add(opt.getOpcCodigo().toString());
			}
			
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void save()
	{
		try {
			administracionService.createAcceso(opcionSelect, pefilSelect);
			readAcceso();
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
	
	
	
	
	
	
	
}
