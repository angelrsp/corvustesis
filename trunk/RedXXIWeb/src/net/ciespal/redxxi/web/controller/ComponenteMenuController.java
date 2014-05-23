package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ComponenteMenuDataManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name="componenteMenuController")
public class ComponenteMenuController {

	private static final Logger logger = LoggerFactory.getLogger(ComponenteMenuController.class);
	
	@ManagedProperty(value="#{componenteMenuDataManager}")
	private ComponenteMenuDataManager componenteMenuDataManager;

	@EJB
	private AdministracionService administracionService;
	

	public ComponenteMenuController() {
	
	}
	
	public ComponenteMenuDataManager getComponenteMenuDataManager() {
		return componenteMenuDataManager;
	}

	public void setComponenteMenuDataManager(
			ComponenteMenuDataManager componenteMenuDataManager) {
		this.componenteMenuDataManager = componenteMenuDataManager;
	}

	@PostConstruct
	private void init()
	{
		readMenu();
		readComponente();
		read();
	}
	
	public void save()
	{
		ComponenteDTO componente;
		MenuDTO menu;
		try {
			componente=new ComponenteDTO();
			menu=new MenuDTO();
			componente.setComCodigo(componenteMenuDataManager.getComponenteCode());
			menu.setMenCodigo(componenteMenuDataManager.getMenuCode());
			
			componenteMenuDataManager.getComponenteMenu().setSegComponente(componente);
			componenteMenuDataManager.getComponenteMenu().setSegMenu(menu);
			
			administracionService.componenteMenuCreateOrUpdate(componenteMenuDataManager.getComponenteMenu());
			
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void read()
	{
		try {
			componenteMenuDataManager.setComponenteMenuList(administracionService.componenteMenuReadAll());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readComponente()
	{
		try {
			componenteMenuDataManager.setComponenteList(administracionService.componenteReadAll());
			logger.info("readComponente" + componenteMenuDataManager.getComponenteList().size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}				
	}

	private void readMenu()
	{
		try {
			componenteMenuDataManager.setMenuList(administracionService.menuReadAll());
			logger.info("readMenu" + componenteMenuDataManager.getMenuList().size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void edit(ComponenteMenuDTO componente)
	{
		componenteMenuDataManager.setComponenteMenu(componente);
	}
	
	public void cancel()
	{
		componenteMenuDataManager.setComponenteMenu(new ComponenteMenuDTO());
	}
	
}
