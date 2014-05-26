package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorVieDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.HomeDataManager;
import net.ciespal.redxxi.web.datamanager.home.NuestroDoctorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "homeController")
public class HomeController {

	@ManagedProperty(value="#{homeDataManager}")
	private HomeDataManager homeDataManager;

	@ManagedProperty(value="#{nuestroDoctorDataManager}")
	private NuestroDoctorDataManager nuestroDoctorDataManager;
	
	@EJB
	private AteneaService ateneaService;

	@EJB
	private EspejoService espejoService;
	

	public HomeController() {
		
	}

	public HomeDataManager getHomeDataManager() {
		return homeDataManager;
	}

	public void setHomeDataManager(HomeDataManager homeDataManager) {
		this.homeDataManager = homeDataManager;
	}
	
	public NuestroDoctorDataManager getNuestroDoctorDataManager() {
		return nuestroDoctorDataManager;
	}

	public void setNuestroDoctorDataManager(
			NuestroDoctorDataManager nuestroDoctorDataManager) {
		this.nuestroDoctorDataManager = nuestroDoctorDataManager;
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


	public void readDoctorVie()
	{
		DoctorVieDTO doc;
		try {
			doc=new DoctorVieDTO();
			doc.setDocCodigo(homeDataManager.getDoctorDTO().getDocCodigo());
			nuestroDoctorDataManager.setDoctorVieDTO(ateneaService.doctorVieRead(doc));
			JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/nuestrosDoctores.xhtml");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
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
