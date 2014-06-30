package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalVieDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.GrandesMaestrosHomeDataManager;
import net.ciespal.redxxi.web.datamanager.home.HomeDataManager;
import net.ciespal.redxxi.web.datamanager.home.MaestroCiespalHomeDataManager;
import net.ciespal.redxxi.web.datamanager.home.NuestroDoctorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "homeController")
public class HomeController implements Serializable{

		
	private static final long serialVersionUID = 1L;
	
	

	@ManagedProperty(value="#{homeDataManager}")
	private HomeDataManager homeDataManager;

	@ManagedProperty(value="#{nuestroDoctorDataManager}")
	private NuestroDoctorDataManager nuestroDoctorDataManager;

	@ManagedProperty(value="#{grandesMaestrosHomeDataManager}")
	private GrandesMaestrosHomeDataManager grandesMaestrosHomeDataManager;
	
	@ManagedProperty(value="#{maestroCiespalHomeDataManager}")
	private MaestroCiespalHomeDataManager maestroCiespalHomeDataManager;
	
	
	@EJB
	private EspejoService espejoService;

	@EJB
	private AteneaService ateneaService;;


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
	
	
	public GrandesMaestrosHomeDataManager getGrandesMaestrosHomeDataManager() {
		return grandesMaestrosHomeDataManager;
	}

	public void setGrandesMaestrosHomeDataManager(
			GrandesMaestrosHomeDataManager grandesMaestrosHomeDataManager) {
		this.grandesMaestrosHomeDataManager = grandesMaestrosHomeDataManager;
	}

	public MaestroCiespalHomeDataManager getMaestroCiespalHomeDataManager() {
		return maestroCiespalHomeDataManager;
	}

	public void setMaestroCiespalHomeDataManager(
			MaestroCiespalHomeDataManager maestroCiespalHomeDataManager) {
		this.maestroCiespalHomeDataManager = maestroCiespalHomeDataManager;
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
			if(homeDataManager.getDoctorDTO().getDocCodigo()!=null)
			{
				doc=new DoctorVieDTO();
				nuestroDoctorDataManager.setItem(ateneaService.readDoctorItem(doc));
				JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/nuestrosDoctores.xhtml");
			}
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

	public void granMaestroReadVie()
	{
		GranMaestroVieDTO g;
		try {
			if(homeDataManager.getGranMaestroDTO().getGmaCodigo()!=null)
			{
				g=new GranMaestroVieDTO();
				g.setGmaCodigo(homeDataManager.getGranMaestroDTO().getGmaCodigo());
				grandesMaestrosHomeDataManager.setItem(espejoService.readMaestroPeriodismoItem(g));				
				JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/grandesMaestrosHome.xhtml");
			}
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
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

	
	public void maestroCiespalReadVie()
	{
		MaestroCiespalVieDTO m;
		try {
			if(homeDataManager.getMaestroCiespalDTO().getMciCodigo()!=null)
			{
				m=new MaestroCiespalVieDTO();
				m.setMciCodigo(homeDataManager.getMaestroCiespalDTO().getMciCodigo());
				maestroCiespalHomeDataManager.setItem(espejoService.readMaestroCiespalItem(m));
								
				JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/maestroCiespalHome.xhtml");
			}
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
}
