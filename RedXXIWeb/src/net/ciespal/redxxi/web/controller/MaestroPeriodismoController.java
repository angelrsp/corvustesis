package net.ciespal.redxxi.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.MaestroPeriodismoDataManager;

import org.primefaces.event.FileUploadEvent;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "maestroPeriodismoController")
public class MaestroPeriodismoController extends SelectItemController {

	
	@EJB
	private EspejoService espejoService;
	
	@ManagedProperty(value="#{maestroPeriodismoDataManager}")
	private MaestroPeriodismoDataManager maestroPeriodismoDataManager;

	public MaestroPeriodismoController() {
	
	}

	@PostConstruct
	private void init()
	{

	}

	public MaestroPeriodismoDataManager getMaestroPeriodismoDataManager() {
		return maestroPeriodismoDataManager;
	}

	public void setMaestroPeriodismoDataManager(
			MaestroPeriodismoDataManager maestroPeriodismoDataManager) {
		this.maestroPeriodismoDataManager = maestroPeriodismoDataManager;
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
	
	public void save()
	{
		try {
			maestroPeriodismoDataManager.getGranMaestroDTO().setGmaPais(Integer.valueOf(getPais().toString()));
			maestroPeriodismoDataManager.getGranMaestroDTO().setGmaProvincia(Integer.valueOf(getProvincia().toString()));
			maestroPeriodismoDataManager.getGranMaestroDTO().setGmaCiudad(Integer.valueOf(getCiudad().toString()));
			maestroPeriodismoDataManager.getGranMaestroDTO().setGmaFechaNacimiento(new Timestamp(maestroPeriodismoDataManager.getFechaNacimiento().getTime()));
			maestroPeriodismoDataManager.getGranMaestroDTO().setGmaFechaFallecimiento(new Timestamp(maestroPeriodismoDataManager.getFechaFallecimiento().getTime()));
			espejoService.createOrUpdateMaestroPeriodismo(maestroPeriodismoDataManager.getGranMaestroDTO());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void cancel()
	{
		maestroPeriodismoDataManager.setGranMaestroDTO(new GranMaestroDTO());
	}
	
	public void edit(GranMaestroDTO maestro)
	{
		maestroPeriodismoDataManager.setGranMaestroDTO(maestro);
		if(maestro.getGmaFechaNacimiento()!=null)
			maestroPeriodismoDataManager.setFechaNacimiento(new Date(maestro.getGmaFechaNacimiento().getTime()));
		if(maestro.getGmaFechaFallecimiento()!=null)
			maestroPeriodismoDataManager.setFechaFallecimiento(new Date(maestro.getGmaFechaFallecimiento().getTime()));
		if(maestro.getGmaFoto()!=null)
			maestroPeriodismoDataManager.getGranMaestroDTO().setGmaFotoPath(JsfUtil.saveToDiskUpdload(maestro.getGmaFoto(), maestro.getGmaFotoNombre()));
	}

	public void ciudadChange()
	{
		read();
	}
	
	private void read()
	{
		try {
			maestroPeriodismoDataManager.setGranMaestroList(espejoService.readMaestroPeriodismo(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void handleFileUploadFoto(FileUploadEvent event)
	{
		maestroPeriodismoDataManager.getGranMaestroDTO().setGmaFoto(event.getFile().getContents());
		maestroPeriodismoDataManager.getGranMaestroDTO().setGmaFotoNombre(event.getFile().getFileName());
		maestroPeriodismoDataManager.getGranMaestroDTO().setGmaFotoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}

	public void maestroSelect(GranMaestroDTO maestro)
	{
		maestroPeriodismoDataManager.setGranMaestroDTO(maestro);
		readNoticia();
		readObra();
		readObraSobre();
	}
	
	public void createNoticia()
	{
		try {
			maestroPeriodismoDataManager.getNoticia().setEspEntidad(maestroPeriodismoDataManager.getGranMaestroDTO().getEspEntidad());
			espejoService.createOrUpdateNoticia(maestroPeriodismoDataManager.getNoticia());
			readNoticia();
			cancelNoticia();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelNoticia()
	{
		maestroPeriodismoDataManager.setNoticia(new NoticiaEspejoDTO());
	}
	
	private void readNoticia()
	{
		try {
			maestroPeriodismoDataManager.setNoticiaList(espejoService.readNoticia(maestroPeriodismoDataManager.getGranMaestroDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editNoticia(NoticiaEspejoDTO noticia)
	{
		maestroPeriodismoDataManager.setNoticia(noticia);
	}
	
	public void deleteNoticia(NoticiaEspejoDTO noticia)
	{
		try {
			espejoService.deleteNoticia(noticia);
			readNoticia();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}


	public void handleFileUploadArchivo(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		maestroPeriodismoDataManager.getObra().setObrArchivo(event.getFile().getContents());
		maestroPeriodismoDataManager.getObra().setObrArchivoNombre(event.getFile().getFileName());
		maestroPeriodismoDataManager.getObra().setObrArchivoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}
	
	public void createObra()
	{
		try {
			maestroPeriodismoDataManager.getObra().setEspEntidad(maestroPeriodismoDataManager.getGranMaestroDTO().getEspEntidad());
			maestroPeriodismoDataManager.getObra().setObrTipo(1);
			espejoService.createOrUpdateObra(maestroPeriodismoDataManager.getObra());
			readObra();
			cancelObra();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void cancelObra()
	{
		maestroPeriodismoDataManager.setObra(new ObraEspejoDTO());
	}

	public void editObra(ObraEspejoDTO obra)
	{
		maestroPeriodismoDataManager.setObra(obra);
	}
	
	public void deleteObra(ObraEspejoDTO obra)
	{
		try {
			espejoService.deleteObra(obra);
			readObra();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readObra()
	{
		try {
			maestroPeriodismoDataManager.setObraList(espejoService.readObra(maestroPeriodismoDataManager.getGranMaestroDTO(), 1));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	
	public void handleFileUploadArchivoSobre(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		maestroPeriodismoDataManager.getObraSobre().setObrArchivo(event.getFile().getContents());
		maestroPeriodismoDataManager.getObraSobre().setObrArchivoNombre(event.getFile().getFileName());
		maestroPeriodismoDataManager.getObraSobre().setObrArchivoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}
	
	public void createObraSobre()
	{
		try {
			maestroPeriodismoDataManager.getObraSobre().setEspEntidad(maestroPeriodismoDataManager.getGranMaestroDTO().getEspEntidad());
			maestroPeriodismoDataManager.getObraSobre().setObrTipo(2);
			espejoService.createOrUpdateObra(maestroPeriodismoDataManager.getObraSobre());
			readObraSobre();
			cancelObraSobre();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void cancelObraSobre()
	{
		maestroPeriodismoDataManager.setObraSobre(new ObraEspejoDTO());
	}

	public void editObraSobre(ObraEspejoDTO obra)
	{
		maestroPeriodismoDataManager.setObraSobre(obra);
	}
	
	public void deleteObraSobre(ObraEspejoDTO obra)
	{
		try {
			espejoService.deleteObra(obra);
			readObraSobre();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readObraSobre()
	{
		try {
			maestroPeriodismoDataManager.setObraSobreList(espejoService.readObra(maestroPeriodismoDataManager.getGranMaestroDTO(), 2));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void delete(GranMaestroDTO granMaestro)
	{
		try {
			espejoService.deleteMaestroPeriodismo(granMaestro);
			read();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
