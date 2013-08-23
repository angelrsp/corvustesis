package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;
import ec.edu.uce.erpmunicipal.sistema.bsl.RolService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRole;
import ec.edu.uce.erpmunicipal.util.orm.SessionObject;

@ManagedBean(name = "rolPage")
@ViewScoped
public class RolPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "rolService/local")
	private RolService rolService;

	@EJB(name = "crudService/local")
	private CrudService crudService;

	private SisRole rol;

	private List<SisRole> rols;

	public RolPage() {
		rol = new SisRole();
		rols = new ArrayList<SisRole>();
	}

	public SisRole getRol() {
		return rol;
	}

	public void setRol(SisRole rol) {
		this.rol = rol;
	}

	public List<SisRole> getRols() {
		int rol = ((SessionObject) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("sessionObject")).getUserRol().getSisRole()
				.getRolCodigo();
		rols = rolService.readAll(rol);
		return rols;
	}

	public void setRols(List<SisRole> rols) {
		this.rols = rols;
	}

	public void create() {
		FacesMessage msg = null;
		try {
			if(rolService.existsName(rol.getRolDescripcion()))
			{
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ya existe la descripcion");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return;
			}
				
			if (rol.getRolCodigo() == null) {
				crudService.create(rol);
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado",
						"Exitosamente");
			} else {
				crudService.update(rol);
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Actualizado", "Exitosamente");
			}
			clean();
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					e.toString());

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		getRols();
	}

	public void clean() {
		rol = new SisRole();
	}

	public void onRowSelect(SelectEvent event) {
		rol = new SisRole();
		setRol((SisRole) event.getObject());
	}

}
