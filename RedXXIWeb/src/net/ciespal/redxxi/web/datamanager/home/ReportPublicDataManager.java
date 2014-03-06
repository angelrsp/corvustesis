package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;


@SessionScoped
@ManagedBean(name = "reportPublicDataManager")
public class ReportPublicDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PaisDTO> paisList;
	private List<AteneaDTO> ateneaList;
	
	public ReportPublicDataManager() {
		paisList=new ArrayList<PaisDTO>();
		ateneaList=new ArrayList<AteneaDTO>();
	}

	public List<PaisDTO> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisDTO> paisList) {
		this.paisList = paisList;
	}

	public List<AteneaDTO> getAteneaList() {
		return ateneaList;
	}

	public void setAteneaList(List<AteneaDTO> ateneaList) {
		this.ateneaList = ateneaList;
	}

	
}
