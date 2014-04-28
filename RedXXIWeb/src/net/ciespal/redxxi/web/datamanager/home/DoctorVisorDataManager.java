package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorListDTO;

@SessionScoped
@ManagedBean(name = "doctorVisorDataManager")
public class DoctorVisorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<DoctorListDTO> doctorList;
	private DoctorListDTO doctor;
	
	private List<DoctorDTO> doctorListDTO;
	
	@PostConstruct
	private void init()
	{
		doctorList=new ArrayList<DoctorListDTO>();
		doctor=new DoctorListDTO();
		doctorListDTO=new ArrayList<DoctorDTO>();
	}


	public List<DoctorListDTO> getDoctorList() {
		return doctorList;
	}


	public void setDoctorList(List<DoctorListDTO> doctorList) {
		this.doctorList = doctorList;
	}


	public DoctorListDTO getDoctor() {
		return doctor;
	}


	public void setDoctor(DoctorListDTO doctor) {
		this.doctor = doctor;
	}


	public List<DoctorDTO> getDoctorListDTO() {
		return doctorListDTO;
	}


	public void setDoctorListDTO(List<DoctorDTO> doctorListDTO) {
		this.doctorListDTO = doctorListDTO;
	}
	
}
