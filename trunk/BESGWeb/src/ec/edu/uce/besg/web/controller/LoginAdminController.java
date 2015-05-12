package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.SecurityService;
import ec.edu.uce.besg.web.datamanager.LoginAdminDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "loginAdminController")
public class LoginAdminController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private SecurityService securityService;
	
	@ManagedProperty(value="#{loginAdminDataManager}")
	private LoginAdminDataManager loginAdminDataManager;

	public LoginAdminController() {
	
	}
	
	
	public LoginAdminDataManager getLoginAdminDataManager() {
		return loginAdminDataManager;
	}
	public void setLoginAdminDataManager(LoginAdminDataManager loginAdminDataManager) {
		this.loginAdminDataManager = loginAdminDataManager;
	}


	public void authenticate()
	{
		UsuarioDTO usuarioDTO=null;
		try {
			usuarioDTO=securityService.authenticateUser(loginAdminDataManager.getUsuarioDTO());
			if(usuarioDTO!=null)
			{
				JsfUtil.putObject("UsuarioDTO", usuarioDTO);
				JsfUtil.redirect("pages/system/inicio.xhtml");
			}
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
