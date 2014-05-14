package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorVieDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.DoctorVisorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "doctorVisorController")
public class DoctorVisorController {
	
	
	@ManagedProperty(value="#{doctorVisorDataManager}")
	private DoctorVisorDataManager doctorVisorDataManager;

	@EJB
	private AteneaService ateneaService;

	public DoctorVisorController() {

	}
	
	
	public DoctorVisorDataManager getDoctorVisorDataManager() {
		return doctorVisorDataManager;
	}

	public void setDoctorVisorDataManager(
			DoctorVisorDataManager doctorVisorDataManager) {
		this.doctorVisorDataManager = doctorVisorDataManager;
	}

	
	
	public void readDoctor(DoctorDTO doctor)
	{
		DoctorVieDTO docVie;
		try {
			docVie=new DoctorVieDTO();
			docVie.setDocCodigo(doctor.getDocCodigo());
			List<DoctorVieDTO> doctorList=ateneaService.readDoctorList(docVie);
			if(doctorList.size()>0)
			{
				doctorVisorDataManager.setDoctor(doctorList.get(0));
				
				JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/public/home/doctorVisor.xhtml");
			}
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
