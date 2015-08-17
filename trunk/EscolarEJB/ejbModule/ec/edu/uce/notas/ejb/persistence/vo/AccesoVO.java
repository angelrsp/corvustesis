package ec.edu.uce.notas.ejb.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;

public class AccesoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PerfilDTO perfil;
	private List<AccesoViewDTO> accesoList;
	
	public AccesoVO() {
		perfil=new PerfilDTO();
		accesoList=new ArrayList<AccesoViewDTO>();
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}

	public List<AccesoViewDTO> getAccesoList() {
		return accesoList;
	}

	public void setAccesoList(List<AccesoViewDTO> accesoList) {
		this.accesoList = accesoList;
	}
	
}
