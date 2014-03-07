package net.ciespal.redxxi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.CarreraDataManager;
import net.ciespal.redxxi.web.datamanager.ContactoDataManager;
import net.ciespal.redxxi.web.datamanager.ProyectoDataManager;
import net.ciespal.redxxi.web.datamanager.UniversidadDataManager;

@ViewScoped
@ManagedBean(name = "posgradoController")
public class PosgradoController extends SelectItemController {

	
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
			carreraDataManager.setPosgradoList(ateneaService.readCarrera(centro,7));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
	
	public void escuelaChange()
	{
		try {
			CentroDTO centro=new CentroDTO();
			centro.setCenCodigo(universidadDataManager.getEscuelaCode());
			carreraDataManager.setPosgradoList(ateneaService.readCarrera(centro,7));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	public void guardar()
	{
		CentroDTO centro;
		ModalidadDTO mod;
		try {
			carreraDataManager.getPosgrado().setCarTipo(7);
			carreraDataManager.getPosgrado().setCarTipoPosgrado(Integer.valueOf(carreraDataManager.getTipoPosgrado().toString()));
			
			carreraDataManager.getPosgrado().setAteModalidads(new ArrayList<ModalidadDTO>());
			
			for(Object obj:carreraDataManager.getModalidadSelect()){
				mod=new ModalidadDTO();
				mod.setModModalidad(Integer.valueOf(obj.toString()));
				carreraDataManager.getPosgrado().addAteModalidad(mod);
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
			carreraDataManager.getPosgrado().setAteCentro(centro);
			
			ateneaService.createOrUpdateCarrera(carreraDataManager.getPosgrado());
			
			carreraDataManager.setPosgradoList(ateneaService.readCarrera(centro,7));
			
			cancelCarrera();
			
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelCarrera()
	{
		carreraDataManager.setPosgrado(new CarreraDTO());
		carreraDataManager.setModalidadSelect(new ArrayList<Object>());
		carreraDataManager.setTipoPosgrado(null);
	}
	
	public void editCarrera(CarreraDTO car)
	{
		carreraDataManager.setPosgrado(car);
		List<Object> modListObj;
		try {
			modListObj=new ArrayList<Object>();
			for(ModalidadDTO mod: ateneaService.readModalidad(car))
				modListObj.add(mod.getModModalidad());
			carreraDataManager.setModalidadSelect(modListObj);
			carreraDataManager.setTipoPosgrado(car.getCarTipoPosgrado());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void selectCarrera(CarreraDTO car)
	{
		carreraDataManager.setPosgrado(car);
		buscarContactos();
		buscarMension();
		buscarProyecto();
	}
	
	public void buscarContactos()
	{
		try {
			contactoDataManager.setContactoList(ateneaService.readContacto(carreraDataManager.getPosgrado()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void crearContacto()
	{
		try {
			if(carreraDataManager.getPosgrado().getCarCodigo()==null || carreraDataManager.getPosgrado().getCarCodigo()==0){
				JsfUtil.addErrorMessage("Debe guardar ");
				return;
			}
			contactoDataManager.getContacto().setAteEntidad(carreraDataManager.getPosgrado().getAteEntidads().get(0));
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
			carreraDataManager.getMencion().setAteCarrera(carreraDataManager.getPosgrado());
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
			carreraDataManager.setMencionList(ateneaService.readMencion(carreraDataManager.getPosgrado()));
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
			ent=new EntidadDTO();
			
			CentroDTO centro=ateneaService.readCentro(universidadDataManager.getUniversidadCode());
			
			proyectoDataManager.getProyecto().setPinCiudad(Integer.valueOf(centro.getCenCiudad().toString()));
			proyectoDataManager.getProyecto().setPinProvincia(Integer.valueOf(centro.getCenProvincia().toString()));
			proyectoDataManager.getProyecto().setPinPais(Integer.valueOf(centro.getCenPais().toString()));

			
			ent=ateneaService.createOrUpdateProyectoInvestigacion(proyectoDataManager.getProyecto()).getAteEntidads().get(0);
			ent.setAteCarrera(carreraDataManager.getPosgrado());
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
			proyectoDataManager.setProyectoList(ateneaService.readProyectoInvestigacion(carreraDataManager.getPosgrado()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
