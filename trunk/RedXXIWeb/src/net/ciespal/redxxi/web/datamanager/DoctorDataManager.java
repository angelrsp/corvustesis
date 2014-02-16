package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;

@ViewScoped
@ManagedBean(name="doctorDataManager")
public class DoctorDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DoctorDTO doctor;
	private List<DoctorDTO> doctorList;
	private Date fechaNacimiento;
	private Object sexoSelect;
	
	public DoctorDataManager() {
		doctorList=new ArrayList<DoctorDTO>();
	}
	
	@PostConstruct
	private void init()
	{
		doctor=new DoctorDTO();
	}

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}

	public List<DoctorDTO> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<DoctorDTO> doctorList) {
		this.doctorList = doctorList;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Object getSexoSelect() {
		return sexoSelect;
	}

	public void setSexoSelect(Object sexoSelect) {
		this.sexoSelect = sexoSelect;
	}
	
	
}
