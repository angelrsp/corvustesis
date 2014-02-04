package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.CatalogoDataManager;
import net.ciespal.redxxi.web.datamanager.UniversidadDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "pregradoController")
public class PregradoController extends SelectItemController{

	@EJB
	private AteneaService ateneaService;
		
	@EJB
	private AdministracionService administracionService;
	
	

	
	@ManagedProperty(value="#{catalogoDataManager}")
	private CatalogoDataManager catalogoDataManager;
	
	
	public PregradoController() {
		
	}
	
	@PostConstruct
	private void init()
	{
	}
	


	public void setCatalogoDataManager(CatalogoDataManager catalogoDataManager) {
		this.catalogoDataManager = catalogoDataManager;
	}

	public void agregarUniversidad()
	{
		
	}
	
	public void crearPais()
	{
		CatalogoDTO catalogo;
		try {
			catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(13);
			catalogoDataManager.getCatalogo().setAteCatalogo(catalogo);
			administracionService.createCatalogo(catalogoDataManager.getCatalogo());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			buscarPais();
			catalogoDataManager.setCatalogo(new CatalogoDTO());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void buscarPais()
	{
		CatalogoDTO catalogo;
		try {
			catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(13);
			catalogoDataManager.setCatalogoList(administracionService.getCatalogo(catalogo));
			catalogoDataManager.setCatalogo(new CatalogoDTO());
			getCatalogoPais();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void crearProvincia()
	{
		CatalogoDTO catalogo;
		try {
			catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(Integer.valueOf(getPais().toString()));
			catalogoDataManager.getCatalogo().setAteCatalogo(catalogo);
			administracionService.createCatalogo(catalogoDataManager.getCatalogo());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			buscarProvincia();
			catalogoDataManager.setCatalogo(new CatalogoDTO());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void buscarProvincia()
	{
		CatalogoDTO catalogo;
		try {
			catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(getPais()!=null?Integer.valueOf(getPais().toString()):-3);
			catalogoDataManager.setCatalogoList(administracionService.getCatalogo(catalogo));
			catalogoDataManager.setCatalogo(new CatalogoDTO());
			getCatalogoPais();
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
