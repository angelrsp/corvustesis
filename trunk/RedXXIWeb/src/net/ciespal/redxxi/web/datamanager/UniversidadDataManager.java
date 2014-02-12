package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

@ViewScoped
@ManagedBean(name="universidadDataManager")
public class UniversidadDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CentroDTO universidad;
	private CentroDTO universidadSelect;
	private CentroDTO facultad;
	private CentroDTO facultadSelect;


	private CentroDTO escuela;
	
	private List<CentroDTO> universidadList;
	private List<CentroDTO> facultadList;
	private List<CentroDTO> escuelaList;
	
	private int universidadCode;
	private int facultadCode;
	private int escuelaCode;
	
	public UniversidadDataManager() {
		universidad=new CentroDTO();
		universidadSelect=new CentroDTO();
		universidadList=new ArrayList<CentroDTO>();
		
		facultad=new CentroDTO();
		facultadSelect=new CentroDTO();
		facultadList=new ArrayList<CentroDTO>();
		
		escuela=new CentroDTO();
		escuelaList=new ArrayList<CentroDTO>();
	}

	public CentroDTO getUniversidad() {
		return universidad;
	}

	public void setUniversidad(CentroDTO universidad) {
		this.universidad = universidad;
	}

	public CentroDTO getUniversidadSelect() {
		return universidadSelect;
	}

	public void setUniversidadSelect(CentroDTO universidadSelect) {
		this.universidadSelect = universidadSelect;
	}

	public CentroDTO getFacultad() {
		return facultad;
	}

	public CentroDTO getEscuela() {
		return escuela;
	}

	public void setEscuela(CentroDTO escuela) {
		this.escuela = escuela;
	}
	
	public void setFacultad(CentroDTO facultad) {
		this.facultad = facultad;
	}

	public CentroDTO getFacultadSelect() {
		return facultadSelect;
	}

	public void setFacultadSelect(CentroDTO facultadSelect) {
		this.facultadSelect = facultadSelect;
	}

	public List<CentroDTO> getUniversidadList() {
		return universidadList;
	}

	public void setUniversidadList(List<CentroDTO> universidadList) {
		this.universidadList = universidadList;
	}

	public List<CentroDTO> getFacultadList() {
		return facultadList;
	}

	public void setFacultadList(List<CentroDTO> facultadList) {
		this.facultadList = facultadList;
	}

	public List<CentroDTO> getEscuelaList() {
		return escuelaList;
	}

	public void setEscuelaList(List<CentroDTO> escuelaList) {
		this.escuelaList = escuelaList;
	}

	public int getUniversidadCode() {
		return universidadCode;
	}

	public void setUniversidadCode(int universidadCode) {
		this.universidadCode = universidadCode;
	}

	public int getFacultadCode() {
		return facultadCode;
	}

	public void setFacultadCode(int facultadCode) {
		this.facultadCode = facultadCode;
	}

	public int getEscuelaCode() {
		return escuelaCode;
	}

	public void setEscuelaCode(int escuelaCode) {
		this.escuelaCode = escuelaCode;
	}
	
}
