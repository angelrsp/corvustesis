package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@SessionScoped
@ManagedBean(name="perfilMenuController")
public class DinamicMenuDataManager implements Serializable{

	private static final long serialVersionUID = 1L;

	private MenuModel menuModel;
	
	public DinamicMenuDataManager() {
		menuModel=new DefaultMenuModel();
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
	
}
