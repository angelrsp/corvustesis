package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.EvidenciaDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
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
	
	@PostConstruct
	private void init() throws IndicadoresException
	{
		indicadorDTO=new IndicadorDTO();
		obtenerArbol();
		historicoIndicadorList=new ArrayList<HistoricoIndicadorDTO>();
		historicoIndicadorDTO=new HistoricoIndicadorDTO();
		evidenciaDTO=new EvidenciaDTO();
		evidenciaList=new ArrayList<EvidenciaDTO>();
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


	private void obtenerArbol()
	{
		try {
			IesDTO iesDTO=new IesDTO();
			ModeloDTO modeloDTO=new ModeloDTO();
			if(getIes()!=null)
				iesDTO.setIesCodigo(Integer.parseInt(getIes().toString()));
			else
				iesDTO.setIesCodigo(0);
			if(getModelo()!=null)
				modeloDTO.setModCodigo(Integer.parseInt(getModelo().toString()));
			else
				modeloDTO.setModCodigo(0);
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

	public void onNodeSelect() {
		try {
			IndicadorDTO ind=(IndicadorDTO) selectedNode.getData();
			indTemp=new IndicadorDTO();
			indTemp=ind;
			if(ind.getIndIndicadors().isEmpty())
			{
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('dlgValor').show();");
				
				historicoIndicadorList=indicadorService.obtenerValores(indTemp);
			}
			else
			{
				JsfUtil.addErrorMessage("Solo se permite en los nudos finales");
			}
		}
		 catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void buscarEvidencias(HistoricoIndicadorDTO his)
	{
		try {
			hisIndTemp=his;
			evidenciaList=indicadorService.obtenerEvidencias(hisIndTemp);
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
