package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;

@ViewScoped
@ManagedBean(name="carreraDataManager")
public class CarreraDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CarreraDTO carrera;
	private CarreraDTO carreraSelect;
	private Object modalidad;
	private EntidadDTO entidad;
	private Object tipoPosgrado;
	
	private List<Object> modalidadSelect;
	
	private MencionDTO mencion;
	private List<MencionDTO> mencionList;
	
	private List<CarreraDTO> carreraList;
	
	public CarreraDataManager() {
	}
	
	@PostConstruct
	private void init()
	{
		carrera=new CarreraDTO();
		carreraSelect=new CarreraDTO();
		entidad=new EntidadDTO();
		mencion=new MencionDTO();
		mencionList=new ArrayList<MencionDTO>();
		carreraList=new ArrayList<CarreraDTO>();
	}


	public CarreraDTO getCarrera() {
		return carrera;
	}

	public void setCarrera(CarreraDTO carrera) {
		this.carrera = carrera;
	}

	public CarreraDTO getCarreraSelect() {
		return carreraSelect;
	}

	public void setCarreraSelect(CarreraDTO carreraSelect) {
		this.carreraSelect = carreraSelect;
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

	public Object getTipoPosgrado() {
		return tipoPosgrado;
	}

	public void setTipoPosgrado(Object tipoPosgrado) {
		this.tipoPosgrado = tipoPosgrado;
	}

	public List<Object> getModalidadSelect() {
		return modalidadSelect;
	}

	public void setModalidadSelect(List<Object> modalidadSelect) {
		this.modalidadSelect = modalidadSelect;
	}

	public MencionDTO getMencion() {
		return mencion;
	}

	public void setMencion(MencionDTO mencion) {
		this.mencion = mencion;
	}

	public List<MencionDTO> getMencionList() {
		return mencionList;
	}

	public void setMencionList(List<MencionDTO> mencionList) {
		this.mencionList = mencionList;
	}

	public List<CarreraDTO> getCarreraList() {
		return carreraList;
	}

	public void setCarreraList(List<CarreraDTO> carreraList) {
		this.carreraList = carreraList;
	}


}
