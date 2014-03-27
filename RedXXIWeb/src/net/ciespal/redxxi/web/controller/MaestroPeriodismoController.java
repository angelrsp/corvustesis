package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.MaestroPeriodismoDataManager;

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
	}

	public void delete(EticaDTO etica)
	{
		
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

	
}
