package ec.edu.uce.silsae.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;

@ViewScoped
@ManagedBean (name = "registroCandidatoController")
public class RegistroCandidatoController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(RegistroCandidatoController.class);
	
	private CandidatoDTO candidatoRegistro; 
	
	public RegistroCandidatoController () {
		
	}
	
	public void registrarse () {
		log.info("metodo registrarse");
	}

	public CandidatoDTO getCandidatoRegistro() {
		return candidatoRegistro;
	}

	public void setCandidatoRegistro(CandidatoDTO candidatoRegistro) {
		this.candidatoRegistro = candidatoRegistro;
	}
	

}
