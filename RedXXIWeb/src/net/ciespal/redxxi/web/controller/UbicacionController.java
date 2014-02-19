package net.ciespal.redxxi.web.controller;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.UbicacionDataManager;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
		getImage();
	}
	
	public StreamedContent getImage(){
		String mime;
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }else{
			if(ubicacionDataManager.getImageBytePais()!=null)
			{
				mime=JsfUtil.getTypeFile(ubicacionDataManager.getImageBytePais());
				return new DefaultStreamedContent(new ByteArrayInputStream(ubicacionDataManager.getImageBytePais()),mime);
			}
			else
				return new DefaultStreamedContent();
        }
	}
	
	
	
	
	public void savePais()
	{
		try {
			if(ubicacionDataManager.getImageBytePais()!=null)
				ubicacionDataManager.getPais().setCatImagen(ubicacionDataManager.getImageBytePais());
			administracionService.createOrUpdateCatalogo(ubicacionDataManager.getPais());
			ubicacionDataManager.setPais(new CatalogoDTO());
			ubicacionDataManager.setImageBytePais(null);
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
	}

	public void deletePais(CatalogoDTO pais)
	{
		
	}

}
