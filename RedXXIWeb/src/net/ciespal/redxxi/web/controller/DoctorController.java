package net.ciespal.redxxi.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ContactoDataManager;
import net.ciespal.redxxi.web.datamanager.DoctorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "doctorController")
public class DoctorController extends SelectItemController{

	@EJB
	private AteneaService ateneaService;
	
	@ManagedProperty(value="#{doctorDataManager}")
	private DoctorDataManager doctorDataManager;

	@ManagedProperty(value="#{contactoDataManager}")
	private ContactoDataManager contactoDataManager;
	
	
	public DoctorController() {
	}
	
	public void setDoctorDataManager(DoctorDataManager doctorDataManager) {
		this.doctorDataManager = doctorDataManager;
	}

	public void setContactoDataManager(ContactoDataManager contactoDataManager) {
		this.contactoDataManager = contactoDataManager;
	}

	public void obtenerProvinciaChange() {
		try {
			getCatalogoProvincia();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void obtenerCiudadChange() {
		try {
			getCatalogoCiudad();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void ciudadChange()
	{
		readDoctor();
	}
	
	private void readDoctor()
	{
		try {
			 doctorDataManager.setDoctorList(ateneaService.readDoctor(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void save()
	{
		try {
			doctorDataManager.getDoctor().setDocCiudad(Integer.valueOf(getCiudad().toString()));
			doctorDataManager.getDoctor().setDocProvincia(Integer.valueOf(getProvincia().toString()));
			doctorDataManager.getDoctor().setDocPais(Integer.valueOf(getPais().toString()));
			doctorDataManager.getDoctor().setDocFechaNacimiento(new Timestamp(doctorDataManager.getFechaNacimiento().getTime()));
			doctorDataManager.getDoctor().setDocSexo(Integer.valueOf(doctorDataManager.getSexoSelect().toString()));
			ateneaService.createOrUpdateDoctor(doctorDataManager.getDoctor());
			readDoctor();
			doctorDataManager.setDoctor(new DoctorDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editDoctor(DoctorDTO doctor)
	{
		doctorDataManager.setDoctor(doctor);
		doctorDataManager.setFechaNacimiento(new Date(doctor.getDocFechaNacimiento().getTime()));
		doctorDataManager.setSexoSelect(doctor.getDocSexo());
	}
	
	public void cancelDoctor()
	{
		doctorDataManager.setDoctor(new DoctorDTO());
		doctorDataManager.setFechaNacimiento(new Date());
		doctorDataManager.setSexoSelect(null);		
	}
	
	public void doctorSelect(DoctorDTO doc)
	{
		doctorDataManager.setDoctor(doc);
		buscarContactos();
	}
	
	
	public void buscarContactos()
	{
		try {
			contactoDataManager.setContactoList(ateneaService.readContacto(doctorDataManager.getDoctor()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void crearContacto()
	{
		try {
			if(doctorDataManager.getDoctor().getDocCodigo()==null || doctorDataManager.getDoctor().getDocCodigo()==0){
				JsfUtil.addErrorMessage("Debe guardar ");
				return;
			}
			contactoDataManager.getContacto().setAteEntidad(doctorDataManager.getDoctor().getAteEntidads().get(0));
			contactoDataManager.getContacto().setConTipo(Integer.valueOf(contactoDataManager.getTipoContacto().toString()));
			ateneaService.createOrUpdateContacto(contactoDataManager.getContacto());
			buscarContactos();
			contactoDataManager.setContacto(new ContactoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void editContacto(ContactoListDTO con)
	{
		contactoDataManager.getContacto().setConCodigo(con.getConCodigo());
		contactoDataManager.getContacto().setConTipo(con.getConTipo());
		contactoDataManager.getContacto().setConValor(con.getConValor());
		contactoDataManager.getContacto().setAteEntidad(new EntidadDTO(con.getEntCodigo()));
		contactoDataManager.setTipoContacto(con.getConTipo());
	}
	
	public void deleteContacto(ContactoListDTO con)
	{
		try {
			ateneaService.deleteContacto(new ContactoDTO(con.getConCodigo()));
			buscarContactos();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}