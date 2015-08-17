package ec.edu.uce.encuesta.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.ComponenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;
import ec.edu.uce.notas.ejb.service.AdministracionService;
import ec.edu.uce.notas.web.datamanager.ComponenteMenuDataManager;

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
			
			administracionService.createOrUpdateComponenteMenu(componenteMenuDataManager.getComponenteMenu());
			
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
			componenteMenuDataManager.setComponenteMenuList(administracionService.readComponenteMenu(new ComponenteMenuDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readComponente()
	{
		try {
			componenteMenuDataManager.setComponenteList(administracionService.readComponente(new ComponenteDTO()));
			logger.info("readComponente" + componenteMenuDataManager.getComponenteList().size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}				
	}

	private void readMenu()
	{
		try {
			componenteMenuDataManager.setMenuList(administracionService.readMenu(new MenuDTO()));
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
