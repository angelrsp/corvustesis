package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "loginAdminDataManager")
public class LoginAdminDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuarioDTO;
	
	public LoginAdminDataManager() {
		usuarioDTO=new UsuarioDTO();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	
}
