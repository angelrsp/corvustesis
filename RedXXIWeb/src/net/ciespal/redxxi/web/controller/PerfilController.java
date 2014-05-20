package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.web.datamanager.PerfilDataManager;

@ViewScoped
@ManagedBean(name = "perfilController")
public class PerfilController {

	
	@ManagedProperty(value="#{perfilDataManager}")
	private PerfilDataManager perfilDataManager;

	@EJB
	private AdministracionService administracionService;

	
	
}
