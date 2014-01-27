package ec.edu.uce.silsag.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;
import ec.edu.uce.silsag.web.util.validator.Identification;


@ViewScoped
@ManagedBean (name = "registroCandidatoController")
public class RegistroCandidatoController extends SelectItemController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(RegistroCandidatoController.class);
	
	private CandidatoDTO candidatoRegistro;
	private UsuarioDTO usuarioRegistro;
	private Object tipoDocumento;
	
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
		try {
			
			log.info("Contrasenia {}", getUsuarioRegistro().getUsuPassword() );
			
			if(Integer.valueOf(tipoDocumento.toString())==3)
			{
				if(!Identification.isCedula(getCandidatoRegistro().getCanIdentificacion())){
					JsfUtil.addErrorMessage("Cédula invalida");
					return;
				}
			}			
			getCandidatoRegistro().setBemUsuario(getUsuarioRegistro());
			getUsuarioRegistro().setUsuLogin(getCandidatoRegistro().getCanIdentificacion());
			getCandidatoRegistro().setCanTipoIdentificacion(Integer.valueOf(tipoDocumento.toString()));
			getUsuarioRegistro().setUsuLogin(getCandidatoRegistro().getCanIdentificacion());
			getCandidatoRegistro().setCanFechaUltima(new Timestamp(new Date().getTime()));
			UsuarioDTO user= candidatosService.registrarCandidato(getCandidatoRegistro()).getBemUsuario();
			JsfUtil.putObject("UsuarioDTO",user);
			JsfUtil.redirect("dato.jsf");
		} catch (SilsagException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage("El número de identificación ingresado ya existe en el sistema");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
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

	public Object getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Object tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


}
