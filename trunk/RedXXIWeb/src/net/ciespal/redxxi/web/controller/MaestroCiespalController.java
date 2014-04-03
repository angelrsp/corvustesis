package net.ciespal.redxxi.web.controller;

import java.sql.Timestamp;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.MaestroCiespalDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "maestroCiespalController")
public class MaestroCiespalController extends SelectItemController{

	@EJB
	private EspejoService espejoService;
	
	@ManagedProperty(value="#{maestroCiespalDataManager}")
	private MaestroCiespalDataManager maestroCiespalDataManager;

	public MaestroCiespalController() {
	
	}
	
	@PostConstruct
	private void init()
	{
		
	}

	
	public MaestroCiespalDataManager getMaestroCiespalDataManager() {
		return maestroCiespalDataManager;
	}

	public void setMaestroCiespalDataManager(
			MaestroCiespalDataManager maestroCiespalDataManager) {
		this.maestroCiespalDataManager = maestroCiespalDataManager;
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
			maestroCiespalDataManager.getMaestroCiespalDTO().setMciPais(Integer.valueOf(getPais().toString()));
			maestroCiespalDataManager.getMaestroCiespalDTO().setMciProvincia(Integer.valueOf(getProvincia().toString()));
			maestroCiespalDataManager.getMaestroCiespalDTO().setMciCiudad(Integer.valueOf(getCiudad().toString()));
			maestroCiespalDataManager.getMaestroCiespalDTO().setMciFechaNacimiento(new Timestamp(maestroCiespalDataManager.getFechaNacimiento().getTime()));
			espejoService.createOrUpdateMaestroCiespal(maestroCiespalDataManager.getMaestroCiespalDTO());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void cancel()
	{
		maestroCiespalDataManager.setMaestroCiespalDTO(new MaestroCiespalDTO());
	}
	
	public void edit(MaestroCiespalDTO maestro)
	{
		maestroCiespalDataManager.setMaestroCiespalDTO(maestro);
	}

	public void delete(MaestroCiespalDTO maestro)
	{
		
	}

	public void ciudadChange()
	{
		read();
	}
	
	private void read()
	{
		try {
			maestroCiespalDataManager.setMaestroCiespalList(espejoService.readMaestroCiespal(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void maestroSelect(MaestroCiespalDTO maestro)
	{
		maestroCiespalDataManager.setMaestroCiespalDTO(maestro);
		readNoticia();
	}
	
	public void createNoticia()
	{
		try {
			maestroCiespalDataManager.getNoticia().setEspEntidad(maestroCiespalDataManager.getMaestroCiespalDTO().getEspEntidad());
			espejoService.createOrUpdateNoticia(maestroCiespalDataManager.getNoticia());
			readNoticia();
			cancelNoticia();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelNoticia()
	{
		maestroCiespalDataManager.setNoticia(new NoticiaEspejoDTO());
	}
	
	private void readNoticia()
	{
		try {
			maestroCiespalDataManager.setNoticiaList(espejoService.readNoticia(maestroCiespalDataManager.getMaestroCiespalDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editNoticia(NoticiaEspejoDTO noticia)
	{
		maestroCiespalDataManager.setNoticia(noticia);
	}
	
	public void deleteNoticia(NoticiaEspejoDTO noticia)
	{
		
	}

	public void handleFileUploadArchivo(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		maestroCiespalDataManager.getObra().setObrArchivo(event.getFile().getContents());
		maestroCiespalDataManager.getObra().setObrArchivoNombre(event.getFile().getFileName());
		maestroCiespalDataManager.getObra().setObrArchivoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}
	
	public void createObra()
	{
		try {
			maestroCiespalDataManager.getObra().setEspEntidad(maestroCiespalDataManager.getMaestroCiespalDTO().getEspEntidad());
			maestroCiespalDataManager.getObra().setObrTipo(1);
			espejoService.createOrUpdateObra(maestroCiespalDataManager.getObra());
			readObra();
			cancelObra();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void cancelObra()
	{
		maestroCiespalDataManager.setObra(new ObraEspejoDTO());
	}

	public void editObra(ObraEspejoDTO obra)
	{
		maestroCiespalDataManager.setObra(obra);
	}
	
	public void deleteObra(ObraEspejoDTO obra)
	{
		
	}
	
	private void readObra()
	{
		try {
			maestroCiespalDataManager.setObraList(espejoService.readObra(maestroCiespalDataManager.getMaestroCiespalDTO(), 1));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
