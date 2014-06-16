package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.AteneaVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.FacultadListDTO;


@SessionScoped
@ManagedBean(name = "ateneaVisorDataManager")
public class AteneaVisorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<AteneaVisorDTO> ateneaVistorList;

	private FacultadListDTO facultadList;
	
	private List<CarreraDTO> pregradoList;
	private List<CarreraDTO> posgradoList;
	
	private List<ContactoListDTO> contactoList;
	
	private String item;
	
	
	public AteneaVisorDataManager() {
		ateneaVistorList=new ArrayList<AteneaVisorDTO>();
		facultadList=new FacultadListDTO();
		pregradoList=new ArrayList<CarreraDTO>();
		posgradoList=new ArrayList<CarreraDTO>();
		contactoList=new ArrayList<ContactoListDTO>();
	}

	public List<AteneaVisorDTO> getAteneaVistorList() {
		return ateneaVistorList;
	}

	public void setAteneaVistorList(List<AteneaVisorDTO> ateneaVistorList) {
		this.ateneaVistorList = ateneaVistorList;
	}

	public FacultadListDTO getFacultadList() {
		return facultadList;
	}

	public void setFacultadList(FacultadListDTO facultadList) {
		this.facultadList = facultadList;
	}

	public List<CarreraDTO> getPregradoList() {
		return pregradoList;
	}

	public void setPregradoList(List<CarreraDTO> pregradoList) {
		this.pregradoList = pregradoList;
	}

	public List<CarreraDTO> getPosgradoList() {
		return posgradoList;
	}

	public void setPosgradoList(List<CarreraDTO> posgradoList) {
		this.posgradoList = posgradoList;
	}

	public List<ContactoListDTO> getContactoList() {
		return contactoList;
	}

	public void setContactoList(List<ContactoListDTO> contactoList) {
		this.contactoList = contactoList;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	
}
