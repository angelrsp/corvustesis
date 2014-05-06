package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
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
		}catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void selectItem(AteneaVisorDTO atenea)
	{
		try {
			if(atenea.getTipo()==2||atenea.getTipo()==3)
			{
				 ateneaVisorDataManager.setFacultadList(ateneaService.readUniversidadComplete(atenea.getCodigo()).get(0));
				 
				 CentroDTO centro=new CentroDTO();
				 centro.setCenCodigo(atenea.getCodigo());
				 if(ateneaService.obtenerCentroHijo(centro).size()==0)
					 ateneaVisorDataManager.setPregradoList(ateneaService.readCarrera(centro, 6));
				 else
				 {
					 List<CentroDTO> escuelaList=ateneaService.obtenerCentroHijo(centro);
					 List<CarreraDTO> pregradoList=new ArrayList<CarreraDTO>();
					 for(CentroDTO esc:escuelaList)
					 {
						 	for(CarreraDTO pre:ateneaService.readCarrera(esc, 6))
						 	{
						 		pregradoList.add(pre);
						 	}
					 }
					 ateneaVisorDataManager.setPregradoList(pregradoList);
				 }
				 JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/public/home/universidad.xhtml");
			}
		}catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
