package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.UniversidadDataManager;

@ViewScoped
@ManagedBean(name="universidadController")
public class UniversidadController extends SelectItemController{

	
	@EJB
	private AteneaService ateneaService;
	
	@ManagedProperty(value="#{universidadDataManager}")
	private UniversidadDataManager universidadDataManager;
	
	
	
	public UniversidadController() {
	}
	
	@PostConstruct
	private void init()
	{
		obtenerUniversidad();
	}
	
	public void setUniversidadDataManager(UniversidadDataManager universidadDataManager) {
		this.universidadDataManager = universidadDataManager;
	}
	
	public void crearUniversidad()
	{
		try {
			universidadDataManager.getUniversidad().setCenCodigo(null);
			universidadDataManager.getUniversidad().setCenTipo(2);
			universidadDataManager.getUniversidad().setCenUbicacion(Integer.valueOf(getCiudad().toString()));
			ateneaService.createCentro(universidadDataManager.getUniversidad());
			universidadDataManager.setUniversidad(new CentroDTO());
			obtenerUniversidad();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void crearFacultad()
	{
		try {
			CentroDTO cen=new CentroDTO();
			cen.setCenCodigo(universidadDataManager.getUniversidadSelect().getCenCodigo());
			
			universidadDataManager.getFacultad().setAteCentro(cen);
			universidadDataManager.getFacultad().setCenTipo(3);
			//universidadDataManager.getFacultad().setCenUbicacion(Integer.valueOf(getCiudad().toString()));
			ateneaService.createCentro(universidadDataManager.getFacultad());
			universidadDataManager.setFacultad(new CentroDTO());
			obtenerFacultad(universidadDataManager.getUniversidadSelect());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void crearEscuela()
	{
		try {
			CentroDTO cen=new CentroDTO();
			cen.setCenCodigo(universidadDataManager.getFacultadSelect().getCenCodigo());
			
			universidadDataManager.getEscuela().setAteCentro(cen);
			universidadDataManager.getEscuela().setCenTipo(4);
			//universidadDataManager.getFacultad().setCenUbicacion(Integer.valueOf(getCiudad().toString()));
			ateneaService.createCentro(universidadDataManager.getEscuela());
			universidadDataManager.setEscuela(new CentroDTO());
			obtenerEscuela(universidadDataManager.getFacultadSelect());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void obtenerUniversidad()
	{
		try {
			universidadDataManager.setUniversidadList(ateneaService.obtenerCentroPadre());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void obtenerFacultad(CentroDTO centro)
	{
		try {
			universidadDataManager.setUniversidadSelect(centro);
			universidadDataManager.setFacultadList(ateneaService.obtenerCentroHijo(centro));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
	
	public void obtenerEscuela(CentroDTO centro)
	{
		try {
			universidadDataManager.setFacultadSelect(centro);
			universidadDataManager.setEscuelaList(ateneaService.obtenerCentroHijo(centro));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
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
}
