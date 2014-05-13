package net.ciespal.redxxi.web.controller.home;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.ArgosDataManager;


@ViewScoped
@ManagedBean(name = "argosController")
public class ArgosController {

	
	@EJB
	private ArgosService argosService;

	
	@ManagedProperty(value="#{argosDataManager}")
	private ArgosDataManager argosDataManager;

	public ArgosController() {
	
	}

	@PostConstruct
	private void init()
	{
		readArgos();
	}

	
	public ArgosDataManager getArgosDataManager() {
		return argosDataManager;
	}

	public void setArgosDataManager(ArgosDataManager argosDataManager) {
		this.argosDataManager = argosDataManager;
	}
	
	
	private void readArgos()
	{
		try {
			argosDataManager.setArgosList(argosService.readArgos(null));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
