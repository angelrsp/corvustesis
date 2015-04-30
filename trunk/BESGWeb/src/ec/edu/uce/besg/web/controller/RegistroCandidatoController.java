package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.service.CatalogoService;
import ec.edu.uce.besg.ejb.service.CandidatoService;
import ec.edu.uce.besg.ejb.vo.CandidatoVO;
import ec.edu.uce.besg.web.datamanager.RegistroCandidatoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "registroCandidatoController")
public class RegistroCandidatoController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CandidatoService servicioCandidato;
	
	@EJB
	private CatalogoService catalogoService;
	
	
	@ManagedProperty(value="#{registroCandidatoDataManager}")
	private RegistroCandidatoDataManager registroCandidatoDataManager;

	public RegistroCandidatoController() {
		
	}
	
	public RegistroCandidatoDataManager getRegistroCandidatoDataManager() {
		return registroCandidatoDataManager;
	}

	public void setRegistroCandidatoDataManager(
			RegistroCandidatoDataManager registroCandidatoDataManager) {
		this.registroCandidatoDataManager = registroCandidatoDataManager;
	}

	@PostConstruct
	private void init()
	{
		readDocumentType();
		readFacultad();
		//FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
	
	private void readDocumentType()
	{
		try {
			registroCandidatoDataManager.setIdentificationTypeList(catalogoService.readIdentificationType());
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}
		
	private void readFacultad()
	{
		try {
			registroCandidatoDataManager.setFacultadesList(catalogoService.readFacultad());
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void registrar()
	{
		CandidatoVO candidato;
		try {
			candidato=new CandidatoVO();
			registroCandidatoDataManager.getCandidatoDTO().setCanTipoIdentificacion(registroCandidatoDataManager.getIdentificationTypeCode());
			candidato.setCandidatoDTO(registroCandidatoDataManager.getCandidatoDTO());
			candidato.setUsuarioDTO(registroCandidatoDataManager.getUsuarioDTO());
			candidato.getUsuarioDTO().setUsuFacultad(registroCandidatoDataManager.getFacultadCode());
			servicioCandidato.registrarCandidato(candidato);
			JsfUtil.addInfoMessage("Registro Exitoso");
			JsfUtil.redirect("pages/candidato/inicio.xhtml");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			candidato=null;
		}
	}
	
	
}
