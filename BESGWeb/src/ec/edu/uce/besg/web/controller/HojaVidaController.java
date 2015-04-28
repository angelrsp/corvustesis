package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.service.CatalogoService;
import ec.edu.uce.besg.web.datamanager.HojaVidaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;


@ViewScoped
@ManagedBean(name = "hojaVidaController")
public class HojaVidaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogoService catalogoService;
	
	@ManagedProperty(value="#{hojaVidaDataManager}")
	private HojaVidaDataManager hojaVidaDataManager;
	
	
	public HojaVidaController() {
	
	}

	
	public HojaVidaDataManager getHojaVidaDataManager() {
		return hojaVidaDataManager;
	}
	public void setHojaVidaDataManager(HojaVidaDataManager hojaVidaDataManager) {
		this.hojaVidaDataManager = hojaVidaDataManager;
	}


	@PostConstruct
	private void init()
	{
		readIdentificationType();
		readEstadoCivil();
		readGenero();
	}
	
	
	private void readIdentificationType() {
		try {
			hojaVidaDataManager.setTipoDocumentoList(catalogoService.readIdentificationType());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readEstadoCivil() {
		try {
			hojaVidaDataManager.setEstadoCivilList(catalogoService.readEstadoCivil());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readGenero() {
		try {
			hojaVidaDataManager.setGeneroList(catalogoService.readSex());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public void handleFileUpload(FileUploadEvent event) {
		
    }
	
}
