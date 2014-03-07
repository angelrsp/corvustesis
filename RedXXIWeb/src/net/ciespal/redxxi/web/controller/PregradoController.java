package net.ciespal.redxxi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
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
			carreraDataManager.setCarreraList(ateneaService.readCarrera(centro,6));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
	
	public void escuelaChange()
	{
		try {
			CentroDTO centro=new CentroDTO();
			centro.setCenCodigo(universidadDataManager.getEscuelaCode());
			carreraDataManager.setCarreraList(ateneaService.readCarrera(centro,6));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void guardar()
	{
		CentroDTO centro;
		
		ModalidadDTO mod;
		try {
			carreraDataManager.getCarrera().setCarTipo(6);
			carreraDataManager.getCarrera().setAteModalidads(new ArrayList<ModalidadDTO>());
			for(Object obj:carreraDataManager.getModalidadSelect()){
				mod=new ModalidadDTO();
				mod.setModModalidad(Integer.valueOf(obj.toString()));
				carreraDataManager.getCarrera().addAteModalidad(mod);
			}
			
			centro=new CentroDTO();
			
			if(universidadDataManager.getEscuelaCode()!=0)
				centro.setCenCodigo(universidadDataManager.getEscuelaCode());
			else if(universidadDataManager.getFacultadCode()!=0)
				centro.setCenCodigo(universidadDataManager.getFacultadCode());
			else{
				JsfUtil.addErrorMessage("Problemas para asignar centro de estudios");
				return;
			}
			
			carreraDataManager.getCarrera().setAteCentro(centro);
			
			ateneaService.createOrUpdateCarrera(carreraDataManager.getCarrera());
			
			carreraDataManager.setCarreraList(ateneaService.readCarrera(centro,6));
			
			cancelCarrera();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editCarrera(CarreraDTO car)
	{
		carreraDataManager.setCarrera(car);
		List<Object> modListObj;
		try {
			modListObj=new ArrayList<Object>();
			for(ModalidadDTO mod: ateneaService.readModalidad(car))
				modListObj.add(mod.getModModalidad());
			carreraDataManager.setModalidadSelect(modListObj);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelCarrera()
	{
		carreraDataManager.setCarrera(new CarreraDTO());
		carreraDataManager.setModalidadSelect(new ArrayList<Object>());
	}
	
	public void selectCarrera(CarreraDTO car)
	{
		carreraDataManager.setCarrera(car);
		buscarContactos();
		buscarMension();
		buscarProyecto();
		buscarPublicacion();
		buscarEvento();
	}
	
	
	public void buscarContactos()
	{
		try {
			contactoDataManager.setContactoList(ateneaService.readContacto(carreraDataManager.getCarrera()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void crearContacto()
	{
		try {
			if(carreraDataManager.getCarrera().getCarCodigo()==null || carreraDataManager.getCarrera().getCarCodigo()==0){
				JsfUtil.addErrorMessage("Debe guardar ");
				return;
			}
			contactoDataManager.getContacto().setAteEntidad(carreraDataManager.getCarrera().getAteEntidads().get(0));
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
	
	public void crearMension()
	{
		try {
			carreraDataManager.getMencion().setAteCarrera(carreraDataManager.getCarrera());
			ateneaService.createOrUpdateMencion(carreraDataManager.getMencion());
			buscarMension();
			carreraDataManager.setMencion(new MencionDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void buscarMension()
	{
		try {
			carreraDataManager.setMencionList(ateneaService.readMencion(carreraDataManager.getCarrera()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editMencion(MencionDTO men)
	{
		carreraDataManager.setMencion(men);
	}
	
	public void deleteMencion(MencionDTO men)
	{
		try {
			ateneaService.deleteMencion(men);
			buscarMension();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void createProyecto()
	{
		EntidadDTO ent;
		try {
			CentroDTO centro=ateneaService.readCentro(universidadDataManager.getUniversidadCode());
			
			proyectoDataManager.getProyecto().setPinCiudad(Integer.valueOf(centro.getCenCiudad().toString()));
			proyectoDataManager.getProyecto().setPinProvincia(Integer.valueOf(centro.getCenProvincia().toString()));
			proyectoDataManager.getProyecto().setPinPais(Integer.valueOf(centro.getCenPais().toString()));
			
			ent=ateneaService.createOrUpdateProyectoInvestigacion(proyectoDataManager.getProyecto()).getAteEntidads().get(0);
			ent.setAteCarrera(carreraDataManager.getCarrera());
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
			proyectoDataManager.setProyectoList(ateneaService.readProyectoInvestigacion(carreraDataManager.getCarrera()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void createPublicacion()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			publicacionDataManager.getPublicacion().setPubTipo(34);
			
			CentroDTO centro=ateneaService.readCentro(universidadDataManager.getUniversidadCode());
			
			publicacionDataManager.getPublicacion().setPubCiudad(Integer.valueOf(centro.getCenCiudad().toString()));
			publicacionDataManager.getPublicacion().setPubProvincia(Integer.valueOf(centro.getCenProvincia().toString()));
			publicacionDataManager.getPublicacion().setPubPais(Integer.valueOf(centro.getCenPais().toString()));

			ent=ateneaService.createOrUpdatePublicacion(publicacionDataManager.getPublicacion()).getAteEntidads().get(0);
			ent.setAteCarrera(carreraDataManager.getCarrera());
			ateneaService.updateEntidad(ent);
			buscarPublicacion();
			publicacionDataManager.setPublicacion(new PublicacionDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void editPublicacion(PublicacionDTO pub)
	{
		publicacionDataManager.setPublicacion(pub);
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
			publicacionDataManager.setPublicacionList(ateneaService.readPublicacion(carreraDataManager.getCarrera()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void createEvento()
	{
		EntidadDTO ent;
		try {
			ent=new EntidadDTO();
			
			CentroDTO centro=ateneaService.readCentro(universidadDataManager.getUniversidadCode());
			
			eventoDataManager.getEvento().setEveCiudad(Integer.parseInt(centro.getCenCiudad().toString()));
			eventoDataManager.getEvento().setEveProvincia(Integer.parseInt(centro.getCenProvincia().toString()));
			eventoDataManager.getEvento().setEvePais(Integer.parseInt(centro.getCenPais().toString()));
			
			ent= ateneaService.createOrUpdateEvento(eventoDataManager.getEvento()).getAteEntidads().get(0);
			ent.setAteCarrera(carreraDataManager.getCarrera());
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
			eventoDataManager.setEventoList(ateneaService.readEvento(carreraDataManager.getCarrera()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void resetCarrera()
	{
		carreraDataManager.setCarrera(new CarreraDTO());
	}

}
