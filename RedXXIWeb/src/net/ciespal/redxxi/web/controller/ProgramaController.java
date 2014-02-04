package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.web.datamanager.UniversidadDataManager;

@ViewScoped
@ManagedBean(name = "programaController")
public class ProgramaController extends SelectItemController{

	@EJB
	private AteneaService ateneaService;
		
	
	@ManagedProperty(value="universidadDataManager")
	private UniversidadDataManager universidadDataManager;
	
	public ProgramaController() {
		
	}
	
	@PostConstruct
	private void init()
	{
	}
	
	public void agregarUniversidad()
	{
		
	}


}
