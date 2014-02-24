package net.ciespal.redxxi.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.UbicacionDataManager;

import org.primefaces.event.FileUploadEvent;

import com.corvustec.commons.util.CorvustecException;

@SessionScoped
@ManagedBean(name="ubicacionController")
public class UbicacionController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	@ManagedProperty(value="#{ubicacionDataManager}")
	private UbicacionDataManager ubicacionDataManager;

	public UbicacionController() {
	}
	
	@PostConstruct
	private void init()
	{
		readPais();
	}
	
	public UbicacionDataManager getUbicacionDataManager() {
		return ubicacionDataManager;
	}

	public void setUbicacionDataManager(UbicacionDataManager ubicacionDataManager) {
		this.ubicacionDataManager = ubicacionDataManager;
	}

	public void handleFileUpload(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		ubicacionDataManager.setImageBytePais(event.getFile().getContents());
		ubicacionDataManager.setNameImage(event.getFile().getFileName());
		ubicacionDataManager.setPathImage(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}
	
	
	public void savePais()
	{
		try {
			ubicacionDataManager.getPais().setAteCatalogo(new CatalogoDTO(13));;
			ubicacionDataManager.getPais().setCatImagen(ubicacionDataManager.getImageBytePais());
			ubicacionDataManager.getPais().setCatImagenNombre(ubicacionDataManager.getNameImage());
			administracionService.createOrUpdateCatalogo(ubicacionDataManager.getPais());
			cancelPais();
			readPais();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readPais()
	{
		try {
			ubicacionDataManager.setPaisList(administracionService.getCatalogo(new CatalogoDTO(13)));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editPais(CatalogoDTO pais)
	{
		ubicacionDataManager.setPais(pais);
		ubicacionDataManager.setImageBytePais(pais.getCatImagen());
		ubicacionDataManager.setNameImage(pais.getCatImagenNombre());
		ubicacionDataManager.setPathImage(JsfUtil.saveToDiskUpdload(pais.getCatImagen(), pais.getCatImagenNombre()));
	}

	public void deletePais(CatalogoDTO pais)
	{
		
	}
	
	public void cancelPais()
	{
		ubicacionDataManager.setPais(new CatalogoDTO());
		ubicacionDataManager.setImageBytePais(null);
		ubicacionDataManager.setNameImage(null);
		ubicacionDataManager.setPathImage(null);		
	}

	public void selectProcinvia(CatalogoDTO pais)
	{
		ubicacionDataManager.setPais(pais);
		readProvincia();
	}
	
	
	public void saveProvincia()
	{
		try {
			ubicacionDataManager.getProvincia().setAteCatalogo(ubicacionDataManager.getPais());;
			administracionService.createOrUpdateCatalogo(ubicacionDataManager.getProvincia());
			cancelProvinvia();
			readProvincia();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelProvinvia()
	{
		ubicacionDataManager.setProvincia(new CatalogoDTO());
		ubicacionDataManager.setImageBytePais(null);
		ubicacionDataManager.setNameImage(null);
		ubicacionDataManager.setPathImage(null);		
	}
	
	private void readProvincia()
	{
		try {
			ubicacionDataManager.setProvinciaList(administracionService.getCatalogo(ubicacionDataManager.getPais()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editProvincia(CatalogoDTO provincia)
	{
		ubicacionDataManager.setProvincia(provincia);	
	}
	
	public void deleteProvincia(CatalogoDTO provincia)
	{
		try {
			administracionService.deleteCatalogo(provincia);
			readProvincia();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	
	public void selectCiudad(CatalogoDTO provincia)
	{
		ubicacionDataManager.setProvincia(provincia);
		readCiudad();
	}
	
	
	public void saveCiudad()
	{
		try {
			ubicacionDataManager.getCiudad().setAteCatalogo(ubicacionDataManager.getProvincia());;
			administracionService.createOrUpdateCatalogo(ubicacionDataManager.getCiudad());
			cancelCiudad();
			readCiudad();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelCiudad()
	{
		ubicacionDataManager.setCiudad(new CatalogoDTO());
		ubicacionDataManager.setImageBytePais(null);
		ubicacionDataManager.setNameImage(null);
		ubicacionDataManager.setPathImage(null);		
	}
	
	private void readCiudad()
	{
		try {
			ubicacionDataManager.setCiudadList(administracionService.getCatalogo(ubicacionDataManager.getProvincia()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editCiudad(CatalogoDTO ciudad)
	{
		ubicacionDataManager.setCiudad(ciudad);
	}
	
	public void deleteCiudad(CatalogoDTO ciudad)
	{
		try {
			administracionService.deleteCatalogo(ciudad);
			readCiudad();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
