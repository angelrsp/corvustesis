package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;


@SessionScoped
@ManagedBean(name = "homeDataManager")
public class HomeDataManager implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private DoctorDTO doctorDTO;

	
	public HomeDataManager() {
		doctorDTO=new DoctorDTO();
	}


	public DoctorDTO getDoctorDTO() {
		return doctorDTO;
	}


	public void setDoctorDTO(DoctorDTO doctorDTO) {
		this.doctorDTO = doctorDTO;
	}
	
	
}
