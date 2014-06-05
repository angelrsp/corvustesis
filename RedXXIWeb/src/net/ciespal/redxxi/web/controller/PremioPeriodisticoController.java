package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
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
			premioPeriodisticoDataManager.getPremioDTO().setPreTipoMedio(Integer.valueOf(premioPeriodisticoDataManager.getTipoMedioComunicacion().toString()));
			premioPeriodisticoDataManager.getPremioDTO().setPreNivelGeografico(Integer.valueOf(premioPeriodisticoDataManager.getNivelGeografico().toString()));
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
		premioPeriodisticoDataManager.setNivelGeografico(null);
		premioPeriodisticoDataManager.setTipoMedioComunicacion(null);
	}
	
	public void edit(PremioDTO premio)
	{
		premioPeriodisticoDataManager.setPremioDTO(premio);
		premioPeriodisticoDataManager.setNivelGeografico(premio.getPreNivelGeografico());
		premioPeriodisticoDataManager.setTipoMedioComunicacion(premio.getPreTipoMedio());
	}

	public void delete(PremioDTO premio)
	{
		try {
			espejoService.deletePremio(premio);
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
			premioPeriodisticoDataManager.setPremioList(espejoService.readPremio(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void premioSelect(PremioDTO premio)
	{
		premioPeriodisticoDataManager.setPremioDTO(premio);
		readNoticia();
	}
	
	public void createNoticia()
	{
		try {
			premioPeriodisticoDataManager.getNoticia().setEspEntidad(premioPeriodisticoDataManager.getPremioDTO().getEspEntidad());
			espejoService.createOrUpdateNoticia(premioPeriodisticoDataManager.getNoticia());
			readNoticia();
			cancelNoticia();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelNoticia()
	{
		premioPeriodisticoDataManager.setNoticia(new NoticiaEspejoDTO());
	}
	
	private void readNoticia()
	{
		try {
			premioPeriodisticoDataManager.setNoticiaList(espejoService.readNoticia(premioPeriodisticoDataManager.getPremioDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editNoticia(NoticiaEspejoDTO noticia)
	{
		premioPeriodisticoDataManager.setNoticia(noticia);
	}
	
	public void deleteNoticia(NoticiaEspejoDTO noticia)
	{
		try {
			espejoService.deleteNoticia(noticia);
			readNoticia();
			JsfUtil.addErrorMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
