package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import ec.edu.uce.erpmunicipal.sistema.bsl.RolOptionService;
import ec.edu.uce.erpmunicipal.sistema.bsl.RolService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRole;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuarioRol;

@ManagedBean(name = "rolOptionPage")
@ViewScoped
public class RolOptionPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "rolService/local")
	private RolService rolService;

	@EJB(name = "rolOptionService/local")
	private RolOptionService rolOptionService;

	private List<SisRole> rols;

	private int rolCode;

	private TreeNode root;
	private TreeNode[] selectedNodes;
	private List<SisPantalla> optionsMemory;

	public RolOptionPage() {
		rols = new ArrayList<SisRole>();
		rolCode = 0;
	}

	/**
	 * @return the rols
	 */
	public List<SisRole> getRols() {
		return rols;
	}

	/**
	 * @param rols
	 *            the rols to set
	 */
	public void setRols(List<SisRole> rols) {
		this.rols = rols;
	}

	/**
	 * @return the treeNode
	 */
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * @param treeNode
	 *            the treeNode to set
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	/**
	 * @return the selectedNodes
	 */
	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	/**
	 * @param selectedNodes
	 *            the selectedNodes to set
	 */
	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	/**
	 * @return the rolCode
	 */
	public int getRolCode() {
		return rolCode;
	}

	/**
	 * @param rolCode
	 *            the rolCode to set
	 */
	public void setRolCode(int rolCode) {
		this.rolCode = rolCode;
	}

	private void readRols() {
		int rol = ((SisUsuarioRol) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("rol")).getSisRole()
				.getRolCodigo();
		rols = rolService.readAll(rol);
	}

	private void readTree() {
		root = new DefaultTreeNode(new SisPantalla(), null);
		root.setExpanded(true);
		optionsMemory = new ArrayList<SisPantalla>();
		List<SisModulo> listModule = rolOptionService.readModules();

		if (listModule.size() > 0) {
			for (SisModulo tempModule : listModule) {

				SisPantalla temp = new SisPantalla();
				temp.setPanDescripcion(tempModule.getModDescripcion());
				TreeNode node1 = new DefaultTreeNode(temp, root);
				node1.setExpanded(true);
				List<SisPantalla> listOption = rolOptionService.readOptions(
						rolCode, tempModule.getModCodigo());

				for (SisPantalla tempPan : listOption) {
					if (rolOptionService.isFather(tempPan.getPanCodigo())) {
						TreeNode node3 = new DefaultTreeNode(tempPan, node1);
						node3.setExpanded(true);
						optionsMemory.add(tempPan);
						node(tempPan, tempModule.getModCodigo(), node3);
						
					} else {
						TreeNode node2 = new DefaultTreeNode(tempPan, node1);
						optionsMemory.add(tempPan);
						if (tempPan.getSisRolPermisos().get(0).getRopCodigo() != 0)
							node2.setSelected(true);
					}
				}
			}
		}
	}

	private void node(SisPantalla opt, int module, TreeNode nodeFather) {
		for (SisPantalla temp : rolOptionService.readChildren(rolCode, module,
				opt.getPanCodigo())) {
			if (rolOptionService.isFather(temp.getPanCodigo())) {
				TreeNode node1 = new DefaultTreeNode(temp, nodeFather);
				node1.setExpanded(true);
				optionsMemory.add(temp);
				node(temp, module, node1);
			} else {
				TreeNode node = new DefaultTreeNode(temp, nodeFather);
				optionsMemory.add(temp);
				if (opt.getSisRolPermisos().get(0).getRopCodigo() != 0)
					node.setSelected(true);
			}
		}
	}

	public void rolChange() {
		readTree();
	}

	public void updateClick(ActionEvent event) {
		if (rolCode > 0) {
			if (selectedNodes != null && selectedNodes.length > 0) {
				
				for (TreeNode node : selectedNodes) {
					SisPantalla optionNode = (SisPantalla) node.getData();
					
					if (optionNode.getPanCodigo() != null) {
						rolOptionService.update(optionNode.getPanCodigo(),
								rolCode, true);
						optionsMemory.remove(optionNode);
						optionNode.setPanUrl("Insertado");
						optionsMemory.add(optionNode);
					}
				}
			}
			for (SisPantalla op : optionsMemory) {
				
				if (op.getPanCodigo() != null) {
					
					if (!op.getPanUrl().equals("Insertado"))
						rolOptionService.update(op.getPanCodigo(), rolCode,
								false);
				}
			}
		}
		readTree();
	}

	@PostConstruct
	public void init() {
		readRols();
		// readTree();
	}
}
