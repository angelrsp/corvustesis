package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ComponenteDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "componenteController")
public class ComponenteController {

	
	@ManagedProperty(value="#{componenteDataManager}")
	private ComponenteDataManager componenteDataManager;

	@EJB
	private AdministracionService administracionService;

	public ComponenteController() {
	
	}
	
	
	public ComponenteDataManager getComponenteDataManager() {
		return componenteDataManager;
	}

	public void setComponenteDataManager(ComponenteDataManager componenteDataManager) {
		this.componenteDataManager = componenteDataManager;
	}
	
	@PostConstruct
	private void init()
	{
		read();	
	}
	
	
	public void save()
	{
		try {
			administracionService.componenteCreateOrUpdate(componenteDataManager.getComponente());
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
			componenteDataManager.setComponenteList(administracionService.componenteReadAll());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void edit(ComponenteDTO componente)
	{
		componenteDataManager.setComponente(componente);
	}
	
	public void cancel()
	{
		componenteDataManager.setComponente(new ComponenteDTO());
	}

}
