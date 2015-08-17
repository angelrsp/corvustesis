package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.ComponenteDTO;
import ec.edu.uce.notas.ejb.service.AdministracionService;
import ec.edu.uce.notas.web.datamanager.ComponenteDataManager;


@ViewScoped
@ManagedBean(name = "componenteController")
public class ComponenteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	@ManagedProperty(value="#{componenteDataManager}")
	private ComponenteDataManager componenteDataManager;


	public ComponenteController() {
	
	}
	
	
	public ComponenteDataManager getComponenteDataManager() {
		return componenteDataManager;
	}
	public void setComponenteDataManager(ComponenteDataManager componenteDataManager) {
		this.componenteDataManager = componenteDataManager;
	}
	
	@PostConstruct
	private void init()
	{
		read();	
	}
	
	
	public void save()
	{
		try {
			administracionService.createOrUpdateComponente(componenteDataManager.getComponente());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void read()
	{
		try {
			componenteDataManager.setComponenteList(administracionService.readComponente(new ComponenteDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void edit(ComponenteDTO componente)
	{
		componenteDataManager.setComponente(componente);
	}
	
	public void cancel()
	{
		componenteDataManager.setComponente(new ComponenteDTO());
	}

}
