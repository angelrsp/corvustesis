package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.erpmunicipal.sistema.bsl.AuditService;
import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;
import ec.edu.uce.erpmunicipal.sistema.bsl.EntityService;
import ec.edu.uce.erpmunicipal.sistema.bsl.RolService;
import ec.edu.uce.erpmunicipal.sistema.bsl.UserService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisAuditoriaMenu;
import ec.edu.uce.erpmunicipal.sistema.orm.SisInstitucion;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRole;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuarioRol;
import ec.edu.uce.erpmunicipal.util.web.Identification;

@ManagedBean(name = "userPage")
@ViewScoped
public class UserPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SisInstitucion> entities;
	private List<SisUsuario> users;
	private List<SisRole> rols;

	private int entityCode;
	private int rolCode;

	private SisUsuario user;
	private SisInstitucion entity;

	@EJB(name = "entityService/local")
	private EntityService entityService;
	@EJB(name = "userService/local")
	private UserService userService;
	@EJB(name = "crudService/local")
	private CrudService crudService;
	@EJB(name = "rolService/local")
	private RolService rolService;
	@EJB(name = "auditService/local")
	private AuditService auditService;

	public UserPage() {
		super();
		entity = new SisInstitucion();
		entities = new ArrayList<SisInstitucion>();
		users = new ArrayList<SisUsuario>();
		rols = new ArrayList<SisRole>();
		entityCode = 0;
		rolCode = 0;
		clean();
	}

	public SisUsuario getUser() {
		return user;
	}

	public void setUser(SisUsuario user) {
		this.user = user;
	}

	public SisInstitucion getEntity() {
		return entity;
	}

	public void setEntity(SisInstitucion entity) {
		this.entity = entity;
	}

	public List<SisInstitucion> getEntities() {
		SisUsuario user = (SisUsuario) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");
		int rol = ((SisUsuarioRol) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("rol")).getSisRole()
				.getRolCodigo();
		entities = entityService.readAll(user, rol);
		return entities;
	}

	public int getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(int entityCode) {
		this.entityCode = entityCode;
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

	public List<SisUsuario> getUsers() {
		return users;
	}

	public void setUsers(List<SisUsuario> users) {
		this.users = users;
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

	public void readUsers() {
		setUsers(userService.readAll(entityCode));
	}

	private void readRols() {
		int rol = ((SisUsuarioRol) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("rol")).getSisRole()
				.getRolCodigo();
		rols = rolService.readAll(rol);
	}

	public void clean() {
		user = new SisUsuario();
		user.setUsuActivo(true);
		user.setUsuApellidos(null);
		user.setUsuCelular(null);
		user.setUsuClave(null);
		user.setUsuCodigo(null);
		user.setUsuIdentifiacion(null);
		user.setUsuLogin(null);
		user.setUsuMail(null);
		user.setUsuNombres(null);
		user.setUsuTelefono(null);
		user.setUsuDireccion(null);
	}

	public void create() {
		FacesMessage msg = null;
		try {

			if (this.entityCode == 0) {
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Seleccione Institucion", "Intente nuevamente");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return;
			}
			if (this.rolCode == 0) {
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Seleccione Perfil", "Intente nuevamente");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return;
			}

			if (user.getUsuCodigo() == null) {
				if (userService.existsUser(user.getUsuLogin())) {
					msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
							"El usuario ya existe",
							"Intente nuevamente con otra palabra");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					return;
				}
				Identification identi = new Identification();
				if (!identi.isCedula(user.getUsuIdentifiacion())) {
					msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Cédula no valida", "Intente nuevamente");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					return;
				}
				entity = new SisInstitucion();
				entity = findEntity(this.entityCode);
				user.setUsuCodigo(null);
				user.setSisInstitucion(entity);

				userService.create(user, rolCode);

				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado",
						"Exitosamente");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				crudService.update(user);
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Actualizado", "Exitosamente");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			clean();

		} catch (Exception e) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					e.toString());

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		readUsers();
	}

	public void onRowSelect(SelectEvent event) {
		user = new SisUsuario();
		setUser((SisUsuario) event.getObject());
	}

	private SisInstitucion findEntity(int value) {
		boolean exists = false;
		int index = 0;
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).getInsCodigo() == value) {
				exists = true;
				index = i;
				break;
			}
		}
		if (exists)
			return entities.get(index);
		else
			return null;
	}

	private void auditMenu() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			SisAuditoriaMenu audit = new SisAuditoriaMenu();

			audit.setAmeDipositivo(request.getRemoteHost());
			audit.setAmeOpcion(2);
			audit.setSisUsuario((SisUsuario) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("user"));

			auditService.create(audit);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					e.toString()));
		}
	}

	@PostConstruct
	public void initForm() {
		setEntityCode(0);
		readUsers();
		readRols();
		auditMenu();
	}

}
