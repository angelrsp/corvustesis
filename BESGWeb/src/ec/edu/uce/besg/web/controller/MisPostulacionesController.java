package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CandidatoPostulacionViewDTO;
import ec.edu.uce.besg.ejb.service.CandidatoService;
import ec.edu.uce.besg.ejb.service.EmpleoService;
import ec.edu.uce.besg.web.datamanager.MisPostulacionesDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "misPostulacionesController")
public class MisPostulacionesController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EmpleoService empleoService;

	@EJB
	private CandidatoService candidatoService;

	@ManagedProperty(value="#{misPostulacionesDataManager}")
	private MisPostulacionesDataManager misPostulacionesDataManager;

	public MisPostulacionesController() {
	
	}

	public MisPostulacionesDataManager getMisPostulacionesDataManager() {
		return misPostulacionesDataManager;
	}

	public void setMisPostulacionesDataManager(
			MisPostulacionesDataManager misPostulacionesDataManager) {
		this.misPostulacionesDataManager = misPostulacionesDataManager;
	}

	@PostConstruct
	private void init()
	{
		readCandidato();
		readPostulaciones();
	}
	
	private void readCandidato()
	{
		try {
			misPostulacionesDataManager.getCandidatoDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			misPostulacionesDataManager.setCandidatoDTO(candidatoService.readCandidato(misPostulacionesDataManager.getCandidatoDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	private void readPostulaciones()
	{
		CandidatoPostulacionViewDTO candidatoPostulacionViewDTO;
		try {
			candidatoPostulacionViewDTO=new CandidatoPostulacionViewDTO();
			candidatoPostulacionViewDTO.setPosCandidato(misPostulacionesDataManager.getCandidatoDTO().getCanCodigo());
			misPostulacionesDataManager.setCandidatoPostulacionViewList(empleoService.readCandidatoPostulacion(candidatoPostulacionViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
