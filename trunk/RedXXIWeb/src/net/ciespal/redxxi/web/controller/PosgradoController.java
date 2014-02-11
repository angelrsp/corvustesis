package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.CarreraDataManager;
import net.ciespal.redxxi.web.datamanager.ContactoDataManager;
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
			carreraDataManager.getCarrera().setCarTipo(7);
			carreraDataManager.getCarrera().setCarTipoPosgrado(Integer.valueOf(carreraDataManager.getTipoPosgrado().toString()));
			
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
			entidad.setAteCarrera(carreraDataManager.getEntidad().getAteCarrera());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
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

	
}
