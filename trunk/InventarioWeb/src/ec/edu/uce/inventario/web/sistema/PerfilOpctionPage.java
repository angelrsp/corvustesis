package ec.edu.uce.inventario.web.sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import ec.edu.uce.inventario.entidades.SisModulo;
import ec.edu.uce.inventario.entidades.SisOpcion;
import ec.edu.uce.inventario.entidades.SisPerfil;
import ec.edu.uce.inventario.sistema.servicio.PerfilOpcionService;
import ec.edu.uce.inventario.sistema.servicio.PerfilService;


@ManagedBean(name = "perfilOpctionPage")
@ViewScoped
public class PerfilOpctionPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	   @EJB(name = "rolService/local")
	    private PerfilService perfilService;

	    @EJB(name = "rolOptionService/local")
	    private PerfilOpcionService perfilOpcionService;
	    
	    private List<SisPerfil> perfiles;

	    private int perfilCode;

	    private TreeNode root;
	    private TreeNode[] selectedNodes;
	    private List<SisOpcion> optionsMemory;

	    public PerfilOpctionPage() {
	    	perfiles = new ArrayList<SisPerfil>();
	    	perfilCode = 0;
	    }

	    /**
	     * @return the rols
	     */
	    public List<SisPerfil> getPerfiles() {
	        return perfiles;
	    }

	    /**
	     * @param rols
	     *            the rols to set
	     */
	    public void setPerfiles(List<SisPerfil> perfiles) {
	        this.perfiles = perfiles;
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
	    public int getPerfilCode() {
	        return perfilCode;
	    }

	    /**
	     * @param rolCode
	     *            the rolCode to set
	     */
	    public void setPerfilCode(int perfilCode) {
	        this.perfilCode = perfilCode;
	    }

	    private void readPerfiles() {
	        perfiles = perfilService.readAll();
	    }

	    private void readTree() {
	        root = new DefaultTreeNode(new SisOpcion(), null);
	        root.setExpanded(true);
	        optionsMemory = new ArrayList<SisOpcion>();
	        List<SisModulo> listModule = perfilOpcionService.readModules();

	        if (listModule.size() > 0) {
	            for (SisModulo tempModule : listModule) {

	                SisOpcion temp = new SisOpcion();
	                temp.setOpcNombre(tempModule.getModDescripcion());
	                TreeNode node1 = new DefaultTreeNode(temp, root);
	                node1.setExpanded(true);
	                List<SisOpcion> listOption = perfilOpcionService.readOptions(
	                        perfilCode, tempModule.getModCodigo());

	                for (SisOpcion tempPan : listOption) {
	                    if (perfilOpcionService.isFather(tempPan.getOpcCodigo())) {
	                        TreeNode node3 = new DefaultTreeNode(tempPan, node1);
	                        node3.setExpanded(true);
	                        optionsMemory.add(tempPan);
	                        node(tempPan, tempModule.getModCodigo(), node3);
	                    } else {
	                        TreeNode node2 = new DefaultTreeNode(tempPan, node1);
	                        optionsMemory.add(tempPan);
	                        if (tempPan.getSisPerfilOpcions().get(0).getPopCodigo() != 0)
	                            node2.setSelected(true);
	                    }
	                }
	            }
	        }
	    }

	    private void node(SisOpcion opt, int module, TreeNode nodeFather) {
	        for (SisOpcion temp : perfilOpcionService.readChildren(perfilCode, module,
	                opt.getOpcCodigo())) {
	            if (perfilOpcionService.isFather(temp.getOpcCodigo())) {
	                TreeNode node1 = new DefaultTreeNode(temp, nodeFather);
	                node1.setExpanded(true);
	                optionsMemory.add(temp);
	                node(temp, module, node1);
	            } else {
	                TreeNode node = new DefaultTreeNode(temp, nodeFather);
	                optionsMemory.add(temp);
	                if (opt.getSisPerfilOpcions().get(0).getPopCodigo() != 0)
	                    node.setSelected(true);
	            }
	        }
	    }

	    public void rolChange() {
	        readTree();
	    }

	    public void updateClick(ActionEvent event) {
	        if (perfilCode > 0) {
	            if (selectedNodes != null && selectedNodes.length > 0) {
	               
	                for (TreeNode node : selectedNodes) {
	                    SisOpcion optionNode = (SisOpcion) node.getData();
	                   
	                    if (optionNode.getOpcCodigo() != null) {
	                    	perfilOpcionService.update(optionNode.getOpcCodigo(),
	                                perfilCode, true);
	                        optionsMemory.remove(optionNode);
	                        optionNode.setOpcUrl("Insertado");
	                        optionsMemory.add(optionNode);
	                    }
	                }
	            }
	            for (SisOpcion op : optionsMemory) {
	               
	                if (op.getOpcCodigo() != null) {
	                   
	                    if (!op.getOpcUrl().equals("Insertado"))
	                        perfilOpcionService.update(op.getOpcCodigo(), perfilCode,
	                                false);
	                }
	            }
	        }
	        readTree();
	    }

	    @PostConstruct
	    public void init() {
	        readPerfiles();
	        // readTree();
	    }
	
}
