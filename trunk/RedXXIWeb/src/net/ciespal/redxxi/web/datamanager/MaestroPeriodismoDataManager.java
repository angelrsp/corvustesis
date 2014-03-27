package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;

@ViewScoped
@ManagedBean(name = "maestroPeriodismoDataManager")
public class MaestroPeriodismoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GranMaestroDTO granMaestroDTO;
	private List<GranMaestroDTO> granMaestroList;
	private Date fechaNacimiento;
	private Date fechaFallecimiento;
	
	
	public MaestroPeriodismoDataManager() {
		granMaestroDTO=new GranMaestroDTO();
		granMaestroList=new ArrayList<GranMaestroDTO>();
	}

	public GranMaestroDTO getGranMaestroDTO() {
		return granMaestroDTO;
	}

	public void setGranMaestroDTO(GranMaestroDTO granMaestroDTO) {
		this.granMaestroDTO = granMaestroDTO;
	}

	public List<GranMaestroDTO> getGranMaestroList() {
		return granMaestroList;
	}

	public void setGranMaestroList(List<GranMaestroDTO> granMaestroList) {
		this.granMaestroList = granMaestroList;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaFallecimiento() {
		return fechaFallecimiento;
	}

	public void setFechaFallecimiento(Date fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
	}
	
	
}
