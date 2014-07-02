package net.ciespal.redxxi.ejb.persistence.vo;

import java.io.Serializable;

import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;

public class UsuarioVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private UsuarioDTO user;
	
	private PerfilDTO perfil;

	public UsuarioVO() {
		user=new UsuarioDTO();
		perfil=new PerfilDTO();
	}
	
	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
	
	
	
}
