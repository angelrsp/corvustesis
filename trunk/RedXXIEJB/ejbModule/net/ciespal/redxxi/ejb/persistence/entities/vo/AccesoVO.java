package net.ciespal.redxxi.ejb.persistence.entities.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;

public class AccesoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PerfilDTO perfil;
	private List<AccesoVieDTO> accesoList;
	
	public AccesoVO() {
		perfil=new PerfilDTO();
		accesoList=new ArrayList<AccesoVieDTO>();
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}

	public List<AccesoVieDTO> getAccesoList() {
		return accesoList;
	}

	public void setAccesoList(List<AccesoVieDTO> accesoList) {
		this.accesoList = accesoList;
	}
	
}
