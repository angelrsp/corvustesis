package net.ciespal.redxxi.web.controller.home;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ReportPublicDataManager;

@ViewScoped
@ManagedBean(name = "reportPublicController")
public class ReportPublicController {

	
	@EJB
	private AteneaService ateneaService;

	@ManagedProperty(value="#{reportPublicDataManager}")
	private ReportPublicDataManager reportPublicDataManager;
	
	public ReportPublicController() {
		
	}

	@PostConstruct
	private void init()
	{
		universidadCount();
	}
	
	public ReportPublicDataManager getReportPublicDataManager() {
		return reportPublicDataManager;
	}

	public void setReportPublicDataManager(
			ReportPublicDataManager reportPublicDataManager) {
		this.reportPublicDataManager = reportPublicDataManager;
	}
	
	public void universidadCount()
	{
		try {
			reportPublicDataManager.setUniversidadNumber(ateneaService.readCentroByType(2).size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void universidadSelect()
	{
		
	}
	
}
