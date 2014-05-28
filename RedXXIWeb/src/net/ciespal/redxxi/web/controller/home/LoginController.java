package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.LoginDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "loginController")
public class LoginController {

	
	@ManagedProperty(value="#{loginDataManager}")
	private LoginDataManager loginDataManager;

	@EJB
	private AdministracionService administracionService;

	@EJB
	private ArgosService argosService;


	public LoginController() {
	
	}
	
	public LoginDataManager getLoginDataManager() {
		return loginDataManager;
	}

	public void setLoginDataManager(LoginDataManager loginDataManager) {
		this.loginDataManager = loginDataManager;
	}

	public void intro()
	{
		UsuarioDTO usuario;
		try {
			usuario=administracionService.userAuthentication(loginDataManager.getCredencialesDTO());
			if(usuario!=null)
			{
				JsfUtil.addInfoMessage("Redireccionar...");
				JsfUtil.putObject("UsuarioDTO", usuario);
				if(usuario.getSegUsuarioPerfils().get(0).getSegPerfil().getPerCodigo()==-1)
				{
					JsfUtil.redirect(JsfUtil.getContextPath()+"/pages/public/defensor/opinion.xhtml");
					DefensorDTO def=new DefensorDTO();
					def.setDefUsuario(usuario.getUsuCodigo());
					JsfUtil.getExternalContext().getSessionMap().put("DefensorDTO", argosService.defensorRead(def).get(0));
				}
				else
				{
					JsfUtil.redirect(JsfUtil.getContextPath()+"/pages/home.xhtml");	
				}
			}
			else
				JsfUtil.addErrorMessage("Usuario o contraseña no válida");
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void logout()
	{
	      try {
			HttpSession session = JsfUtil.getSession();
		      session.invalidate();
			JsfUtil.redirect("/RedXXIWeb/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
