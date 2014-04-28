package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorListDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.DoctorVisorDataManager;

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
		try {
			List<DoctorListDTO> doctorList=ateneaService.readDoctorList(doctor.getDocCodigo());
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
