package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.OrganizacionDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "organizacionController")
public class OrganizacionController extends SelectItemController{

	
	@EJB
	private AteneaService ateneaService;
	
	@ManagedProperty(value="#{organizacionDataManager}")
	private OrganizacionDataManager organizacionDataManager;
	
	public OrganizacionController() {
	}

	public void setOrganizacionDataManager(OrganizacionDataManager organizacionDataManager) {
		this.organizacionDataManager = organizacionDataManager;
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
	}
}
