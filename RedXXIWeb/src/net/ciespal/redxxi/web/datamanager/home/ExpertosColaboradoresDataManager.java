package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioVieDTO;

@ViewScoped
@ManagedBean(name = "expertosColaboradoresDataManager")
public class ExpertosColaboradoresDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioVieDTO userVie;
	
	private List<UsuarioVieDTO> userVieList;
	
	public ExpertosColaboradoresDataManager() {
		userVie=new UsuarioVieDTO();
		userVieList=new ArrayList<UsuarioVieDTO>();
	}

	public UsuarioVieDTO getUserVie() {
		return userVie;
	}

	public void setUserVie(UsuarioVieDTO userVie) {
		this.userVie = userVie;
	}

	public List<UsuarioVieDTO> getUserVieList() {
		return userVieList;
	}

	public void setUserVieList(List<UsuarioVieDTO> userVieList) {
		this.userVieList = userVieList;
	}
	
}
