package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.AvisoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;
import ec.edu.uce.besg.ejb.service.CatalogoService;
import ec.edu.uce.besg.ejb.service.EmpleoService;
import ec.edu.uce.besg.ejb.service.EmpresaService;
import ec.edu.uce.besg.web.datamanager.AvisoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "avisoController")
public class AvisoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmpleoService empleoService;
	
	@EJB
	private CatalogoService catalogoService;
	
	@EJB
	private EmpresaService empresaService;
	

	@ManagedProperty(value="#{avisoDataManager}")
	private AvisoDataManager avisoDataManager;
	
	
	public AvisoController() {
	
	}
	
	
	public AvisoDataManager getAvisoDataManager() {
		return avisoDataManager;
	}

	public void setAvisoDataManager(AvisoDataManager avisoDataManager) {
		this.avisoDataManager = avisoDataManager;
	}
	
	@PostConstruct
	private void init()
	{
		readEmpresa();
		readCargo();
		readAviso();
	}

	public void readCargo() {
		try {
			this.avisoDataManager.setCargoList(catalogoService.readCargo());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void readEmpresa()
	{
		try {
			avisoDataManager.getEmpresaDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			avisoDataManager.setEmpresaDTO(empresaService.readEmpresa(avisoDataManager.getEmpresaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readAviso()
	{
		AvisoViewDTO avisoViewDTO;
		try {
			avisoViewDTO=new AvisoViewDTO();
			avisoViewDTO.setAviEmpresa(avisoDataManager.getEmpresaDTO().getEmpCodigo());
			avisoDataManager.setAvisoViewList(empleoService.readAviso(avisoViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			avisoViewDTO=null;
		}
	}

	
	public void onClickSave()
	{
		try {
			avisoDataManager.getAvisoDTO().setBemEmpresa(avisoDataManager.getEmpresaDTO());
			empleoService.createOrUpdateAviso(avisoDataManager.getAvisoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			avisoDataManager.setAvisoDTO(new AvisoDTO());
			readAviso();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		finally{

		}
	}
	
	public void onClickEdit(AvisoViewDTO avisoViewDTO)
	{
		try {
			avisoDataManager.setAvisoDTO(empleoService.findAviso(avisoViewDTO.getAviCodigo()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		finally{
			avisoViewDTO=null;
		}
	}
	
}
