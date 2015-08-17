package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.MenuViewDTO;
import ec.edu.uce.notas.ejb.service.AdministracionService;

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
			List<MenuViewDTO> menuAutorizadoList= administracionService.menuReadAuthorized(user.getSegUsuarioPerfils().get(0).getSegPerfil());
			
			List<MenuViewDTO> menuRoot=(List<MenuViewDTO>)CollectionUtils.select(menuAutorizadoList, new Predicate() {
				@Override
				public boolean evaluate(Object obj) {
					MenuViewDTO m=(MenuViewDTO)obj;
					if(m.getMenPredecesor()!=null)
						return false;
					else
						return true;
				}
			});
			
			for(MenuViewDTO men: menuRoot)
			{
				if(StringUtils.isNotBlank(men.getMenUrl())&&StringUtils.isNotEmpty(men.getMenUrl()))
				{
					menuItem=new DefaultMenuItem();
					menuItem.setUrl(men.getMenUrl());
					menuItem.setValue(men.getMenDescripcion());
					if(StringUtils.isNotBlank(men.getMenIcono())&&StringUtils.isNotEmpty(men.getMenIcono()))
						menuItem.setIcon(men.getMenIcono());
					
					menuModel.addElement(menuItem);
				}
				else
					menuModel.addElement(getSubMenu(men, menuAutorizadoList));
			}

//			menuItem=new DefaultMenuItem();
//			menuItem.setValue("Salir");
//			menuItem.setIcon("ui-icon-close");
//			menuItem.setCommand("#{loginController.logout}");
//			menuModel.addElement(menuItem);
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private DefaultSubMenu getSubMenu(MenuViewDTO menu,List<MenuViewDTO> list)
	{
		DefaultSubMenu subMenu=new DefaultSubMenu();
		subMenu.setLabel(menu.getMenDescripcion());
		DefaultMenuItem menuItem;
		List<MenuViewDTO> listChild=	getChildren(menu, list);
		for(MenuViewDTO m:listChild)
		{
			if(StringUtils.isNotBlank(m.getMenUrl())&&StringUtils.isNotEmpty(m.getMenUrl()))
			{
				menuItem=new DefaultMenuItem();
				menuItem.setUrl(m.getMenUrl());
				menuItem.setValue(m.getMenDescripcion());
				if(StringUtils.isNotBlank(m.getMenIcono())&&StringUtils.isNotEmpty(m.getMenIcono()))
					menuItem.setIcon(m.getMenIcono());
				
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
	private List<MenuViewDTO> getChildren(final MenuViewDTO men,List<MenuViewDTO> list)
	{
		return (List<MenuViewDTO>) CollectionUtils.select(list, new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				MenuViewDTO m=(MenuViewDTO)obj;
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

