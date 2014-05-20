package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;

@ViewScoped
@ManagedBean(name = "perfilDataManager")
public class PerfilDataManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PerfilDTO perfil;
	
	public PerfilDataManager() {
		perfil=new PerfilDTO();
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
	
}
