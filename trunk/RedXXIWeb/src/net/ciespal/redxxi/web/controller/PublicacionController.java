package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
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
	
	@PostConstruct
	private void init()
	{
		//readPublicacionPublic();
	}
	
	public PublicacionDataManager getPublicacionDataManager() {
		return publicacionDataManager;
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
			publicacionDataManager.getPublicacion().setPubPais(Integer.valueOf(getPais().toString()));
			publicacionDataManager.getPublicacion().setPubProvincia(Integer.valueOf(getProvincia().toString()));
			publicacionDataManager.getPublicacion().setPubCiudad(Integer.valueOf(getCiudad().toString()));
			publicacionDataManager.getPublicacion().setPubCampoConocimiento(Integer.valueOf(getSubCampoConocimiento().toString()));
			publicacionDataManager.getPublicacion().setPubTipo(Integer.valueOf(publicacionDataManager.getTipoPublicacion().toString()));
			ateneaService.createOrUpdatePublicacion(publicacionDataManager.getPublicacion(),false);
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
			publicacionDataManager.setPublicacionList(ateneaService.readPublicacionNoEntity(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
//	private void readPublicacionPublic()
//	{
//		try {
//			publicacionDataManager.setPublicacionListPublic(ateneaService.readPublicacion());
//		} catch (CorvustecException e) {
//			JsfUtil.addErrorMessage(e.toString());
//		}
//	}
	
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
		
		if(publicacion.getPubArchivo()!=null)
			publicacionDataManager.getPublicacion().setPubArchivoPath(JsfUtil.saveToDiskUpdload(publicacion.getPubArchivo(), publicacion.getPubArchivoNombre()));
	}
	
	public void handleFileUploadArchivo(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		publicacionDataManager.getPublicacion().setPubArchivo(event.getFile().getContents());
		publicacionDataManager.getPublicacion().setPubArchivoNombre(event.getFile().getFileName());
		publicacionDataManager.getPublicacion().setPubArchivoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}

	
	public void delete(PublicacionDTO publicacion)
	{
		try {
			ateneaService.deletePublicacion(publicacion);
			readPublicacion();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
