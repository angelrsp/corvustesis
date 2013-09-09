package ec.edu.uce.erpmunicipal.contabilidad.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.AccoutingService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConTipoCuenta;
import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;

@ManagedBean(name = "accountingPage")
@ViewScoped
public class AccountingPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "accoutingService/local")
	private AccoutingService accoutingService;
	@EJB(name = "crudService/local")
	private CrudService crudService;

	private List<ConTipoCuenta> accTypes;
	List<ConCuenta> accounts;

	private int accTypeCode;

	private TreeNode root;

	private TreeNode selectedNode;

	private String code1;
	private String code2;
	private String description;
	private Boolean move;

	private Boolean edit;

	private ConCuenta cuenta;

	public AccountingPage() {
		accTypes = new ArrayList<ConTipoCuenta>();
		cuenta = new ConCuenta();
		code1 = "";
		move = true;
		edit = false;
		accTypeCode = 0;
	}

	/**
	 * @return the move
	 */
	public Boolean getMove() {
		return move;
	}

	/**
	 * @param move
	 *            the move to set
	 */
	public void setMove(Boolean move) {
		this.move = move;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the code1
	 */
	public String getCode1() {
		return code1;
	}

	/**
	 * @param code1
	 *            the code1 to set
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}

	/**
	 * @return the code2
	 */
	public String getCode2() {
		return code2;
	}

	/**
	 * @param code2
	 *            the code2 to set
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	/**
	 * @return the accTypeCode
	 */
	public int getAccTypeCode() {
		return accTypeCode;
	}

	/**
	 * @param accTypeCode
	 *            the accTypeCode to set
	 */
	public void setAccTypeCode(int accTypeCode) {
		this.accTypeCode = accTypeCode;
	}

	/**
	 * @return the accTypes
	 */
	public List<ConTipoCuenta> getAccTypes() {
		return accTypes;
	}

	/**
	 * @param accTypes
	 *            the accTypes to set
	 */
	public void setAccTypes(List<ConTipoCuenta> accTypes) {
		this.accTypes = accTypes;
	}

	/**
	 * @return the root
	 */
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	/**
	 * @return the selectedNode
	 */
	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	/**
	 * @param selectedNode
	 *            the selectedNode to set
	 */
	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	private void readAccounts() {
		root = new DefaultTreeNode(new ConCuenta(), null);
		root.setExpanded(true);
		accounts = new ArrayList<ConCuenta>();
		List<ConCuenta> accAux = new ArrayList<ConCuenta>();
		accAux = accoutingService.readFirstAccountings();

		if (accAux.size() > 0) {
			for (ConCuenta ac : accAux) {
				TreeNode node1 = new DefaultTreeNode(ac, root);
				//node1.setExpanded(true);

				List<ConCuenta> acc = new ArrayList<ConCuenta>();
				acc = accoutingService.readChildren(ac.getCueCodigo());
				accounts.add(ac);
				for (ConCuenta tempAcc : acc) {
					if (accoutingService.isfather(tempAcc.getCueCodigo())) {
						TreeNode node2 = new DefaultTreeNode(tempAcc, node1);
						//node2.setExpanded(true);
						
						accounts.add(tempAcc);
						node(tempAcc, node2);
					} else {
						TreeNode node3 = new DefaultTreeNode(tempAcc, node1);
						//node3.setExpanded(true);
						accounts.add(tempAcc);
					}
				}
			}
		}
	}

	private void node(ConCuenta account, TreeNode nodeIn) {
		for (ConCuenta temp : accoutingService.readChildren(account
				.getCueCodigo())) {
			if (accoutingService.isfather(temp.getCueCodigo())) {
				TreeNode node1 = new DefaultTreeNode(temp, nodeIn);
				//node1.setExpanded(true);
				node(temp, node1);
				accounts.add(temp);
			} else {
				TreeNode node2 = new DefaultTreeNode(temp, nodeIn);
				//node2.setExpanded(true);
				accounts.add(temp);
			}
		}
	}

	private void clean() {
		code1 = "";
		code2 = "";
		description = "";
		cuenta = new ConCuenta();
		edit = false;
	}

	private void readAccType() {
		accTypes = accoutingService.readAccountingType();
	}

	public void newClick() {
		clean();
	}

	public void saveClick() {
		FacesMessage msg = null;
		try {
			if (accTypeCode == 0) {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"Seleccione Tipo de Cuenta.");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return;
			}
			int entidad= ((SisUsuario) FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap().get("user")).getSisInstitucion().getInsCodigo();
			if (edit) {
				ConCuenta cue = new ConCuenta();
				ConTipoCuenta type = new ConTipoCuenta();
				type.setTcuCodigo(accTypeCode);
				cue.setConTipoCuenta(type);
				cue.setCuePermiteMovimiento(move);
				if (cuenta.getCueCodigo() != null)
					cue.setCueCodigoPadre(cuenta.getCueCodigoPadre());
				else
					cue.setCueCodigoPadre(0);
				cue.setCueNumero(code1 + code2);
				cue.setCueSubcuenta(Integer.valueOf(code2));
				cue.setCueDescripcion(description);
				cue.setCueCodigo(cuenta.getCueCodigo());
				cue.setCueEntidad(entidad);
				crudService.update(cue);
			} else {
				ConCuenta cue = new ConCuenta();
				ConTipoCuenta type = new ConTipoCuenta();
				type.setTcuCodigo(accTypeCode);
				cue.setConTipoCuenta(type);
				cue.setCuePermiteMovimiento(move);
				if (cuenta.getCueCodigo() != null)
					cue.setCueCodigoPadre(cuenta.getCueCodigo());
				else
					cue.setCueCodigoPadre(0);
				cue.setCueNumero(code1 + code2);
				cue.setCueSubcuenta(Integer.valueOf(code2));
				cue.setCueDescripcion(description);
				cue.setCueEntidad(entidad);
				
				crudService.create(cue);
			}
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion",
					"Guardado Exitosamente");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					e.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		readAccounts();
		clean();
	}

	public void changeClick() {
		FacesMessage msg = null;
		try {
			if (cuenta.getCueCodigo() != null) {
				String[] aux = cuenta.getCueNumero().split("\\.");
				code2 = aux[aux.length - 1];
				code1 = "";
				for (int i = 0; i < aux.length - 1; i++)
					code1 = code1 + aux[i] + ".";
				description = cuenta.getCueDescripcion();
				edit = true;
			} else {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Informacion", "Seleccione una cuenta para editar");

				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (Exception e) {
		}
	}

	public void onNodeSelect(NodeSelectEvent event) {
		cuenta = new ConCuenta();
		cuenta = (ConCuenta) event.getTreeNode().getData();
		code1 = cuenta.getCueNumero() + ".";
		code2 = "";
		move = cuenta.getCuePermiteMovimiento();
		accTypeCode=cuenta.getConTipoCuenta().getTcuCodigo();
	}

	@PostConstruct
	public void init() {
		readAccType();
		readAccounts();
	}
}
