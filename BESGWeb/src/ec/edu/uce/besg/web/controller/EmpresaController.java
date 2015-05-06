package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.CatalogoService;
import ec.edu.uce.besg.ejb.service.EmpresaService;
import ec.edu.uce.besg.web.datamanager.EmpresaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "empresaController")
public class EmpresaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmpresaService empresaService;

	@EJB
	private CatalogoService catalogoService;

	
	@ManagedProperty(value="#{empresaDataManager}")
	private EmpresaDataManager empresaDataManager;

	
	public EmpresaController() {
	
	}
	
	public EmpresaDataManager getEmpresaDataManager() {
		return empresaDataManager;
	}

	public void setEmpresaDataManager(EmpresaDataManager empresaDataManager) {
		this.empresaDataManager = empresaDataManager;
	}

	
	@PostConstruct
	private void init()
	{
		readEmpresa();
		readSector();
		readPais();
	}
	
	public void readSector() {
		try {
			this.empresaDataManager.setSectorList(catalogoService.readSector());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void readPais() {
		try {
			this.empresaDataManager.setPaisList(catalogoService.readPais());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void readProvincia() {
		try {
			this.empresaDataManager.setProvinciaList(catalogoService.readProvincia(empresaDataManager.getEmpresaDTO().getEmpPais()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void readCiudad() {
		try {
			this.empresaDataManager.setCiudadList(catalogoService.readCiudad(empresaDataManager.getEmpresaDTO().getEmpProvincia()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	private void readEmpresa()
	{
		try {
			empresaDataManager.getEmpresaDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			empresaDataManager.setUsuarioDTO((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			empresaDataManager.setEmpresaDTO(empresaService.readEmpresa(empresaDataManager.getEmpresaDTO()));
			readProvincia();
			readCiudad();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void onClickUpdate()
	{
		try {
			empresaService.updateEmpresa(empresaDataManager.getEmpresaDTO());
			JsfUtil.addInfoMessage("Datos Actualizados Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
