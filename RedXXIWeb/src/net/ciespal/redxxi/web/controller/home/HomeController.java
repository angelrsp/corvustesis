package net.ciespal.redxxi.web.controller.home;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.HomeDataManager;

@ViewScoped
@ManagedBean(name = "homeController")
public class HomeController {

	@ManagedProperty(value="#{homeDataManager}")
	private HomeDataManager homeDataManager;

	@EJB
	private AteneaService ateneaService;
	
	public HomeDataManager getHomeDataManager() {
		return homeDataManager;
	}

	public void setHomeDataManager(HomeDataManager homeDataManager) {
		this.homeDataManager = homeDataManager;
	}

	public HomeController() {
		
	}
	
	@PostConstruct
	private void init()
	{
		readDoctor();
	}
	
	private void readDoctor()
	{
		try {
			homeDataManager.setDoctorDTO(ateneaService.getRandomDoctor());
			if(homeDataManager.getDoctorDTO().getDocFotoByte()!=null)
				homeDataManager.setFotoPhdPath(JsfUtil.saveToDiskUpdload(homeDataManager.getDoctorDTO().getDocFotoByte(), homeDataManager.getDoctorDTO().getDocFotoNombre()));
			else
				homeDataManager.setFotoPhdPath(null);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
}
