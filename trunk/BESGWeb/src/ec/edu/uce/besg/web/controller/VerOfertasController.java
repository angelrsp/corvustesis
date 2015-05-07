package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.AvisoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PostulacionDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoPostulacionViewDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;
import ec.edu.uce.besg.ejb.service.CandidatoService;
import ec.edu.uce.besg.ejb.service.EmpleoService;
import ec.edu.uce.besg.web.datamanager.VerOfertasDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "verOfertasController")
public class VerOfertasController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatoService candidatoService;

	@EJB
	private EmpleoService empleoService;

	
	@ManagedProperty(value="#{verOfertasDataManager}")
	private VerOfertasDataManager verOfertasDataManager;

	public VerOfertasController() {
	
	}
	
	public VerOfertasDataManager getVerOfertasDataManager() {
		return verOfertasDataManager;
	}

	public void setVerOfertasDataManager(VerOfertasDataManager verOfertasDataManager) {
		this.verOfertasDataManager = verOfertasDataManager;
	}

	@PostConstruct
	private void init() {
		readOferta();
		readCandidato();
	}

	private void readCandidato()
	{
		try {
			verOfertasDataManager.getCandidatoDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			verOfertasDataManager.setCandidatoDTO(candidatoService.readCandidato(verOfertasDataManager.getCandidatoDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void readOferta()
	{
		try {
			verOfertasDataManager.setAvisoPostulacionViewList(empleoService.readAvisoPostulacion(new AvisoPostulacionViewDTO()));
			verOfertasDataManager.setAvisoViewList(empleoService.readAviso(new AvisoViewDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void onClickPustularse(AvisoPostulacionViewDTO avisoPostulacionViewDTO)
	{
		PostulacionDTO postulacionDTO;
		AvisoDTO avisoDTO;
		try {
			
			postulacionDTO=new PostulacionDTO();
			avisoDTO=new AvisoDTO();
			avisoDTO.setAviCodigo(avisoPostulacionViewDTO.getAviCodigo());
			postulacionDTO.setBemAviso(avisoDTO);
			postulacionDTO.setBemCandidato(verOfertasDataManager.getCandidatoDTO());

			empleoService.createOrUpdatePosulacion(postulacionDTO);
			JsfUtil.addInfoMessage("Sus datos de hoja de vida fueron enviados exitosamente");
			readOferta();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			postulacionDTO=null;
			avisoDTO=null;
			
		}
	}
}
