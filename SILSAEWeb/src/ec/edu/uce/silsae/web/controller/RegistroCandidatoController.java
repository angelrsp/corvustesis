package ec.edu.uce.silsae.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.CandidatosService;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@ViewScoped
@ManagedBean (name = "registroCandidatoController")
public class RegistroCandidatoController {
	
	private static final Logger log = LoggerFactory.getLogger(RegistroCandidatoController.class);
	
	private CandidatoDTO candidatoRegistro;
	private UsuarioDTO usuarioRegistro;
	
	@EJB
	private CandidatosService candidatosService;
	
	public RegistroCandidatoController () {}
	
	@PostConstruct
	public void inicializar () {
		this.candidatoRegistro = new CandidatoDTO();
		this.usuarioRegistro = new UsuarioDTO();
	}
	
	public void registroCandidato () {
		log.info("metodo registroCandidato");
		getCandidatoRegistro().setBemUsuario(getUsuarioRegistro());
		try {
			candidatosService.registrarCandidato(getCandidatoRegistro());
		} catch (SilsaeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CandidatoDTO getCandidatoRegistro() {
		return candidatoRegistro;
	}

	public void setCandidatoRegistro(CandidatoDTO candidatoRegistro) {
		this.candidatoRegistro = candidatoRegistro;
	}

	public UsuarioDTO getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(UsuarioDTO usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	

}
