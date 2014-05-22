package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;

@ViewScoped
@ManagedBean(name = "menuDataManager")
public class MenuDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuDTO menu;
	
	private List<MenuDTO> menuList;
	
	private List<MenuDTO> menuListPredecesor;
	
	private int predecesorCode;
	
	public MenuDataManager() {
		menu=new MenuDTO();
		menuList=new ArrayList<MenuDTO>();
		menuListPredecesor=new ArrayList<MenuDTO>();
	}

	public MenuDTO getMenu() {
		return menu;
	}

	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}

	public List<MenuDTO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}

	public List<MenuDTO> getMenuListPredecesor() {
		return menuListPredecesor;
	}

	public void setMenuListPredecesor(List<MenuDTO> menuListPredecesor) {
		this.menuListPredecesor = menuListPredecesor;
	}

	public int getPredecesorCode() {
		return predecesorCode;
	}

	public void setPredecesorCode(int predecesorCode) {
		this.predecesorCode = predecesorCode;
	}
	
}
