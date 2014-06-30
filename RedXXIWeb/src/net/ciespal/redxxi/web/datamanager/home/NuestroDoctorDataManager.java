package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorVieDTO;

@SessionScoped
@ManagedBean(name = "nuestroDoctorDataManager")
public class NuestroDoctorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private DoctorVieDTO doctorVieDTO;
	private String item;
	
	public NuestroDoctorDataManager() {
		doctorVieDTO=new DoctorVieDTO();
	}

	public DoctorVieDTO getDoctorVieDTO() {
		return doctorVieDTO;
	}

	public void setDoctorVieDTO(DoctorVieDTO doctorVieDTO) {
		this.doctorVieDTO = doctorVieDTO;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	
}
