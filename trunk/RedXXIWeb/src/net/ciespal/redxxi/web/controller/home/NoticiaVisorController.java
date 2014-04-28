package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.NoticiaVisorDataManager;


@ViewScoped
@ManagedBean(name = "noticiaVisorController")
public class NoticiaVisorController {

	
	@ManagedProperty(value="#{noticiaVisorDataManager}")
	private NoticiaVisorDataManager noticiaVisorDataManager;

	public NoticiaVisorDataManager getNoticiaVisorDataManager() {
		return noticiaVisorDataManager;
	}


	public void setNoticiaVisorDataManager(
			NoticiaVisorDataManager noticiaVisorDataManager) {
		this.noticiaVisorDataManager = noticiaVisorDataManager;
	}


	@EJB
	private AteneaService ateneaService;
	
	
	public void find(NoticiaDTO noticiaDTO)
	{
		try {
			JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/public/home/noticiaVisor.xhtml");
			noticiaVisorDataManager.setNoticiaDTO(ateneaService.readNoticia(noticiaDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
