package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.PublicacionDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "publicacionController")
public class PublicacionController extends SelectItemController {

	
	@EJB
	private AteneaService ateneaService;
	
	@EJB
	private AdministracionService administracionService;

	
	@ManagedProperty(value="#{publicacionDataManager}")
	private PublicacionDataManager publicacionDataManager;

	
	public PublicacionController() {
	}
	
	
	public void setPublicacionDataManager(PublicacionDataManager publicacionDataManager) {
		this.publicacionDataManager = publicacionDataManager;
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
		readPublicacion();
	}
	
	public void obtenerSubcampoChange() {
		try {
 			getCatalogoSubCampoConocimiento();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void save()
	{
		try {
			publicacionDataManager.getPublicacion().addAteEntidad(new EntidadDTO());
			publicacionDataManager.getPublicacion().setPubUbicacion(Integer.valueOf(getCiudad().toString()));
			publicacionDataManager.getPublicacion().setPubCampoConocimiento(Integer.valueOf(getSubCampoConocimiento().toString()));
			publicacionDataManager.getPublicacion().setPubTipo(Integer.valueOf(publicacionDataManager.getTipoPublicacion().toString()));
			ateneaService.createOrUpdatePublicacion(publicacionDataManager.getPublicacion());
			publicacionDataManager.setPublicacion(new PublicacionDTO());
			readPublicacion();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readPublicacion()
	{
		try {
			publicacionDataManager.setPublicacionList(ateneaService.readPublicacion(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void cancel()
	{
		publicacionDataManager.setPublicacion(new PublicacionDTO());
		publicacionDataManager.setTipoPublicacion(null);
		setCampoConocimiento(null);
		setSubCampoConocimiento(null);
	}
	
	public void edit(PublicacionDTO publicacion)
	{
		CatalogoDTO campoConocimiento=new CatalogoDTO();
		publicacionDataManager.setPublicacion(publicacion);
		publicacionDataManager.setTipoPublicacion(publicacion.getPubTipo());
		try {
			campoConocimiento=administracionService.getCatalogo(publicacion.getPubCampoConocimiento()).getAteCatalogo();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		setCampoConocimiento(campoConocimiento.getCatCodigo());
		setSubCampoConocimiento(publicacion.getPubCampoConocimiento());
	}
	
	public void delete(PublicacionDTO publicacion)
	{
		
	}
}
