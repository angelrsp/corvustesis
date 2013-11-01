/**
 * 
 */
package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.LoginService;
import ec.edu.uce.silsae.web.util.JsfUtil;

/**
 * @author 
 *
 */
@SessionScoped
@ManagedBean (name = "loginController")
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private LoginService loginService;
	
	private CredencialesDTO credencialesDTO;
	
	public LoginController () {}
	
	@PostConstruct
	public void inicializarObjetos () {
		this.credencialesDTO = new CredencialesDTO();
	}
	
	public void iniciarSesionUsuario () {
		
		try {
			loginService.autenticarUsuario(credencialesDTO);
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
	
}
