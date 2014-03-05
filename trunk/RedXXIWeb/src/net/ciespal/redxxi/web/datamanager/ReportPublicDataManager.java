package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.FacultadListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.UniversidadListDTO;


@SessionScoped
@ManagedBean(name = "reportPublicDataManager")
public class ReportPublicDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int universidadNumber;
	private List<UniversidadListDTO> universidadList;
	
	private int facultadNumber;
	private List<FacultadListDTO> facultadList;
	
	private int pregradoNumber;
	private int posgradoNumber;
	
	private int revistaNumber;
	private int eventoNumber;
	private int proyectoNumber;
	private int organizacionNumber;
	
	private int doctorNumber;
	private int obraNumber;
	
	private int provinciaNumber;
	private int ciudadNumber;
	
	public ReportPublicDataManager() {
		universidadList=new ArrayList<UniversidadListDTO>();
		facultadList=new ArrayList<FacultadListDTO>();
	}

	public int getUniversidadNumber() {
		return universidadNumber;
	}

	public void setUniversidadNumber(int universidadNumber) {
		this.universidadNumber = universidadNumber;
	}

	public List<UniversidadListDTO> getUniversidadList() {
		return universidadList;
	}

	public void setUniversidadList(List<UniversidadListDTO> universidadList) {
		this.universidadList = universidadList;
	}

	public int getProvinciaNumber() {
		return provinciaNumber;
	}

	public void setProvinciaNumber(int provinciaNumber) {
		this.provinciaNumber = provinciaNumber;
	}

	public int getCiudadNumber() {
		return ciudadNumber;
	}

	public void setCiudadNumber(int ciudadNumber) {
		this.ciudadNumber = ciudadNumber;
	}

	public int getFacultadNumber() {
		return facultadNumber;
	}

	public void setFacultadNumber(int facultadNumber) {
		this.facultadNumber = facultadNumber;
	}

	public List<FacultadListDTO> getFacultadList() {
		return facultadList;
	}

	public void setFacultadList(List<FacultadListDTO> facultadList) {
		this.facultadList = facultadList;
	}

	public int getPregradoNumber() {
		return pregradoNumber;
	}

	public void setPregradoNumber(int pregradoNumber) {
		this.pregradoNumber = pregradoNumber;
	}

	public int getPosgradoNumber() {
		return posgradoNumber;
	}

	public void setPosgradoNumber(int posgradoNumber) {
		this.posgradoNumber = posgradoNumber;
	}

	public int getRevistaNumber() {
		return revistaNumber;
	}

	public void setRevistaNumber(int revistaNumber) {
		this.revistaNumber = revistaNumber;
	}

	public int getEventoNumber() {
		return eventoNumber;
	}

	public void setEventoNumber(int eventoNumber) {
		this.eventoNumber = eventoNumber;
	}

	public int getProyectoNumber() {
		return proyectoNumber;
	}

	public void setProyectoNumber(int proyectoNumber) {
		this.proyectoNumber = proyectoNumber;
	}

	public int getOrganizacionNumber() {
		return organizacionNumber;
	}

	public void setOrganizacionNumber(int organizacionNumber) {
		this.organizacionNumber = organizacionNumber;
	}

	public int getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(int doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public int getObraNumber() {
		return obraNumber;
	}

	public void setObraNumber(int obraNumber) {
		this.obraNumber = obraNumber;
	}
}
