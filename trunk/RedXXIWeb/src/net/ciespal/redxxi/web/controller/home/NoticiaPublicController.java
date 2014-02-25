package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.NoticiaPublicDataManager;

@ViewScoped
@ManagedBean(name = "noticiaPublicController")
public class NoticiaPublicController {

	@ManagedProperty(value="#{noticiaPublicDataManager}")
	private NoticiaPublicDataManager noticiaPublicDataManager;

	@PostConstruct
	public void init()
	{
		
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
			JsfUtil.redirect("pages/home/noticia.jsf");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
