package ec.edu.uce.indicadores.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import ec.edu.uce.indicadores.commons.dto.util.CredencialesDTO;
import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.LoginService;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;


@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private LoginService loginService;

	private CredencialesDTO credencialesDTO;

	public LoginController() {
	}

	@PostConstruct
	private void init()
	{
		credencialesDTO=new CredencialesDTO();
	}
	
	public CredencialesDTO getCredencialesDTO() {
		return credencialesDTO;
	}

	public void setCredencialesDTO(CredencialesDTO credencialesDTO) {
		this.credencialesDTO = credencialesDTO;
	}

	public void login()
	{
		try {
			UsuarioDTO user = loginService.autenticarUsuario(credencialesDTO);
			if (user != null) {
				JsfUtil.addInfoMessage("bien");
				JsfUtil.putObject("UsuarioDTO",user);
				JsfUtil.redirect("home.jsf");
			} else {
				JsfUtil.addErrorMessage("Datos Tncorrectos");
			}
		} catch (IOException e) {
			JsfUtil.addErrorMessage("mal");
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage("mal");
		}
	}
	
	
	public void logout()
	{
	      try {
			HttpSession session = JsfUtil.getSession();
		      session.invalidate();
			JsfUtil.redirect("/INDICADORESWeb/index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
