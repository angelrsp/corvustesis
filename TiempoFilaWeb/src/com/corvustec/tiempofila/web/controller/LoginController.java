package com.corvustec.tiempofila.web.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.tiempofila.web.datamanager.LoginDataManager;


@ViewScoped
@ManagedBean(name="loginController")
public class LoginController {

	
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
	
}
