package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosVisorDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.ArgosDataManager;
import net.ciespal.redxxi.web.datamanager.home.ArgosVisorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "argosVisorController")
public class ArgosVisorController {

	@ManagedProperty(value="#{argosDataManager}")
	private ArgosDataManager argosDataManager;

	@ManagedProperty(value="#{argosVisorDataManager}")
	private ArgosVisorDataManager argosVisorDataManager;

	@EJB
	private ArgosService argosService;
	
	public ArgosVisorController() {
	
	}
	
	public ArgosDataManager getArgosDataManager() {
		return argosDataManager;
	}

	public void setArgosDataManager(ArgosDataManager argosDataManager) {
		this.argosDataManager = argosDataManager;
	}

	public ArgosVisorDataManager getArgosVisorDataManager() {
		return argosVisorDataManager;
	}

	public void setArgosVisorDataManager(ArgosVisorDataManager argosVisorDataManager) {
		this.argosVisorDataManager = argosVisorDataManager;
	}

	
	public void selectArgos(ArgosDTO argos)
	{
		try {
			argos.setPais(argosDataManager.getPais().getCodigo());
			argosDataManager.setArgosVisorList(argosService.visorList(argos));
			if(argos.getTipo()==1)
				argosDataManager.setTipoConsulta("Observatorios");
			else if(argos.getTipo()==2)
				argosDataManager.setTipoConsulta("Veedurías");
			else if(argos.getTipo()==3)
				argosDataManager.setTipoConsulta("Defensores de Audiencia");

		}catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}


	public void selectItem(ArgosVisorDTO item)
	{
		try {
			argosVisorDataManager.setItem(argosService.argosItem(item));
			JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/argosItem.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}

	}
	
}
