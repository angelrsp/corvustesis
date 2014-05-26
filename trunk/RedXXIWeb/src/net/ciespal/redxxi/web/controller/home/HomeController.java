package net.ciespal.redxxi.web.controller.home;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.HomeDataManager;

@ViewScoped
@ManagedBean(name = "homeController")
public class HomeController {

	@ManagedProperty(value="#{homeDataManager}")
	private HomeDataManager homeDataManager;

	@EJB
	private AteneaService ateneaService;

	@EJB
	private EspejoService espejoService;
	
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
		granMaestroRead();
		maestroCiespalRead();
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

	private void granMaestroRead()
	{
		try {
			homeDataManager.setGranMaestroDTO(espejoService.getRandomGranMaesto());
			if(homeDataManager.getGranMaestroDTO().getGmaFoto()!=null)
				homeDataManager.setFotoGranMaestroPath(JsfUtil.saveToDiskUpdload(homeDataManager.getGranMaestroDTO().getGmaFoto(), homeDataManager.getGranMaestroDTO().getGmaFotoNombre()));
			else
				homeDataManager.setFotoGranMaestroPath(null);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void maestroCiespalRead()
	{
		try {
			homeDataManager.setMaestroCiespalDTO(espejoService.getRandomMaestoCiespal());
			if(homeDataManager.getMaestroCiespalDTO().getMciFoto()!=null)
				homeDataManager.setFotoMaestroCiespalPath(JsfUtil.saveToDiskUpdload(homeDataManager.getMaestroCiespalDTO().getMciFoto(), homeDataManager.getMaestroCiespalDTO().getMciFotoNombre()));
			else
				homeDataManager.setFotoMaestroCiespalPath(null);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
}
