package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.PerfilDataManager;

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
			administracionService.perfilCreateOrUpdate(perfilDataManager.getPerfil());
			read();
			cancel();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void read()
	{
		try {
			perfilDataManager.setPerfilList(administracionService.perfilReadAll());
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
