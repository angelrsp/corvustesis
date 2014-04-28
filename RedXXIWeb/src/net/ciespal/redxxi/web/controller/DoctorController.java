package net.ciespal.redxxi.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ObraDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ContactoDataManager;
import net.ciespal.redxxi.web.datamanager.DoctorDataManager;

import org.primefaces.event.FileUploadEvent;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "doctorController")
public class DoctorController extends SelectItemController{

	@EJB
	private AteneaService ateneaService;
	
	@EJB
	private AdministracionService administracionService;
	
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
		if(doctor.getDocFotoByte()!=null)
			doctorDataManager.getDoctor().setDocFotoPath(JsfUtil.saveToDiskUpdload(doctor.getDocFotoByte(), doctor.getDocFotoNombre()));
		if(doctor.getDocArchivoTesis()!=null)
			doctorDataManager.getDoctor().setDocArchivoTesisPath(JsfUtil.saveToDiskUpdload(doctor.getDocArchivoTesis(), doctor.getDocArchivoTesisNombre()));
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
		readObra();
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
	
	public void handleFileUpload(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		doctorDataManager.getDoctor().setDocFotoByte(event.getFile().getContents());
		doctorDataManager.getDoctor().setDocFotoNombre(event.getFile().getFileName());
		doctorDataManager.getDoctor().setDocFotoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}

	public void handleFileUploadTesis(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		doctorDataManager.getDoctor().setDocArchivoTesis(event.getFile().getContents());
		doctorDataManager.getDoctor().setDocArchivoTesisNombre(event.getFile().getFileName());
		doctorDataManager.getDoctor().setDocArchivoTesisPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}

	public void handleFileUploadArchivo(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		doctorDataManager.getObra().setObrArchivo(event.getFile().getContents());
		doctorDataManager.getObra().setObrArchivoNombre(event.getFile().getFileName());
		doctorDataManager.getObra().setObrArchivoPath(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}

	public void createObra()
	{
		try {
			doctorDataManager.getObra().setObrPais(Integer.valueOf(getPais().toString()));
			doctorDataManager.getObra().setObrProvincia(Integer.valueOf(getProvincia().toString()));
			doctorDataManager.getObra().setObrCiudad(Integer.valueOf(getCiudad().toString()));
			doctorDataManager.getObra().setObrCampoConocimiento(Integer.valueOf(getSubCampoConocimiento().toString()));
			doctorDataManager.getObra().setObrTipo(Integer.valueOf(doctorDataManager.getTipoPublicacion().toString()));
			
			EntidadDTO ent=ateneaService.readEntidad(ateneaService.createOrUpdateObra(doctorDataManager.getObra()));
			ent.setAteDoctor(doctorDataManager.getDoctor());
			ateneaService.updateEntidad(ent);
			readObra();
			cancelObra();
			JsfUtil.addInfoMessage("Guardado Exitosamente.");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editObra(ObraDTO obra)
	{
		doctorDataManager.setObra(obra);
		
		CatalogoDTO campoConocimiento=new CatalogoDTO();
		doctorDataManager.setTipoPublicacion(obra.getObrTipo());
		try {
			campoConocimiento=administracionService.getCatalogo(obra.getObrCampoConocimiento()).getAteCatalogo();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		setCampoConocimiento(campoConocimiento.getCatCodigo());
		setSubCampoConocimiento(obra.getObrCampoConocimiento());
	}
	
	public void cancelObra()
	{
		doctorDataManager.setObra(new ObraDTO());
	}
	
	public void deleteObra(ObraDTO obra)
	{
		try {
			ateneaService.deleteObra(obra);
			readObra();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readObra()
	{
		try {
			doctorDataManager.setObraList(ateneaService.readObra(doctorDataManager.getDoctor()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void deleteDoctor(DoctorDTO doc)
	{
		try {
			ateneaService.deleteDoctor(doc);
			readDoctor();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}