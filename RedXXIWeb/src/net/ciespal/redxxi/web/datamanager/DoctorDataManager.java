package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ObraDTO;

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
	private Object tipoPublicacion;
	
	private ObraDTO obra;
	private List<ObraDTO> obraList;
	
	
	public DoctorDataManager() {
		doctorList=new ArrayList<DoctorDTO>();
		obra=new ObraDTO();
		obraList=new ArrayList<ObraDTO>();
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

	public Object getTipoPublicacion() {
		return tipoPublicacion;
	}

	public void setTipoPublicacion(Object tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public ObraDTO getObra() {
		return obra;
	}

	public void setObra(ObraDTO obra) {
		this.obra = obra;
	}

	public List<ObraDTO> getObraList() {
		return obraList;
	}

	public void setObraList(List<ObraDTO> obraList) {
		this.obraList = obraList;
	}

	
	
}
