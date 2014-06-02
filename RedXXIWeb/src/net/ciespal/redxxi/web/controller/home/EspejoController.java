package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.ArgosDataManager;
import net.ciespal.redxxi.web.datamanager.home.EspejoDataManager;



@ViewScoped
@ManagedBean(name = "espejoDataManager")
public class EspejoController {

	
	@EJB
	private EspejoService espejoService;
	
	@ManagedProperty(value="#{espejoDataManager}")
	private EspejoDataManager espejoDataManager;

	
	public EspejoController() {
	}

	
	
	@PostConstruct
	private void init()
	{
		readArgos();
		readPais();
	}

	public EspejoDataManager getEspejoDataManager() {
		return espejoDataManager;
	}

	public void setEspejoDataManager(EspejoDataManager espejoDataManager) {
		this.espejoDataManager = espejoDataManager;
	}



	private void readArgos()
	{
		try {
			espejoDataManager.setEspejoList(espejoService.readEspejo(null));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readPais()
	{
		try {
			espejoDataManager.setPaisList(espejoService.readPais(null));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void selectArgos(EspejoDTO espejo)
	{
		try {		
			espejoDataManager.setPaisList(espejoService.readPais(espejo.getTipo()));
			espejoDataManager.setEspejo(espejo);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void selectPais(PaisDTO pais)
	{
		EspejoDTO espejo;
		try {
			espejoDataManager.setPais(pais);
			espejoDataManager.setEspejoList(espejoService.readEspejo(pais.getCodigo()));
			//reportPublicDataManager.setVisor(ateneaService.infoPais(pais));
			if(espejoDataManager.getEspejo().getTipo()!=0)
				pais.setTipo(espejoDataManager.getEspejo().getTipo());
			else
				pais.setTipo(1);

			espejo=new EspejoDTO();
			espejo.setPais(pais.getCodigo());
			espejo.setTipo(pais.getTipo());
			
			espejoDataManager.setEspejoVisorList(espejoService.visorList(espejo));
			espejoDataManager.getEspejo().setTipo(0);
			JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/espejoVisor.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
}
