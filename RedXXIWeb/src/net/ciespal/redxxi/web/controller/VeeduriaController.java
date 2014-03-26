package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.VeeduriaDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "veeduriaController")
public class VeeduriaController extends SelectItemController{

	@EJB
	private ArgosService argosService;
	
	@ManagedProperty(value="#{veeduriaDataManager}")
	private VeeduriaDataManager veeduriaDataManager;

	public VeeduriaController() {
	
	}
	
	@PostConstruct
	private void init()
	{
		
	}

	public VeeduriaDataManager getVeeduriaDataManager() {
		return veeduriaDataManager;
	}

	public void setVeeduriaDataManager(VeeduriaDataManager veeduriaDataManager) {
		this.veeduriaDataManager = veeduriaDataManager;
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
			veeduriaDataManager.getVeeduria().setVeePais(Integer.valueOf(getPais().toString()));
			veeduriaDataManager.getVeeduria().setVeeProvincia(Integer.valueOf(getProvincia().toString()));
			veeduriaDataManager.getVeeduria().setVeeCiudad(Integer.valueOf(getCiudad().toString()));
			argosService.createOrUpdateVeeduria(veeduriaDataManager.getVeeduria());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void cancel()
	{
		veeduriaDataManager.setVeeduria(new VeeduriaDTO());
	}
	
	public void edit(VeeduriaDTO veeduria)
	{
		veeduriaDataManager.setVeeduria(veeduria);
	}

	public void delete(VeeduriaDTO veeduria)
	{
		
	}

	public void ciudadChange()
	{
		read();
	}
	
	private void read()
	{
		try {
			veeduriaDataManager.setVeeduriaList(argosService.readVeeduria(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
