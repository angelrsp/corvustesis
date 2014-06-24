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
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
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
		DefaultMenuItem subMenu;
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
				subMenu=new DefaultMenuItem();
				subMenu.setUrl(men.getMenUrl());
				subMenu.setValue(men.getMenNombre());
				menuModel.addElement(subMenu);
			}
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
