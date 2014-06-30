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
import net.ciespal.redxxi.web.datamanager.NoticiaPublicDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "noticiaPublicController")
public class NoticiaPublicController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AteneaService ateneaService;
	
	@ManagedProperty(value="#{noticiaPublicDataManager}")
	private NoticiaPublicDataManager noticiaPublicDataManager;

	public NoticiaPublicController() {
	
	}
	
	@PostConstruct
	public void init()
	{
		readNoticiaPublic();
	}
	
	public NoticiaPublicDataManager getNoticiaPublicDataManager() {
		return noticiaPublicDataManager;
	}

	public void setNoticiaPublicDataManager(
			NoticiaPublicDataManager noticiaPublicDataManager) {
		this.noticiaPublicDataManager = noticiaPublicDataManager;
	}

	
	public void readNoticia(NoticiaDTO noticia)
	{
		noticiaPublicDataManager.setNoticia(noticia);
		try {
			JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/public/home/noticia.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readNoticiaPublic()
	{
		try {
			noticiaPublicDataManager.setNoticiaPublicList(ateneaService.readNoticiaPublic(3));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void readArchivo()
	{
		
	}
}
