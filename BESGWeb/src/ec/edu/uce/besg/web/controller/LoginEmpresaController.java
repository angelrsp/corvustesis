package ec.edu.uce.besg.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.service.SecurityService;
import ec.edu.uce.besg.web.datamanager.LoginEmpresaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "loginEmpresaController")
public class LoginEmpresaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private SecurityService securityService;
	
	@ManagedProperty(value="#{loginEmpresaDataManager}")
	private LoginEmpresaDataManager loginEmpresaDataManager;

	public LoginEmpresaController() {
	
	}
	
	public LoginEmpresaDataManager getLoginEmpresaDataManager() {
		return loginEmpresaDataManager;
	}


	public void setLoginEmpresaDataManager(
			LoginEmpresaDataManager loginEmpresaDataManager) {
		this.loginEmpresaDataManager = loginEmpresaDataManager;
	}


	public void intro()
	{
		try {
			 if(securityService.loginEmpresa(loginEmpresaDataManager.getUsuarioDTO()) !=null)
				 JsfUtil.redirect("pages/empresa/inicio.xhtml");	 
			 else
			 {
				 JsfUtil.addErrorMessage("Usuario o contraseña incorrectos");
			 }
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
