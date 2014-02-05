package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;

@SessionScoped
@ManagedBean(name="carreraDataManager")
public class CarreraDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CarreraDTO carrera;
	private Object modalidad;
	private EntidadDTO entidad;
	
	public CarreraDataManager() {
	}
	
	@PostConstruct
	private void init()
	{
		carrera=new CarreraDTO();
		entidad=new EntidadDTO();
	}


	public CarreraDTO getCarrera() {
		return carrera;
	}

	public void setCarrera(CarreraDTO carrera) {
		this.carrera = carrera;
	}

	public Object getModalidad() {
		return modalidad;
	}

	public void setModalidad(Object modalidad) {
		this.modalidad = modalidad;
	}

	public EntidadDTO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
	}
}
