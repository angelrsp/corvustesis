package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosVisorDTO;

@SessionScoped
@ManagedBean(name = "argosDataManager")
public class ArgosDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ArgosDTO> argosList;
	private List<PaisDTO> paisList;
	private List<ArgosVisorDTO> argosVisorList;
	
	private PaisDTO pais;
	
	private ArgosDTO argos;
	
	private String tipoConsulta;
	
	
	public ArgosDataManager() {
		argosList=new ArrayList<ArgosDTO>();
		paisList=new ArrayList<PaisDTO>();
		pais=new PaisDTO();
		argos=new ArgosDTO();
		argosVisorList=new ArrayList<ArgosVisorDTO>();
	}

	public List<ArgosDTO> getArgosList() {
		return argosList;
	}

	public void setArgosList(List<ArgosDTO> argosList) {
		this.argosList = argosList;
	}

	public List<PaisDTO> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisDTO> paisList) {
		this.paisList = paisList;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public ArgosDTO getArgos() {
		return argos;
	}

	public void setArgos(ArgosDTO argos) {
		this.argos = argos;
	}

	public List<ArgosVisorDTO> getArgosVisorList() {
		return argosVisorList;
	}

	public void setArgosVisorList(List<ArgosVisorDTO> argosVisorList) {
		this.argosVisorList = argosVisorList;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

}
