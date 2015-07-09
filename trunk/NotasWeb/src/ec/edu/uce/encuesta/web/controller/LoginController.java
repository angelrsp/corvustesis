package ec.edu.uce.encuesta.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;



@ViewScoped
@ManagedBean(name="loginController")
public class LoginController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void authenticate()
	{
		
		
			
			
			String url = "/NotasWeb/pages/system/inicio.xhtml";
					FacesContext fc = FacesContext.getCurrentInstance();
					ExternalContext ec = fc.getExternalContext();
					try {
					        ec.redirect(url);
					} catch (IOException ex) {
					       
					}
			
		
	}
}
