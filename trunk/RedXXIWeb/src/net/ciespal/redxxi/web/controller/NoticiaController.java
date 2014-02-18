package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.NoticiaDataManager;

@ViewScoped
@ManagedBean(name = "noticiaController")
public class NoticiaController {

	@EJB
	private AteneaService ateneaService;
	
	@ManagedProperty(value="#{noticiaDataManager}")
	private NoticiaDataManager noticiaDataManager;

	
	@PostConstruct
	private void init()
	{
		readNoticia();
	}

	public NoticiaDataManager getNoticiaDataManager() {
		return noticiaDataManager;
	}

	public void setNoticiaDataManager(NoticiaDataManager noticiaDataManager) {
		this.noticiaDataManager = noticiaDataManager;
	}
	
	
	public void save()
	{
		try {
			ateneaService.createNoticia(noticiaDataManager.getNoticia());
			readNoticia();
			noticiaDataManager.setNoticia(new NoticiaDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readNoticia()
	{
		try {
			noticiaDataManager.setNoticiaList(ateneaService.readNoticia());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
