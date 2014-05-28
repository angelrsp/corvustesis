package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.ArgosDataManager;

import com.corvustec.commons.util.CorvustecException;


@ViewScoped
@ManagedBean(name = "argosController")
public class ArgosController {

	
	@EJB
	private ArgosService argosService;

	
	@ManagedProperty(value="#{argosDataManager}")
	private ArgosDataManager argosDataManager;

	public ArgosController() {
	
	}

	@PostConstruct
	private void init()
	{
		readArgos();
		readPais();
	}

	
	public ArgosDataManager getArgosDataManager() {
		return argosDataManager;
	}

	public void setArgosDataManager(ArgosDataManager argosDataManager) {
		this.argosDataManager = argosDataManager;
	}
	
	
	private void readArgos()
	{
		try {
			argosDataManager.setArgosList(argosService.readArgos(null));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readPais()
	{
		try {
			argosDataManager.setPaisList(argosService.readPais(null));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void selectArgos(ArgosDTO argos)
	{
		try {		
			argosDataManager.setPaisList(argosService.readPais(argos.getTipo()));
			argosDataManager.setArgos(argos);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void selectPais(PaisDTO pais)
	{
		ArgosDTO argos;
		try {
			argosDataManager.setPais(pais);
			argosDataManager.setArgosList(argosService.readArgos(pais.getCodigo()));
			//reportPublicDataManager.setVisor(ateneaService.infoPais(pais));
			if(argosDataManager.getArgos().getTipo()!=0)
				pais.setTipo(argosDataManager.getArgos().getTipo());
			else
				pais.setTipo(1);

			argos=new ArgosDTO();
			argos.setPais(pais.getCodigo());
			argos.setTipo(pais.getTipo());
			
			argosDataManager.setArgosVisorList(argosService.visorList(argos));
			argosDataManager.getArgos().setTipo(0);
			JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/public/home/argosVisor.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}


}
