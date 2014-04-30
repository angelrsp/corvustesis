package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.AteneaVisorDTO;


@SessionScoped
@ManagedBean(name = "ateneaVisorDataManager")
public class AteneaVisorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<AteneaVisorDTO> ateneaVistorList;

	
	public AteneaVisorDataManager() {
		ateneaVistorList=new ArrayList<AteneaVisorDTO>();
	}

	public List<AteneaVisorDTO> getAteneaVistorList() {
		return ateneaVistorList;
	}

	public void setAteneaVistorList(List<AteneaVisorDTO> ateneaVistorList) {
		this.ateneaVistorList = ateneaVistorList;
	}
	
	
}
