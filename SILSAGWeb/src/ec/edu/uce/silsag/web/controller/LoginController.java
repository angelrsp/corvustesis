/**
 * 
 */
package ec.edu.uce.silsag.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import ec.edu.uce.silsag.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.LoginService;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

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
		} catch (SilsagException e) {
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
		} catch (SilsagException e) {
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
		} catch (SilsagException e) {
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
			JsfUtil.redirect("/SILSAGWeb/index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void recuperarClave()
	{
	      try {
			HttpSession session = JsfUtil.getSession();
		      session.invalidate();
			JsfUtil.redirect("/SILSAGWeb/index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void redireccionar()
	{
	      try {
			JsfUtil.redirect("recuperarClave.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enviar()
	{
	      try {
	    	  if(!loginService.recuperarClave(getCredencialesDTO()))
	    	  {
	    		  JsfUtil.addErrorMessage("Datos no encontrado");
	    	  }
	    	  else{
	    		  JsfUtil.addInfoMessage("La clave fue enviada a su correo electronico de registro");
	    	  }
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage("Eror al enviar "+e.toString());
			e.printStackTrace();
		}
	}
}
