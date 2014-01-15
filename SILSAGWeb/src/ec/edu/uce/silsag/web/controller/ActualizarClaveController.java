package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "actualizarClaveController")
public class ActualizarClaveController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;

	private UsuarioDTO usuario;

	public ActualizarClaveController() {

	}

	@PostConstruct
	private void init() {
		usuario = new UsuarioDTO();
		usuario = (UsuarioDTO) JsfUtil.getObject("UsuarioDTO");
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public void actualizar() {
		try {
			administracionService.actualizarClave(usuario);
			JsfUtil.addInfoMessage("Contraseña cambiada exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

}
