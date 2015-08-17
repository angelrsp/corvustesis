package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.ComponenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;

@ViewScoped
@ManagedBean(name="componenteMenuDataManager")
public class ComponenteMenuDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponenteMenuDTO componenteMenu;
	
	private List<ComponenteMenuDTO> componenteMenuList;
	
	private int menuCode;
	private int componenteCode;
	
	private List<ComponenteDTO> componenteList;
	private List<MenuDTO> menuList;
	
	public ComponenteMenuDataManager() {
		componenteMenu=new ComponenteMenuDTO();
		componenteMenuList=new ArrayList<ComponenteMenuDTO>();
		
		componenteList=new ArrayList<ComponenteDTO>();
		menuList=new ArrayList<MenuDTO>();
	}

	public ComponenteMenuDTO getComponenteMenu() {
		return componenteMenu;
	}

	public void setComponenteMenu(ComponenteMenuDTO componenteMenu) {
		this.componenteMenu = componenteMenu;
	}

	public List<ComponenteMenuDTO> getComponenteMenuList() {
		return componenteMenuList;
	}

	public void setComponenteMenuList(List<ComponenteMenuDTO> componenteMenuList) {
		this.componenteMenuList = componenteMenuList;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public int getComponenteCode() {
		return componenteCode;
	}

	public void setComponenteCode(int componenteCode) {
		this.componenteCode = componenteCode;
	}

	public List<ComponenteDTO> getComponenteList() {
		return componenteList;
	}

	public void setComponenteList(List<ComponenteDTO> componenteList) {
		this.componenteList = componenteList;
	}

	public List<MenuDTO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}

	
}
