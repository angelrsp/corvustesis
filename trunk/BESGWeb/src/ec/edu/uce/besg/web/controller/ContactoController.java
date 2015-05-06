package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ContactoViewDTO;
import ec.edu.uce.besg.ejb.service.CatalogoService;
import ec.edu.uce.besg.ejb.service.EmpresaService;
import ec.edu.uce.besg.web.datamanager.ContactoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "contactoController")
public class ContactoController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private EmpresaService empresaService;
	
	@EJB
	private CatalogoService catalogoService;
	

	@ManagedProperty(value="#{contactoDataManager}")
	private ContactoDataManager contactoDataManager;
	
	public ContactoController() {
	
	}
	
	public ContactoDataManager getContactoDataManager() {
		return contactoDataManager;
	}
	
	public void setContactoDataManager(ContactoDataManager contactoDataManager) {
		this.contactoDataManager = contactoDataManager;
	}
	
	
	@PostConstruct
	private void init()
	{
		readEmpresa();
		buscarCargo();
		readContacto();
		
	}
	
	
	
	private void readEmpresa()
	{
		try {
			contactoDataManager.getEmpresaDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			contactoDataManager.setEmpresaDTO(empresaService.readEmpresa(contactoDataManager.getEmpresaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readContacto()
	{
		ContactoViewDTO contactoList;
		try {
			contactoList=new ContactoViewDTO();
			contactoList.setEmpCodigo(contactoDataManager.getEmpresaDTO().getEmpCodigo());
			contactoDataManager.setContactoList(empresaService.buscarContacto(contactoList));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			contactoList=null;
		}
	}
	
	
	public void cargarDatosContacto (ContactoViewDTO contacto) {
		try {
			contactoDataManager.setContactoDTO(empresaService.obtenerContactos(contacto));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			contacto=null;
		}
	}
	
	public void buscarCargo() {
		try {
			this.contactoDataManager.setCargoCatalogoList(catalogoService.readCargo());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	
	public void onClickSave()
	{
		try {
			contactoDataManager.getContactoDTO().setBemEmpresa(contactoDataManager.getEmpresaDTO());
			empresaService.agregarContacto(contactoDataManager.getContactoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			readContacto();
			contactoDataManager.setContactoDTO(new ContactoDTO());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}	

	
}
