package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoVisorDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.EspejoDataManager;
import net.ciespal.redxxi.web.datamanager.home.EspejoVisorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "espejoVisorController")
public class EspejoVisorController {


	@ManagedProperty(value="#{espejoDataManager}")
	private EspejoDataManager espejoDataManager;
 	
	@ManagedProperty(value="#{espejoVisorDataManager}")
	private EspejoVisorDataManager espejoVisorDataManager;


	@EJB
	private EspejoService espejoService;
	
	public EspejoVisorController() {
	
	}
	
	public EspejoDataManager getEspejoDataManager() {
		return espejoDataManager;
	}

	public void setEspejoDataManager(EspejoDataManager espejoDataManager) {
		this.espejoDataManager = espejoDataManager;
	}

	public EspejoVisorDataManager getEspejoVisorDataManager() {
		return espejoVisorDataManager;
	}

	public void setEspejoVisorDataManager(
			EspejoVisorDataManager espejoVisorDataManager) {
		this.espejoVisorDataManager = espejoVisorDataManager;
	}

	public void selectEspejo(EspejoDTO espejo)
	{
		try {
			espejo.setPais(espejoDataManager.getPais().getCodigo());
			espejoDataManager.setEspejoVisorList(espejoService.visorList(espejo));
			
			if(espejo.getTipo()==1)
				espejoDataManager.setTipoConsulta("Etica y Deontologia");
			else if(espejo.getTipo()==2)
				espejoDataManager.setTipoConsulta("Grandes Maestros del Periodismo");
			else if(espejo.getTipo()==3)
				espejoDataManager.setTipoConsulta("Maestros de la Comunicación");
			else if(espejo.getTipo()==4)
				espejoDataManager.setTipoConsulta("Premios Periodísticos");
			else if(espejo.getTipo()==5)
				espejoDataManager.setTipoConsulta("Códigos de Ética y Leyes de Comunicación");			
			
		}catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void selectItem(EspejoVisorDTO espejoVisor)
	{
		try {
			espejoVisorDataManager.setItem(espejoService.espejoItem(espejoVisor));
			JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/espejoItem.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
