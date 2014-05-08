package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ObservatorioDataManager;

import com.corvustec.commons.util.CorvustecException;


@ViewScoped
@ManagedBean(name = "observatorioController")
public class ObservatorioController extends SelectItemController{

	@EJB
	private ArgosService argosService;
	
	@ManagedProperty(value="#{observatorioDataManager}")
	private ObservatorioDataManager observatorioDataManager;

	public ObservatorioController() {

	}

	@PostConstruct
	private void init()
	{
		readRed();
	}
	
	public ObservatorioDataManager getObservatorioDataManager() {
		return observatorioDataManager;
	}

	public void setObservatorioDataManager(ObservatorioDataManager observatorioDataManager) {
		this.observatorioDataManager = observatorioDataManager;
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
			observatorioDataManager.getObservatorio().setObsPais(Integer.valueOf(getPais().toString()));
			observatorioDataManager.getObservatorio().setObsProvincia(Integer.valueOf(getProvincia().toString()));
			observatorioDataManager.getObservatorio().setObsCiudad(Integer.valueOf(getCiudad().toString()));
			//observatorioDataManager.getObservatorio().setArgRed(new RedDTO(observatorioDataManager.getRedValue()));
			argosService.createOrUpdateObservatorio(observatorioDataManager.getObservatorio());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void cancel()
	{
		observatorioDataManager.setObservatorio(new ObservatorioDTO());
	}
	
	public void edit(ObservatorioDTO observatorio)
	{
		observatorioDataManager.setObservatorio(observatorio);
		observatorioDataManager.setRedValue(observatorio.getArgRed().getRedCodigo());
	}

	public void delete(ObservatorioDTO observatorio)
	{
		try {
			argosService.deleteObservatorio(observatorio);
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
			observatorioDataManager.setObservatorioList(argosService.readObservatorio(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readRed() {
		try {
			observatorioDataManager.setRedList(argosService.readRed());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void selectObservatorio(ObservatorioDTO observatorio)
	{
		observatorioDataManager.setObservatorio(observatorio);
		readContacto();
	}
	
	public void createContacto()
	{
		try {
			observatorioDataManager.getContacto().setConTipo(Integer.valueOf(observatorioDataManager.getTipoContacto().toString()));
			observatorioDataManager.getContacto().setArgEntidad(observatorioDataManager.getObservatorio().getArgEntidad());
			argosService.createOrUpdateContacto(observatorioDataManager.getContacto());
			readContacto();
			cancelContacto();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readContacto()
	{
		try {
			observatorioDataManager.setContactoList(argosService.readContacto(observatorioDataManager.getObservatorio().getArgEntidad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}

	}
	
	public void cancelContacto()
	{
		observatorioDataManager.setContacto(new ContactoArgosDTO());
		observatorioDataManager.setTipoContacto(null);
	}
	
	public void editContacto(ContactoArgosListDTO contacto)
	{
		try {
			observatorioDataManager.setContacto(argosService.readContacto(contacto.getConCodigo()));
			observatorioDataManager.setTipoContacto(contacto.getConTipo());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void deleteContacto(ContactoArgosListDTO contacto)
	{
		try {
			argosService.deleteContacto(contacto);
			readContacto();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
