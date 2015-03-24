package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.service.ServicioCandidato;
import ec.edu.uce.besg.ejb.vo.CandidatoVO;
import ec.edu.uce.besg.web.datamanager.RegistroCandidatoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "registroCandidatoDataManager")
public class RegistroCandidatoController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ServicioCandidato servicioCandidato;
	
	@ManagedProperty(value="#{registroCandidatoDataManager}")
	private RegistroCandidatoDataManager registroCandidatoDataManager;

	public RegistroCandidatoDataManager getRegistroCandidatoDataManager() {
		return registroCandidatoDataManager;
	}

	public void setRegistroCandidatoDataManager(
			RegistroCandidatoDataManager registroCandidatoDataManager) {
		this.registroCandidatoDataManager = registroCandidatoDataManager;
	}

	public RegistroCandidatoController() {
	
	}
	
	
	public void registrar()
	{
		CandidatoVO candidato;
		try {
			candidato=new CandidatoVO();
			candidato.setCandidatoDTO(registroCandidatoDataManager.getCandidatoDTO());
			candidato.setUsuarioDTO(registroCandidatoDataManager.getUsuarioDTO());
			servicioCandidato.registrarCandidato(candidato);
			JsfUtil.addInfoMessage("Registro Exitoso");
			JsfUtil.redirect("pages/empresa/inicio.xhtml");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			candidato=null;
		}
	}
	
	
}
