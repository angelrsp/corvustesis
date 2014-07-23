package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.HistorialNoticiaDataManager;
import net.ciespal.redxxi.web.datamanager.home.NoticiaVisorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "historialNoticiaController")
public class HistorialNoticiaController implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@ManagedProperty(value="#{historialNoticiaDataManager}")
	private HistorialNoticiaDataManager historialNoticiaDataManager;

	@ManagedProperty(value="#{noticiaVisorDataManager}")
	private NoticiaVisorDataManager noticiaVisorDataManager;

	
	@EJB
	private AteneaService ateneaService;

	public HistorialNoticiaController() {

	}	

	public NoticiaVisorDataManager getNoticiaVisorDataManager() {
		return noticiaVisorDataManager;
	}

	public void setNoticiaVisorDataManager(
			NoticiaVisorDataManager noticiaVisorDataManager) {
		this.noticiaVisorDataManager = noticiaVisorDataManager;
	}

	public HistorialNoticiaDataManager getHistorialNoticiaDataManager() {
		return historialNoticiaDataManager;
	}

	public void setHistorialNoticiaDataManager(
			HistorialNoticiaDataManager historialNoticiaDataManager) {
		this.historialNoticiaDataManager = historialNoticiaDataManager;
	}


	@PostConstruct
	private void init()
	{
		readAll();
	}
	
	private void readAll()
	{
		try {
			historialNoticiaDataManager.setNoticiaList(ateneaService.readNoticiaPublic());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void find(NoticiaDTO noticiaDTO)
	{
		try {
			noticiaVisorDataManager.setNoticiaDTO(ateneaService.readNoticia(noticiaDTO));
			JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/public/home/noticiaVisor.xhtml");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}

