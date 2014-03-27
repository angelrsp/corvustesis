package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.PremioPeriodisticoDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "premioPeriodisticoController")
public class PremioPeriodisticoController extends SelectItemController {
	@EJB
	private EspejoService espejoService;
	
	@ManagedProperty(value="#{premioPeriodisticoDataManager}")
	private PremioPeriodisticoDataManager premioPeriodisticoDataManager;

	public PremioPeriodisticoController() {
	
	}
	
	@PostConstruct
	private void init()
	{
		
	}

	
	

	public PremioPeriodisticoDataManager getPremioPeriodisticoDataManager() {
		return premioPeriodisticoDataManager;
	}

	public void setPremioPeriodisticoDataManager(
			PremioPeriodisticoDataManager premioPeriodisticoDataManager) {
		this.premioPeriodisticoDataManager = premioPeriodisticoDataManager;
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
			premioPeriodisticoDataManager.getPremioDTO().setPrePais(Integer.valueOf(getPais().toString()));
			premioPeriodisticoDataManager.getPremioDTO().setPreProvincia(Integer.valueOf(getProvincia().toString()));
			premioPeriodisticoDataManager.getPremioDTO().setPreCiudad(Integer.valueOf(getCiudad().toString()));
			espejoService.createOrUpdatePremio(premioPeriodisticoDataManager.getPremioDTO());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void cancel()
	{
		premioPeriodisticoDataManager.setPremioDTO(new PremioDTO());
	}
	
	public void edit(PremioDTO premio)
	{
		premioPeriodisticoDataManager.setPremioDTO(premio);
	}

	public void delete(PremioDTO premio)
	{
		
	}

	public void ciudadChange()
	{
		read();
	}
	
	private void read()
	{
		try {
			premioPeriodisticoDataManager.setPremioList(espejoService.readPremio(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
