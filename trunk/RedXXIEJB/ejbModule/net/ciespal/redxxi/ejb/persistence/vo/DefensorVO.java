package net.ciespal.redxxi.ejb.persistence.vo;

import java.io.Serializable;

import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;

public class DefensorVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioDTO user;
	private DefensorDTO defensor;

	public DefensorVO() {
		user=new UsuarioDTO();
		defensor=new DefensorDTO();
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public DefensorDTO getDefensor() {
		return defensor;
	}

	public void setDefensor(DefensorDTO defensor) {
		this.defensor = defensor;
	}
	
}
