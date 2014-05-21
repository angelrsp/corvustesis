package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.web.datamanager.MenuDataManager;

@ViewScoped
@ManagedBean(name = "menuController")
public class MenuController {

	
	@ManagedProperty(value="#{menuDataManager}")
	private MenuDataManager menuDataManager;

	@EJB
	private AdministracionService administracionService;

	
	public MenuController() {
	
	}


	public MenuDataManager getMenuDataManager() {
		return menuDataManager;
	}


	public void setMenuDataManager(MenuDataManager menuDataManager) {
		this.menuDataManager = menuDataManager;
	}
	
	
	public void save()
	{
		read();
	}
	
	private void read()
	{
		
	}
	
	public void readFather()
	{
		
	}
	
	public void cancel()
	{
		
	}
	
	public void edit(MenuDTO menu)
	{
		menuDataManager.setMenu(menu);
	}
	
}
