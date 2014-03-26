package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.RedDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name="redController")
public class RedController {

	@EJB
	private ArgosService argosService;
	
	@ManagedProperty(value="#{redDataManager}")
	private RedDataManager redDataManager;

	public RedController() {

	}

	@PostConstruct
	private void init()
	{
		read();
	}
	
	public RedDataManager getRedDataManager() {
		return redDataManager;
	}

	public void setRedDataManager(RedDataManager redDataManager) {
		this.redDataManager = redDataManager;
	}
	
	public void save()
	{
		try {
			argosService.createOrUpdateRed(redDataManager.getRed());
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void cancel()
	{
		redDataManager.setRed(new RedDTO());
	}
	
	public void edit(RedDTO red)
	{
		redDataManager.setRed(red);
	}

	public void delete(RedDTO red)
	{
		
	}

	public void ciudadChange()
	{
		read();
	}
	
	private void read()
	{
		try {
			redDataManager.setRedList(argosService.readRed());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
