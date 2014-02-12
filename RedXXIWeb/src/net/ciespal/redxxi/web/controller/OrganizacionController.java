package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ContactoDataManager;
import net.ciespal.redxxi.web.datamanager.OrganizacionDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "organizacionController")
public class OrganizacionController extends SelectItemController{

	
	@EJB
	private AteneaService ateneaService;
	
	@ManagedProperty(value="#{organizacionDataManager}")
	private OrganizacionDataManager organizacionDataManager;
	
	@ManagedProperty(value="#{contactoDataManager}")
	private ContactoDataManager contactoDataManager;

	
	public OrganizacionController() {
	}

	public void setOrganizacionDataManager(OrganizacionDataManager organizacionDataManager) {
		this.organizacionDataManager = organizacionDataManager;
	}
	
	public void setContactoDataManager(ContactoDataManager contactoDataManager) {
		this.contactoDataManager = contactoDataManager;
	}
	
	public void obtenerProvinciaChange() {
		try {
			getCatalogoProvincia();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void obtenerCiudadChange() {
		try {
			getCatalogoCiudad();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void ciudadChange()
	{
		readOrganizacion();
	}
	
	public void save()
	{
		try {
			organizacionDataManager.getOrganizacion().addAteEntidad(new EntidadDTO());
			organizacionDataManager.getOrganizacion().setOrgUbicacion(Integer.valueOf(getCiudad().toString()));
			ateneaService.createOrganizacion(organizacionDataManager.getOrganizacion());
			organizacionDataManager.setOrganizacion(new OrganizacionDTO());
			readOrganizacion();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readOrganizacion()
	{
		try {
			organizacionDataManager.setOrganizacionList(ateneaService.readOrganizacion(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void organizacionSelect(OrganizacionDTO org)
	{
		organizacionDataManager.setOrganizacion(org);
		buscarContactos();
	}
	
	
	public void buscarContactos()
	{
		try {
			contactoDataManager.setContactoList(ateneaService.readContacto(organizacionDataManager.getOrganizacion()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void crearContacto()
	{
		try {
			if(organizacionDataManager.getOrganizacion().getOrgCodigo()==null || organizacionDataManager.getOrganizacion().getOrgCodigo()==0){
				JsfUtil.addErrorMessage("Debe guardar ");
				return;
			}
			contactoDataManager.getContacto().setAteEntidad(organizacionDataManager.getOrganizacion().getAteEntidads().get(0));
			contactoDataManager.getContacto().setConTipo(Integer.valueOf(contactoDataManager.getTipoContacto().toString()));
			ateneaService.createContacto(contactoDataManager.getContacto());
			buscarContactos();
			contactoDataManager.setContacto(new ContactoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
