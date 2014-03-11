package net.ciespal.redxxi.web.controller.home;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.ReportPublicDataManager;

import com.corvustec.commons.util.CorvustecException;


@ViewScoped
@ManagedBean(name="ateneaVisorController")
public class AteneaVisorController{

	@ManagedProperty(value="#{reportPublicDataManager}")
	private ReportPublicDataManager reportPublicDataManager;
	
	@EJB
	private AteneaService ateneaService;
	
	public AteneaVisorController() {
	
	}
	
	public ReportPublicDataManager getReportPublicDataManager() {
		return reportPublicDataManager;
	}


	public void setReportPublicDataManager(
			ReportPublicDataManager reportPublicDataManager) {
		this.reportPublicDataManager = reportPublicDataManager;
	}


	public void selectPais(PaisDTO pais)
	{
		try {
			reportPublicDataManager.setVisor(ateneaService.visor(pais));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void selectAtenea(AteneaDTO atenea)
	{
		try {
			reportPublicDataManager.setVisor(ateneaService.visor(atenea));
		}catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
