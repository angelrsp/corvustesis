package ec.edu.uce.besg.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections.CollectionUtils;

import ec.edu.uce.besg.ejb.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.entity.ContactoListDTO;
import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.service.ServicioEmpresa;
import ec.edu.uce.besg.ejb.util.SeguridadesException;
import ec.edu.uce.besg.web.datamanager.ContactoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "contactoController")
public class ContactoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{contactoDataManager}")
	private ContactoDataManager contactoDataManager;
	
	public ContactoDataManager getContactoDataManager() {
		return contactoDataManager;
	}
	public void setContactoDataManager(ContactoDataManager contactoDataManager) {
		this.contactoDataManager = contactoDataManager;
	}
	
	@EJB
	private ServicioEmpresa servicioEmpresa;
	
	@PostConstruct
	private void init()
	{
		readEmpresa();
		buscarCargo();
		readContacto();
		//read();
	}
	
	public void registrarContacto()
	{
		try {
			contactoDataManager.getContactoInsertar().setBemEmpresa(contactoDataManager.getEmpresa());
			contactoDataManager.getContactoInsertar().setConCargo(contactoDataManager.getCargo());
			ContactoDTO contactoNuevo = this.servicioEmpresa.agregarContacto(contactoDataManager.getContactoInsertar());
			if (contactoNuevo != null) {
				contactoDataManager.setContactoInsertar(new ContactoDTO());
				JsfUtil.addInfoMessage("Guardado Exitosamente");
				readContacto();
			}
		} catch (SecurityException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}	
	
	
	private void readEmpresa()
	{
		List<EmpresaDTO> listaEmpresas=null;
		try {
			//ojo se manda de parametro new empresadto pero deberia mandar la empresa logeada
			listaEmpresas = this.servicioEmpresa.obtenerEmpresa(new EmpresaDTO());
			if (CollectionUtils.isEmpty(listaEmpresas) && listaEmpresas.size()==0) {
				JsfUtil.addInfoMessage("Busqueda vacia");
			} else {
				this.contactoDataManager.setEmpresa(listaEmpresas.get(0));
			}
		} catch (SecurityException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readContacto()
	{
		List<ContactoListDTO> listaContactos=null;
		try {
			listaContactos = this.servicioEmpresa.buscarContacto(new ContactoListDTO());
			if (CollectionUtils.isEmpty(listaContactos) && listaContactos.size()==0) {
				JsfUtil.addInfoMessage("Busqueda vacia");
			} else {
				this.contactoDataManager.setContactoDTOs(listaContactos);
			}
		} catch (SecurityException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void cargarDatosContacto (ContactoListDTO contacto) {
		try {
			ContactoDTO contactoEncontrado=servicioEmpresa.obtenerContactos(contacto);
			contactoDataManager.setContactoInsertar(contactoEncontrado);
			//contactoDataManager.setCargo(contactoEncontrado.getConCargo());
			readEmpresa();
		} catch (SecurityException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void buscarCargo() {
		List<CatalogoDTO> listaCatalogo = null;
		try {
			CatalogoDTO cat = new CatalogoDTO();
			cat.setCatCodigo(17);
			listaCatalogo = this.servicioEmpresa.buscarCatalogo(cat);
			if (CollectionUtils.isEmpty(listaCatalogo) && listaCatalogo.size() == 0) {
				JsfUtil.addWarningMessage("Busqueda vacia");
			} else {
				this.contactoDataManager.setCargoLists(listaCatalogo);
			}
		} catch (SeguridadesException e) {
			//slf4jLogger.info("Error al buscarCatalogo {} ", e);
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	
}
