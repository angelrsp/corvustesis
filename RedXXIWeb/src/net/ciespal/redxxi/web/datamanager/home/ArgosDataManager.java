package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.ArgosDTO;

@SessionScoped
@ManagedBean(name = "argosDataManager")
public class ArgosDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ArgosDTO> argosList;
	
	public ArgosDataManager() {
	
	}

	public List<ArgosDTO> getArgosList() {
		return argosList;
	}

	public void setArgosList(List<ArgosDTO> argosList) {
		this.argosList = argosList;
	}
}
