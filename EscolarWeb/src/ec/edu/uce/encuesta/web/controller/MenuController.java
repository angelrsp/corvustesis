package ec.edu.uce.encuesta.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;
import ec.edu.uce.notas.ejb.service.AdministracionService;
import ec.edu.uce.notas.web.datamanager.MenuDataManager;

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
			administracionService.createOrUpdateMenu(menuDataManager.getMenu());
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
			menuDataManager.setMenuList(administracionService.readMenu(new MenuDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	private void predecesorRead()
	{
		try {
			menuDataManager.setMenuListPredecesor(administracionService.readMenu(new MenuDTO()));
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
