package com.corvustec.tiempofila.web.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;
import com.corvustec.tiempofila.ejb.negocio.AdministracionService;
import com.corvustec.tiempofila.web.datamanager.LoginDataManager;
import com.corvustec.web.commons.util.JsfUtil;


@ViewScoped
@ManagedBean(name="loginController")
public class LoginController {

	@EJB
	private AdministracionService administracionService;
	
	@ManagedProperty(value="#{loginDataManager}")
	private LoginDataManager loginDataManager;

	public LoginController() {
	
	}

	@PostConstruct
	private void init() {

	}

	public LoginDataManager getLoginDataManager() {
		return loginDataManager;
	}

	public void setLoginDataManager(LoginDataManager loginDataManager) {
		this.loginDataManager = loginDataManager;
	}
	
	public void login()
	{
		try {
			if(administracionService.authentication(loginDataManager.getCredencialesDTO()))
				JsfUtil.redirect("/"+JsfUtil.getExternalContext().getContextName()+"/pages/finalToma.xhtml");
			else
				JsfUtil.addErrorMessage("Incorrecto");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
