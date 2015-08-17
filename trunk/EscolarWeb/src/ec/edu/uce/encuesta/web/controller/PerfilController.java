package ec.edu.uce.encuesta.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.service.AdministracionService;
import ec.edu.uce.notas.web.datamanager.PerfilDataManager;

@ViewScoped
@ManagedBean(name = "perfilController")
public class PerfilController {

	
	@ManagedProperty(value="#{perfilDataManager}")
	private PerfilDataManager perfilDataManager;

	@EJB
	private AdministracionService administracionService;

	
	public PerfilController() {
	
	}
	
	public PerfilDataManager getPerfilDataManager() {
		return perfilDataManager;
	}

	public void setPerfilDataManager(PerfilDataManager perfilDataManager) {
		this.perfilDataManager = perfilDataManager;
	}

	@PostConstruct
	public void init()
	{
		read();	
	}
	
	public void save()
	{
		try {
			administracionService.createOrUpdatePerfil(perfilDataManager.getPerfil());
			read();
			cancel();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void read()
	{
		try {
			perfilDataManager.setPerfilList(administracionService.readPerfil(new PerfilDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void edit(PerfilDTO perfil)
	{
		perfilDataManager.setPerfil(perfil);
	}
	
	public void cancel()
	{
		perfilDataManager.setPerfil(new PerfilDTO());
	}
}
