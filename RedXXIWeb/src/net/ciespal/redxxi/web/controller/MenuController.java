package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
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
	
	@PostConstruct
	private void init()
	{
		read();
		predecesorRead();
	}
	
	public void save()
	{
		try {
			if(menuDataManager.getPredecesorCode()!=0)
			{
				MenuDTO men=new MenuDTO();
				men.setMenCodigo(menuDataManager.getPredecesorCode());
				menuDataManager.getMenu().setSegMenu(men);
			}
			administracionService.menuCreateOrUpdate(menuDataManager.getMenu());
			read();
			predecesorRead();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void read()
	{
		try {
			menuDataManager.setMenuList(administracionService.menuReadAll());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	private void predecesorRead()
	{
		try {
			menuDataManager.setMenuListPredecesor(administracionService.menuReadAll());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancel()
	{
		menuDataManager.setMenu(new MenuDTO());
		menuDataManager.setPredecesorCode(0);
	}
	
	public void edit(MenuDTO menu)
	{
		menuDataManager.setMenu(menu);
		if(menu.getSegMenu()!=null)
			menuDataManager.setPredecesorCode(menu.getSegMenu().getMenCodigo());
	}
	
}
