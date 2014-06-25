package net.ciespal.redxxi.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name="dinamicMenuController")
public class DinamicMenuController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	private MenuModel menuModel;
	
	
	public DinamicMenuController() {
		menuModel=new DefaultMenuModel();	
	}
	

	public MenuModel getMenuModel() {
		return menuModel;
	}


	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	@PostConstruct
	private void init()
	{
		menuConstruct();		
	}
	
	@SuppressWarnings("unchecked")
	private void menuConstruct()
	{
		UsuarioDTO user;
		DefaultMenuItem menuItem;
		try {
			user=(UsuarioDTO) JsfUtil.getObject("UsuarioDTO");
			List<MenuVieDTO> menuAutorizadoList= administracionService.menuReadAuthorized(user.getSegUsuarioPerfils().get(0).getSegPerfil());
			
			List<MenuVieDTO> menuRoot=(List<MenuVieDTO>)CollectionUtils.select(menuAutorizadoList, new Predicate() {
				@Override
				public boolean evaluate(Object obj) {
					MenuVieDTO m=(MenuVieDTO)obj;
					if(m.getMenPredecesor()!=null)
						return false;
					else
						return true;
				}
			});
			
			for(MenuVieDTO men: menuRoot)
			{
				if(StringUtils.isNotBlank(men.getMenUrl())&&StringUtils.isNotEmpty(men.getMenUrl()))
				{
					menuItem=new DefaultMenuItem();
					menuItem.setUrl(men.getMenUrl());
					menuItem.setValue(men.getMenNombre());
					menuModel.addElement(menuItem);
				}
				else
					menuModel.addElement(getSubMenu(men, menuAutorizadoList));
			}

			menuItem=new DefaultMenuItem();
			menuItem.setValue("Salir");
			menuItem.setIcon("ui-icon-close");
			menuItem.setCommand("#{loginController.logout}");
			menuModel.addElement(menuItem);
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private DefaultSubMenu getSubMenu(MenuVieDTO menu,List<MenuVieDTO> list)
	{
		DefaultSubMenu subMenu=new DefaultSubMenu();
		subMenu.setLabel(menu.getMenNombre());
		DefaultMenuItem menuItem;
		List<MenuVieDTO> listChild=	getChildren(menu, list);
		for(MenuVieDTO m:listChild)
		{
			if(StringUtils.isNotBlank(m.getMenUrl())&&StringUtils.isNotEmpty(m.getMenUrl()))
			{
				menuItem=new DefaultMenuItem();
				menuItem.setUrl(m.getMenUrl());
				menuItem.setValue(m.getMenNombre());
				subMenu.getElements().add(menuItem);
			}
			else
			{
				subMenu.getElements().add(getSubMenu(m, list));
			}
		}
		return subMenu;
	}
	
	@SuppressWarnings("unchecked")
	private List<MenuVieDTO> getChildren(final MenuVieDTO men,List<MenuVieDTO> list)
	{
		return (List<MenuVieDTO>) CollectionUtils.select(list, new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				MenuVieDTO m=(MenuVieDTO)obj;
				if(m.getMenPredecesor()!=null)
				{
					if(m.getMenPredecesor().equals(men.getMenCodigo()))
						return true;
					else
						return false;
				}
				else
					return false;
			}
		});
	}
}

