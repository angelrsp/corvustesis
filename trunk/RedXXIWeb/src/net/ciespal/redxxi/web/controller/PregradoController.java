package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.CarreraDataManager;
import net.ciespal.redxxi.web.datamanager.ContactoDataManager;
import net.ciespal.redxxi.web.datamanager.EventoDataManager;
import net.ciespal.redxxi.web.datamanager.ProyectoDataManager;
import net.ciespal.redxxi.web.datamanager.PublicacionDataManager;
import net.ciespal.redxxi.web.datamanager.UniversidadDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "pregradoController")
public class PregradoController extends SelectItemController{

	@EJB
	private AteneaService ateneaService;
			
	@ManagedProperty(value="#{universidadDataManager}")
	private UniversidadDataManager universidadDataManager;

	@ManagedProperty(value="#{carreraDataManager}")
	private CarreraDataManager carreraDataManager;

	@ManagedProperty(value="#{contactoDataManager}")
	private ContactoDataManager contactoDataManager;

	@ManagedProperty(value="#{proyectoDataManager}")
	private ProyectoDataManager proyectoDataManager;

	@ManagedProperty(value="#{publicacionDataManager}")
	private PublicacionDataManager publicacionDataManager;

	@ManagedProperty(value="#{eventoDataManager}")
	private EventoDataManager eventoDataManager;

	
	public PregradoController() {
		
	}
	
	@PostConstruct
	private void init()
	{
		obtenerUniversidad();
	}
	
	public UniversidadDataManager getUniversidadDataManager() {
		return universidadDataManager;
	}

	public void setUniversidadDataManager(UniversidadDataManager universidadDataManager) {
		this.universidadDataManager = universidadDataManager;
	}

	public void setCarreraDataManager(CarreraDataManager carreraDataManager) {
		this.carreraDataManager = carreraDataManager;
	}

	public void setContactoDataManager(ContactoDataManager contactoDataManager) {
		this.contactoDataManager = contactoDataManager;
	}

	public void setProyectoDataManager(ProyectoDataManager proyectoDataManager) {
		this.proyectoDataManager = proyectoDataManager;
	}

	public void setPublicacionDataManager(
			PublicacionDataManager publicacionDataManager) {
		this.publicacionDataManager = publicacionDataManager;
	}

	public void setEventoDataManager(EventoDataManager eventoDataManager) {
		this.eventoDataManager = eventoDataManager;
	}

	public void obtenerUniversidad()
	{
		try {
			universidadDataManager.setUniversidadList(ateneaService.obtenerCentroPadre());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void obtenerFacultad()
	{
		try {
			CentroDTO centro=new CentroDTO();
			centro.setCenCodigo(universidadDataManager.getUniversidadCode());
			universidadDataManager.setFacultadList(ateneaService.obtenerCentroHijo(centro));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
	
	public void obtenerEscuela()
	{
		try {
			CentroDTO centro=new CentroDTO();
			centro.setCenCodigo(universidadDataManager.getFacultadCode());
			universidadDataManager.setEscuelaList(ateneaService.obtenerCentroHijo(centro));
			carreraDataManager.setCarreraList(ateneaService.readCarrera(centro));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
	
	public void guardar()
	{
		CentroDTO centro;
		EntidadDTO entidad;
		ModalidadDTO mod;
		try {
			carreraDataManager.getCarrera().setCarCodigo(null);
			carreraDataManager.getCarrera().setCarTipo(6);
			for(Object obj:carreraDataManager.getModalidadSelect()){
				mod=new ModalidadDTO();
				mod.setModModalidad(Integer.valueOf(obj.toString()));
				carreraDataManager.getCarrera().addAteModalidad(mod);
			}
			
			centro=new CentroDTO();
			entidad=new EntidadDTO();
			if(universidadDataManager.getEscuelaCode()!=0)
				centro.setCenCodigo(universidadDataManager.getEscuelaCode());
			else if(universidadDataManager.getFacultadCode()!=0)
				centro.setCenCodigo(universidadDataManager.getFacultadCode());
			else{
				JsfUtil.addErrorMessage("Problemas para asignar centro de estudios");
				return;
			}
			carreraDataManager.getCarrera().setAteCentro(centro);
			
			entidad.setAteCarrera(carreraDataManager.getCarrera());
			carreraDataManager.setEntidad(ateneaService.createEntidad(entidad));
			carreraDataManager.setCarreraList(ateneaService.readCarrera(centro));
			entidad.setAteCarrera(carreraDataManager.getEntidad().getAteCarrera());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void selectCarrera(CarreraDTO car)
	{
		carreraDataManager.setCarreraSelect(car);
		carreraDataManager.setEntidad(carreraDataManager.getCarreraSelect().getAteEntidads().get(0));
		buscarContactos();
	}
	
	
	public void buscarContactos()
	{
		try {
			contactoDataManager.setContactoList(ateneaService.readContacto(carreraDataManager.getEntidad()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void crearContacto()
	{
		try {
			if(carreraDataManager.getEntidad().getEntCodigo()==null||carreraDataManager.getEntidad().getEntCodigo()==0){
				JsfUtil.addErrorMessage("Debe guardar ");
				return;
			}
			contactoDataManager.getContacto().setAteEntidad(carreraDataManager.getEntidad());
			contactoDataManager.getContacto().setConTipo(Integer.valueOf(contactoDataManager.getTipoContacto().toString()));
			ateneaService.createContacto(contactoDataManager.getContacto());
			contactoDataManager.setContactoList(ateneaService.readContacto(carreraDataManager.getEntidad()));
			contactoDataManager.setContacto(new ContactoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void crearMension()
	{
		try {
			carreraDataManager.getMencion().setAteCarrera(carreraDataManager.getEntidad().getAteCarrera());
			ateneaService.createMencion(carreraDataManager.getMencion());
			carreraDataManager.setMencionList(ateneaService.readMencion(carreraDataManager.getEntidad().getAteCarrera()));
			carreraDataManager.setMencion(new MencionDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void createProyecto()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			ent.setAteProyectoInvestigacion(proyectoDataManager.getProyecto());
			ent=ateneaService.createEntidad(ent);
			ent.setAteCarrera(carreraDataManager.getCarrera());
			ateneaService.updateEntidad(ent);
			proyectoDataManager.setProyectoList(ateneaService.readProyectoInvestigacion(ent.getAteCarrera()));
			proyectoDataManager.setProyecto(new ProyectoInvestigacionDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void createPublicacion()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			ent.setAtePublicacion(publicacionDataManager.getPublicacion());
			ent=ateneaService.createEntidad(ent);
			ent.setAteCarrera(carreraDataManager.getCarrera());
			ateneaService.updateEntidad(ent);
			publicacionDataManager.setPublicacionList(ateneaService.readPublicacion(ent.getAteCarrera()));
			publicacionDataManager.setPublicacion(new PublicacionDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void createEvento()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			ent.setAteEvento(eventoDataManager.getEvento());
			ent=ateneaService.createEntidad(ent);
			ent.setAteCarrera(carreraDataManager.getCarrera());
			ateneaService.updateEntidad(ent);
			eventoDataManager.setEventoList(ateneaService.readEvento(ent.getAteCarrera()));
			eventoDataManager.setEvento(new EventoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
