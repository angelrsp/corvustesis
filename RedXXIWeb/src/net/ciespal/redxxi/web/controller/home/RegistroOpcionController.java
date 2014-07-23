package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.RegistroOpcionDataManager;

@ViewScoped
@ManagedBean (name = "registroOpcionController")
public class RegistroOpcionController implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{registroOpcionDataManager}")
	private RegistroOpcionDataManager registroOpcionDataManager;

	
	public RegistroOpcionController() {
	
	}
	
	public RegistroOpcionDataManager getRegistroOpcionDataManager() {
		return registroOpcionDataManager;
	}

	public void setRegistroOpcionDataManager(
			RegistroOpcionDataManager registroOpcionDataManager) {
		this.registroOpcionDataManager = registroOpcionDataManager;
	}

	public void continuar()
	{
		try {
			if(registroOpcionDataManager.getOpcion()==0)
				JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/registroDefensor.xhtml");
			else if(registroOpcionDataManager.getOpcion()==1)
				JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/registroColaborador.xhtml");
			else if(registroOpcionDataManager.getOpcion()==2)
				JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/registroSuscriptor.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
	
}
