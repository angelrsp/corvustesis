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
import ec.edu.uce.besg.ejb.service.EmpleoService;
import ec.edu.uce.besg.ejb.service.EmpresaService;
import ec.edu.uce.besg.web.datamanager.PostulacionDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "postulacionController")
public class PostulacionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB	
	private EmpresaService empresaService;

	@EJB	
	private EmpleoService empleoService;
	
	@ManagedProperty(value="#{postulacionDataManager}")
	private PostulacionDataManager postulacionDataManager;

	
	public PostulacionController() {
	
	}
	
	public PostulacionDataManager getPostulacionDataManager() {
		return postulacionDataManager;
	}

	public void setPostulacionDataManager(
			PostulacionDataManager postulacionDataManager) {
		this.postulacionDataManager = postulacionDataManager;
	}

	@PostConstruct
	private void init()
	{
		readEmpresa();
		readPostulacion();
	}
	
	private void readEmpresa()
	{
		try {
			postulacionDataManager.getEmpresaDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			postulacionDataManager.setUsuarioDTO((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			postulacionDataManager.setEmpresaDTO(empresaService.readEmpresa(postulacionDataManager.getEmpresaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void readPostulacion()
	{
		CandidatoPostulacionViewDTO candidatoPostulacionViewDTO;
		try {
			candidatoPostulacionViewDTO=new CandidatoPostulacionViewDTO();
			candidatoPostulacionViewDTO.setEmpCodigo(postulacionDataManager.getEmpresaDTO().getEmpCodigo());
			postulacionDataManager.setCandidatoPostulacionViewList(empleoService.readCandidatoPostulacion(candidatoPostulacionViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

}
