package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

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
		facultadCount();
		pregradoCount();
		posgradoCount();
		revistaCount();
		eventoCount();
		proyectoCount();
		organizacionCount();
		doctorCount();
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
	
	public void facultadCount()
	{
		try {
			reportPublicDataManager.setFacultadNumber(ateneaService.readCentroByType(3).size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void pregradoCount()
	{
		try {
			reportPublicDataManager.setPregradoNumber(ateneaService.readCarrera(6).size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void posgradoCount()
	{
		try {
			reportPublicDataManager.setPosgradoNumber(ateneaService.readCarrera(7).size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void revistaCount()
	{
		try {
			reportPublicDataManager.setRevistaNumber(ateneaService.readPublicacionByType(34).size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void eventoCount()
	{
		try {
			reportPublicDataManager.setEventoNumber(ateneaService.readEvento().size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void proyectoCount()
	{
		try {
			reportPublicDataManager.setProyectoNumber(ateneaService.readProyectoInvestigacion().size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void organizacionCount()
	{
		try {
			reportPublicDataManager.setOrganizacionNumber(ateneaService.readOrganizacion().size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void doctorCount()
	{
		try {
			reportPublicDataManager.setDoctorNumber(ateneaService.readDoctor().size());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void universidadSelect()
	{
		try {
			reportPublicDataManager.setUniversidadList(ateneaService.readUniversidad());
			JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/pages/home/universidad.xhtml");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void facultadSelect()
	{
		try {
			reportPublicDataManager.setFacultadList(ateneaService.readFacultad());
			JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/pages/home/facultad.xhtml");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void pregradoSelect()
	{
		
	}

	public void posgradoSelect()
	{
		
	}
	
	public void revistaSelect()
	{
		
	}

	public void eventoSelect()
	{
		
	}

	public void proyectoSelect()
	{
		
	}

	public void organizacionSelect()
	{
		
	}

	public void doctorSelect()
	{
		
	}
}
