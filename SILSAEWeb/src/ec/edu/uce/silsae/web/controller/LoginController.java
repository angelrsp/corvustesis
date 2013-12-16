/**
 * 
 */
package ec.edu.uce.silsae.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.LoginService;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsae.web.util.JsfUtil;

/**
 * @author
 * 
 */
@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController implements Serializable {

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
	public void inicializarObjetos() {
		this.credencialesDTO = new CredencialesDTO();
	}

	public void iniciarSesionUsuario() {
		try {
			UsuarioDTO user = loginService.autenticarUsuario(credencialesDTO);
			if (user != null) {
				JsfUtil.addInfoMessage("bien");
				JsfUtil.putObject("UsuarioDTO",user);
				JsfUtil.redirect("dato.jsf");
			} else {
				JsfUtil.addErrorMessage("Datos Tncorrectos");
			}
		} catch (IOException e) {
			JsfUtil.addErrorMessage("mal");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage("mal");
		}
	}
	
	public void iniciarSessionEmpresa()
	{
		try {
			UsuarioDTO user = loginService.autenticarUsuario(credencialesDTO);
			if (user != null) {
				if(user.getBemEmpresas().get(0).getEmpActiva()){
					JsfUtil.addInfoMessage("bien");
					JsfUtil.putObject("UsuarioDTO",user);
					JsfUtil.redirect("dato.jsf");
				}
				else
				{
					JsfUtil.addErrorMessage("Empresa no Autorizada para ingresar.");
				}
			} else {
				JsfUtil.addErrorMessage("Datos Tncorrectos");
			}
		} catch (IOException e) {
			JsfUtil.addErrorMessage("mal");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage("mal");
		}		
	}

	
	public void iniciarSessionAdmin()
	{
		try {
			UsuarioDTO user = loginService.autenticarUsuario(credencialesDTO);
			if (user != null) {
				JsfUtil.addInfoMessage("bien");
				JsfUtil.putObject("UsuarioDTO",user);
				JsfUtil.redirect("inicio.jsf");
			} else {
				JsfUtil.addErrorMessage("Datos Tncorrectos");
			}
		} catch (IOException e) {
			JsfUtil.addErrorMessage("mal");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage("mal");
		}		
	}
	
	public CredencialesDTO getCredencialesDTO() {
		return credencialesDTO;
	}

	public void setCredencialesDTO(CredencialesDTO credencialesDTO) {
		this.credencialesDTO = credencialesDTO;
	}

	public void logout()
	{
	      try {
			HttpSession session = JsfUtil.getSession();
		      session.invalidate();
			JsfUtil.redirect("/SILSAEWeb/index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
