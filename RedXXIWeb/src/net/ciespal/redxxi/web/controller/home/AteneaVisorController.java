package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.AteneaVisorDataManager;
import net.ciespal.redxxi.web.datamanager.home.ReportPublicDataManager;

import com.corvustec.commons.util.CorvustecException;


@ViewScoped
@ManagedBean(name="ateneaVisorController")
public class AteneaVisorController{

	@ManagedProperty(value="#{reportPublicDataManager}")
	private ReportPublicDataManager reportPublicDataManager;

	@ManagedProperty(value="#{ateneaVisorDataManager}")
	private AteneaVisorDataManager ateneaVisorDataManager;
	
	@EJB
	private AteneaService ateneaService;
	
	public AteneaVisorController() {
	
	}
	
	public AteneaVisorDataManager getAteneaVisorDataManager() {
		return ateneaVisorDataManager;
	}

	public void setAteneaVisorDataManager(
			AteneaVisorDataManager ateneaVisorDataManager) {
		this.ateneaVisorDataManager = ateneaVisorDataManager;
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
//		try {
//			//reportPublicDataManager.setVisor(ateneaService.visor(pais));
//		} catch (CorvustecException e) {
//			JsfUtil.addErrorMessage(e.toString());
//		}
	}
	
	
	public void selectAtenea(AteneaDTO atenea)
	{
		try {
			atenea.setPais(reportPublicDataManager.getPais().getCodigo());
			//reportPublicDataManager.setVisor(ateneaService.visor(atenea));
			reportPublicDataManager.setAteneaVisorList(ateneaService.visorList(atenea));
			//reportPublicDataManager.setPaisList(ateneaService.readPais(atenea.getTipo()));
			
			if(atenea.getTipo()==2)
				reportPublicDataManager.setTipoConsulta("Universidades");
			else if(atenea.getTipo()==6)
				reportPublicDataManager.setTipoConsulta("Carreras de Pregrado");
			else if(atenea.getTipo()==7)
				reportPublicDataManager.setTipoConsulta("Carreras de Posgrado");
			else if(atenea.getTipo()==103)
				reportPublicDataManager.setTipoConsulta("Organizaciones Científicas");
			else if(atenea.getTipo()==104)
				reportPublicDataManager.setTipoConsulta("Doctores en Ciencias");
			else if(atenea.getTipo()==105)
				reportPublicDataManager.setTipoConsulta("Articulos, Monografías, Tesis, Libros");
			
		}catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void selectItem(AteneaVisorDTO atenea)
	{
		try {
			ateneaVisorDataManager.setItem(ateneaService.ateneaItem(atenea));				 
			JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/ateneaItem.xhtml");
		}catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
