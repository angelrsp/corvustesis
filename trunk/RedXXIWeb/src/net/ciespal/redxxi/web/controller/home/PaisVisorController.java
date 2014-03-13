package net.ciespal.redxxi.web.controller.home;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.ReportPublicDataManager;

@ViewScoped
@ManagedBean(name="paisVisorController")
public class PaisVisorController {

	@ManagedProperty(value="#{reportPublicDataManager}")
	private ReportPublicDataManager reportPublicDataManager;
	
	@EJB
	private AteneaService ateneaService;
	
	public PaisVisorController() {
	
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
			reportPublicDataManager.setAteneaList(ateneaService.readAtenea(pais.getCodigo()));
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
