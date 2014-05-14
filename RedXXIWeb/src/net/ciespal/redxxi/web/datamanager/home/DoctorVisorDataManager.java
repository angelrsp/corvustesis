package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorVieDTO;

@SessionScoped
@ManagedBean(name = "doctorVisorDataManager")
public class DoctorVisorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<DoctorVieDTO> doctorList;
	private DoctorVieDTO doctor;
	
	private List<DoctorDTO> doctorListDTO;
	
	@PostConstruct
	private void init()
	{
		doctorList=new ArrayList<DoctorVieDTO>();
		doctor=new DoctorVieDTO();
		doctorListDTO=new ArrayList<DoctorDTO>();
	}

	public List<DoctorVieDTO> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<DoctorVieDTO> doctorList) {
		this.doctorList = doctorList;
	}

	public DoctorVieDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorVieDTO doctor) {
		this.doctor = doctor;
	}

	public List<DoctorDTO> getDoctorListDTO() {
		return doctorListDTO;
	}

	public void setDoctorListDTO(List<DoctorDTO> doctorListDTO) {
		this.doctorListDTO = doctorListDTO;
	}


	
}
