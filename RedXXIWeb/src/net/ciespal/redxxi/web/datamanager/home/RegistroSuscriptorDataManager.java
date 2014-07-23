package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name="registroSuscriptorDataManager")
public class RegistroSuscriptorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private UsuarioDTO user;
	
	public RegistroSuscriptorDataManager() {
		user=new UsuarioDTO();
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}
	
	
}
