package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

@SessionScoped
@ManagedBean(name="universidadDataManager")
public class UniversidadDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CentroDTO universidad;
	
	public UniversidadDataManager() {
		universidad=new CentroDTO();
	}

	public CentroDTO getUniversidad() {
		return universidad;
	}

	public void setUniversidad(CentroDTO universidad) {
		this.universidad = universidad;
	}
	
}
