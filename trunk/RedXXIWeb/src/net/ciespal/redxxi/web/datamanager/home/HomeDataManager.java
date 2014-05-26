package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;


@SessionScoped
@ManagedBean(name = "homeDataManager")
public class HomeDataManager implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private DoctorDTO doctorDTO;

	private MaestroCiespalDTO maestroCiespalDTO;
	
	private GranMaestroDTO granMaestroDTO;
	
	private String fotoPhdPath;
	private String fotoGranMaestroPath;
	private String fotoMaestroCiespalPath;
	
	
	public HomeDataManager() {
		doctorDTO=new DoctorDTO();
		maestroCiespalDTO=new MaestroCiespalDTO();
		granMaestroDTO=new GranMaestroDTO();
	}


	public DoctorDTO getDoctorDTO() {
		return doctorDTO;
	}


	public void setDoctorDTO(DoctorDTO doctorDTO) {
		this.doctorDTO = doctorDTO;
	}


	public String getFotoPhdPath() {
		return fotoPhdPath;
	}


	public void setFotoPhdPath(String fotoPhdPath) {
		this.fotoPhdPath = fotoPhdPath;
	}


	public MaestroCiespalDTO getMaestroCiespalDTO() {
		return maestroCiespalDTO;
	}


	public void setMaestroCiespalDTO(MaestroCiespalDTO maestroCiespalDTO) {
		this.maestroCiespalDTO = maestroCiespalDTO;
	}


	public GranMaestroDTO getGranMaestroDTO() {
		return granMaestroDTO;
	}


	public void setGranMaestroDTO(GranMaestroDTO granMaestroDTO) {
		this.granMaestroDTO = granMaestroDTO;
	}


	public String getFotoGranMaestroPath() {
		return fotoGranMaestroPath;
	}


	public void setFotoGranMaestroPath(String fotoGranMaestroPath) {
		this.fotoGranMaestroPath = fotoGranMaestroPath;
	}


	public String getFotoMaestroCiespalPath() {
		return fotoMaestroCiespalPath;
	}


	public void setFotoMaestroCiespalPath(String fotoMaestroCiespalPath) {
		this.fotoMaestroCiespalPath = fotoMaestroCiespalPath;
	}
	
	
}
