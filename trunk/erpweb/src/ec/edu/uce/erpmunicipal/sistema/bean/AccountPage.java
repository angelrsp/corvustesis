package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;
import ec.edu.uce.erpmunicipal.util.orm.SessionObject;

@ManagedBean(name = "accountPage")
@ViewScoped
public class AccountPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SisUsuario user;
	
	public AccountPage()
	{
		user=new SisUsuario();
	}

	public SisUsuario getUser() {
		return user;
	}

	public void setUser(SisUsuario user) {
		this.user = user;
	}
	
	private void read()
	{
		user= ((SessionObject) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("sessionObject")).getUser();
	}
	
	@PostConstruct
	private void init()
	{
		read();
	}
	
}
