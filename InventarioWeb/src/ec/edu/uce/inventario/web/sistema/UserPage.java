package ec.edu.uce.inventario.web.sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.inventario.entidades.SisPerfil;
import ec.edu.uce.inventario.entidades.SisUsuario;
import ec.edu.uce.inventario.sistema.servicio.CrudService;
import ec.edu.uce.inventario.sistema.servicio.PerfilService;
import ec.edu.uce.inventario.sistema.servicio.UserService;


@ManagedBean(name = "userPage")
@ViewScoped
public class UserPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "crudService/local")
	private CrudService crudService;
	@EJB(name = "userService/local")
	private UserService userService;
	@EJB(name = "perfilService/local")
	private PerfilService perfilService;

	private SisUsuario user;
	private int perfilCode;

	private List<SisUsuario> users;
	private List<SisPerfil> perfiles;

	public UserPage() {
		user = new SisUsuario();
		users = new ArrayList<SisUsuario>();
		perfiles = new ArrayList<SisPerfil>();
	}

	public List<SisUsuario> getUsers() {
		return users;
	}

	public void setUsers(List<SisUsuario> users) {
		this.users = users;
	}

	public List<SisPerfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<SisPerfil> perfiles) {
		this.perfiles = perfiles;
	}

	public SisUsuario getUser() {
		return user;
	}

	public void setUser(SisUsuario user) {
		this.user = user;
	}

	public int getPerfilCode() {
		return perfilCode;
	}

	public void setPerfilCode(int perfilCode) {
		this.perfilCode = perfilCode;
	}

	public void clean() {
		user = new SisUsuario();
		user.setUsrCodigo(null);
	}

	public void create() {
		FacesMessage msg = null;
		try {

			if (user.getUsrCodigo() == null) {
				if (userService.existsUser(user.getUsrLogin())) {
					msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
							"El usuario ya existe",
							"Intente nuevamente con otra palabra");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					return;
				}
				user.setUsrCodigo(null);

				userService.create(user, perfilCode);

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

	public void readUsers() {
		setUsers(userService.readAll());
	}

	private void readPerfiles() {
		perfiles = perfilService.readAll();
	}
	
	public void onRowSelect(SelectEvent event)
	{
		user=new SisUsuario();
		user=(SisUsuario)event.getObject();
		perfilCode=user.getSisPerfil().getPrlCodigo();
	}
	
    @PostConstruct
    public void initForm() {
        readUsers();
        readPerfiles();
    } 

}
