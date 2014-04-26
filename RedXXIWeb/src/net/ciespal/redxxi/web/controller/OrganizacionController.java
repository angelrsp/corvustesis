package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.ContactoDataManager;
import net.ciespal.redxxi.web.datamanager.EventoDataManager;
import net.ciespal.redxxi.web.datamanager.OrganizacionDataManager;
import net.ciespal.redxxi.web.datamanager.ProyectoDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "organizacionController")
public class OrganizacionController extends SelectItemController{

	
	@EJB
	private AteneaService ateneaService;
	
	@ManagedProperty(value="#{organizacionDataManager}")
	private OrganizacionDataManager organizacionDataManager;
	
	@ManagedProperty(value="#{contactoDataManager}")
	private ContactoDataManager contactoDataManager;

	@ManagedProperty(value="#{eventoDataManager}")
	private EventoDataManager eventoDataManager;

	@ManagedProperty(value="#{proyectoDataManager}")
	private ProyectoDataManager proyectoDataManager;

	
	public OrganizacionController() {
	}

	public void setOrganizacionDataManager(OrganizacionDataManager organizacionDataManager) {
		this.organizacionDataManager = organizacionDataManager;
	}
	
	public void setContactoDataManager(ContactoDataManager contactoDataManager) {
		this.contactoDataManager = contactoDataManager;
	}
	
	public void setEventoDataManager(EventoDataManager eventoDataManager) {
		this.eventoDataManager = eventoDataManager;
	}

	public void setProyectoDataManager(ProyectoDataManager proyectoDataManager) {
		this.proyectoDataManager = proyectoDataManager;
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
		readOrganizacion();
	}
	
	public void save()
	{
		try {
			organizacionDataManager.getOrganizacion().setOrgCiudad(Integer.valueOf(getCiudad().toString()));
			organizacionDataManager.getOrganizacion().setOrgProvincia(Integer.valueOf(getProvincia().toString()));
			organizacionDataManager.getOrganizacion().setOrgPais(Integer.valueOf(getPais().toString()));
			ateneaService.createOrUpdateOrganizacion(organizacionDataManager.getOrganizacion());
			organizacionDataManager.setOrganizacion(new OrganizacionDTO());
			readOrganizacion();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void edit(OrganizacionDTO orgnaizacion)
	{
		organizacionDataManager.setOrganizacion(orgnaizacion);
	}
	
	
	public void delete(OrganizacionDTO orgnaizacion)
	{
		try {
			ateneaService.deleteOrganizacion(orgnaizacion);
			readOrganizacion();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void cancel()
	{
		organizacionDataManager.setOrganizacion(new OrganizacionDTO());
	}
	
	private void readOrganizacion()
	{
		try {
			organizacionDataManager.setOrganizacionList(ateneaService.readOrganizacion(getCiudad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void organizacionSelect(OrganizacionDTO org)
	{
		organizacionDataManager.setOrganizacion(org);
		buscarContactos();
		buscarEvento();
		buscarProyecto();
		buscarPublicacion();
	}
	
	
	public void buscarContactos()
	{
		try {
			contactoDataManager.setContactoList(ateneaService.readContacto(organizacionDataManager.getOrganizacion()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void crearContacto()
	{
		try {
			if(organizacionDataManager.getOrganizacion().getOrgCodigo()==null || organizacionDataManager.getOrganizacion().getOrgCodigo()==0){
				JsfUtil.addErrorMessage("Debe guardar ");
				return;
			}
			contactoDataManager.getContacto().setAteEntidad(organizacionDataManager.getOrganizacion().getAteEntidads().get(0));
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

	
	public void createEvento()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			
			eventoDataManager.getEvento().setEveCiudad(Integer.parseInt(getCiudad().toString()));
			eventoDataManager.getEvento().setEveProvincia(Integer.parseInt(getProvincia().toString()));
			eventoDataManager.getEvento().setEvePais(Integer.parseInt(getPais().toString()));
			
			ent= ateneaService.createOrUpdateEvento(eventoDataManager.getEvento()).getAteEntidads().get(0);
			ent.setAteOrganizacion(organizacionDataManager.getOrganizacion());
			ateneaService.updateEntidad(ent);
			buscarEvento();
			eventoDataManager.setEvento(new EventoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editEvento(EventoDTO eve)
	{
		eventoDataManager.setEvento(eve);
	}
	
	public void deleteEvento(EventoDTO eve)
	{
		try {
			ateneaService.deleteEvento(eve);
			buscarEvento();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void buscarEvento()
	{
		try {
			eventoDataManager.setEventoList(ateneaService.readEvento(organizacionDataManager.getOrganizacion()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	
	public void createProyecto()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			
			proyectoDataManager.getProyecto().setPinCiudad(Integer.parseInt(getCiudad().toString()));
			proyectoDataManager.getProyecto().setPinProvincia(Integer.parseInt(getProvincia().toString()));
			proyectoDataManager.getProyecto().setPinPais(Integer.parseInt(getPais().toString()));
			
			ent=ateneaService.createOrUpdateProyectoInvestigacion(proyectoDataManager.getProyecto()).getAteEntidads().get(0);
			
			ent.setAteOrganizacion(organizacionDataManager.getOrganizacion());			
			ateneaService.updateEntidad(ent);
			buscarProyecto();
			proyectoDataManager.setProyecto(new ProyectoInvestigacionDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editProyecto(ProyectoInvestigacionDTO pro)
	{
		proyectoDataManager.setProyecto(pro);
	}
	
	public void deleteProyecto(ProyectoInvestigacionDTO pro)
	{
		try {
			ateneaService.deleteProyectoInvestigacion(pro);
			buscarProyecto();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void buscarProyecto()
	{
		try {
			proyectoDataManager.setProyectoList(ateneaService.readProyectoInvestigacion(organizacionDataManager.getOrganizacion()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	
	public void createPublicacion()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			organizacionDataManager.getPublicacion().setPubTipo(34);
			
			organizacionDataManager.getPublicacion().setPubCiudad(Integer.valueOf(organizacionDataManager.getOrganizacion().getOrgCiudad().toString()));
			organizacionDataManager.getPublicacion().setPubProvincia(Integer.valueOf(organizacionDataManager.getOrganizacion().getOrgProvincia().toString()));
			organizacionDataManager.getPublicacion().setPubPais(Integer.valueOf(organizacionDataManager.getOrganizacion().getOrgPais().toString()));

			ent=ateneaService.createOrUpdatePublicacion(organizacionDataManager.getPublicacion(),true).getAteEntidads().get(0);
			ent.setAteOrganizacion(organizacionDataManager.getOrganizacion());
			ateneaService.updateEntidad(ent);
			buscarPublicacion();
			organizacionDataManager.setPublicacion(new PublicacionDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editPublicacion(PublicacionDTO pub)
	{
		organizacionDataManager.setPublicacion(pub);
	}
	
	public void deletePublicacion(PublicacionDTO pub)
	{
		try {
			ateneaService.deletePublicacion(pub);
			buscarPublicacion();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void buscarPublicacion()
	{
		try {
			organizacionDataManager.setPublicacionList(ateneaService.readPublicacion(organizacionDataManager.getOrganizacion()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
}
