package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.SecurityService;
import ec.edu.uce.besg.web.datamanager.LoginCandidatoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "loginCandidatoController")
public class LoginCandidatoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private SecurityService securityService;
	
	@ManagedProperty(value="#{loginCandidatoDataManager}")
	private LoginCandidatoDataManager loginCandidatoDataManager;

	public LoginCandidatoController() {
	
	}
	
	public LoginCandidatoDataManager getLoginCandidatoDataManager() {
		return loginCandidatoDataManager;
	}

	public void setLoginCandidatoDataManager(
			LoginCandidatoDataManager loginCandidatoDataManager) {
		this.loginCandidatoDataManager = loginCandidatoDataManager;
	}

	public void authenticate()
	{
		UsuarioDTO usuarioDTO=null;
		try {
			usuarioDTO=securityService.authenticateCandidato(loginCandidatoDataManager.getUsuarioDTO());
			if(usuarioDTO!=null)
			{
				JsfUtil.putObject("UsuarioDTO", usuarioDTO);
				JsfUtil.redirect("pages/candidato/inicio.xhtml");
			}
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
}
