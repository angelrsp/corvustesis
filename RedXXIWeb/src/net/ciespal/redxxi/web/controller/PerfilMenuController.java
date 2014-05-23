package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.web.datamanager.PerfilMenuDataManager;

@ViewScoped
@ManagedBean(name="perfilMenuController")
public class PerfilMenuController {

	
	@ManagedProperty(value="#{perfilMenuDataManager}")
	private PerfilMenuDataManager perfilMenuDataManager;

	@EJB
	private AdministracionService administracionService;

	
	public PerfilMenuController() {

	}


	public PerfilMenuDataManager getPerfilMenuDataManager() {
		return perfilMenuDataManager;
	}


	public void setPerfilMenuDataManager(PerfilMenuDataManager perfilMenuDataManager) {
		this.perfilMenuDataManager = perfilMenuDataManager;
	}
	
	@PostConstruct
	private void init()
	{
		read();
	}
	
	private void read()
	{
		
	}
}
