package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.PremioCiespalDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "premioCiespalController")
public class PremioCiespalController extends SelectItemController{

	@EJB
	private EspejoService espejoService;
	
	@ManagedProperty(value="#{premioCiespalDataManager}")
	private PremioCiespalDataManager premioCiespalDataManager;

	public PremioCiespalController() {
	
	}
	
	@PostConstruct
	private void init()
	{
		
	}

	public PremioCiespalDataManager getPremioCiespalDataManager() {
		return premioCiespalDataManager;
	}

	public void setPremioCiespalDataManager(
			PremioCiespalDataManager premioCiespalDataManager) {
		this.premioCiespalDataManager = premioCiespalDataManager;
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
			premioCiespalDataManager.getPremioCiespalDTO().setPciPais(Integer.valueOf(getPais().toString()));
			premioCiespalDataManager.getPremioCiespalDTO().setPciProvincia(Integer.valueOf(getProvincia().toString()));
			premioCiespalDataManager.getPremioCiespalDTO().setPciCiudad(Integer.valueOf(getCiudad().toString()));
			premioCiespalDataManager.getPremioCiespalDTO().setPciMedio(Integer.valueOf(premioCiespalDataManager.getTipoMedio().toString()));
			espejoService.createOrUpdatepremioCiespal(premioCiespalDataManager.getPremioCiespalDTO());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void cancel()
	{
		premioCiespalDataManager.setPremioCiespalDTO(new PremioCiespalDTO());
		premioCiespalDataManager.setTipoMedio(null);
	}
	
	public void edit(PremioCiespalDTO premioCiespal)
	{
		premioCiespalDataManager.setPremioCiespalDTO(premioCiespal);
		premioCiespalDataManager.setTipoMedio(premioCiespal.getPciMedio());
	}

	public void delete(PremioCiespalDTO premioCiespal)
	{
		try {
			espejoService.deletePremioCiespal(premioCiespal);
			read();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void ciudadChange()
	{
		read();
	}
	
	private void read()
	{
		try {
			premioCiespalDataManager.setPremioCiespalList(espejoService.readPremioCiespal(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void premioSelect(PremioCiespalDTO premio)
	{
		premioCiespalDataManager.setPremioCiespalDTO(premio);
		readNoticia();
	}
	
	public void createNoticia()
	{
		try {
			premioCiespalDataManager.getNoticia().setEspEntidad(premioCiespalDataManager.getPremioCiespalDTO().getEspEntidad());
			espejoService.createOrUpdateNoticia(premioCiespalDataManager.getNoticia());
			readNoticia();
			cancelNoticia();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelNoticia()
	{
		premioCiespalDataManager.setNoticia(new NoticiaEspejoDTO());
	}
	
	private void readNoticia()
	{
		try {
			premioCiespalDataManager.setNoticiaList(espejoService.readNoticia(premioCiespalDataManager.getPremioCiespalDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editNoticia(NoticiaEspejoDTO noticia)
	{
		premioCiespalDataManager.setNoticia(noticia);
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
		premioCiespalDataManager.getPremioCiespalDTO().setPciArchivo(event.getFile().getContents());
		premioCiespalDataManager.getPremioCiespalDTO().setPciArchivoNombre(event.getFile().getFileName());
		premioCiespalDataManager.getPremioCiespalDTO().setPciArchivoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}

}
