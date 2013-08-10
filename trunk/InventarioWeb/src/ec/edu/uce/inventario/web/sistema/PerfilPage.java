package ec.edu.uce.inventario.web.sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.inventario.entidades.SisPerfil;
import ec.edu.uce.inventario.sistema.servicio.CrudService;
import ec.edu.uce.inventario.sistema.servicio.PerfilService;


@ManagedBean(name = "perfilPage")
@ViewScoped
public class PerfilPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "crudService/local")
	private CrudService crudService;
	@EJB(name = "perfilService/local")
	private PerfilService perfilService;

	private SisPerfil perfil;

	private List<SisPerfil> perfiles;

	public PerfilPage() {
		perfil = new SisPerfil();
		perfiles = new ArrayList<SisPerfil>();
	}

	public SisPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(SisPerfil perfil) {
		this.perfil = perfil;
	}

	public List<SisPerfil> getPerfiles() {
		this.perfiles = perfilService.readAll();
		return perfiles;
	}

	public void setPerfiles(List<SisPerfil> perfiles) {
		this.perfiles = perfiles;
	}

	public void create() {
		FacesMessage msg = null;
		try {
			if (perfilService.existsName(perfil.getPrlDescripcion())) {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"Ya existe la descripcion");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return;
			}

			if (perfil.getPrlCodigo() == null) {
				crudService.create(perfil);
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado",
						"Exitosamente");
			} else {
				crudService.update(perfil);
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
		getPerfiles();
	}

	
	public void onRowSelect(SelectEvent event)
	{
		this.perfil=new SisPerfil();
		this.perfil=(SisPerfil)event.getObject();
	}
	
	public void clean() {
		perfil = new SisPerfil();
	}

}
