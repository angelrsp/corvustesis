package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.vo.DefensorVO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.controller.SelectItemController;
import net.ciespal.redxxi.web.datamanager.home.RegistroDefensorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean (name = "registroDefensorController")
public class RegistroDefensorController extends SelectItemController{

	
	@ManagedProperty(value="#{registroDefensorDataManager}")
	private RegistroDefensorDataManager registroDefensorDataManager;

	@EJB
	private ArgosService argosService;

	@EJB
	private AdministracionService administracionService;
	
	public RegistroDefensorController() {
	
	}
	
	public RegistroDefensorDataManager getRegistroDefensorDataManager() {
		return registroDefensorDataManager;
	}

	public void setRegistroDefensorDataManager(
			RegistroDefensorDataManager registroDefensorDataManager) {
		this.registroDefensorDataManager = registroDefensorDataManager;
	}

	
	public void registrar()
	{
		DefensorVO defensor;
		DefensorDTO def;
		try {
			if(verificarMail())
				return;
			defensor=new DefensorVO();
			def=new DefensorDTO();
			def.setDefPais(Integer.valueOf(getPais().toString()));
			def.setDefProvincia(Integer.valueOf(getProvincia().toString()));
			def.setDefCiudad(Integer.valueOf(getCiudad().toString()));
			defensor.setDefensor(def);
			defensor.setUser(registroDefensorDataManager.getUser());
			UsuarioDTO usr= argosService.defensorCreateOrUpdate(defensor);
			JsfUtil.getExternalContext().getSessionMap().put("UsuarioDTO", usr);
			def=new DefensorDTO();
			def.setDefUsuario(usr.getUsuCodigo());
			JsfUtil.getExternalContext().getSessionMap().put("DefensorDTO", argosService.defensorRead(def).get(0));
			JsfUtil.redirect(JsfUtil.getContextPath()+"/pages/public/defensor/opinion.xhtml");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public Boolean verificarMail()
	{
		UsuarioDTO user;
		Boolean existe = Boolean.TRUE;
		try {
			user=new UsuarioDTO();
			user.setUsuLogin(registroDefensorDataManager.getUser().getUsuLogin());
			if(administracionService.readUser(user).size()>0)
			{
				JsfUtil.addErrorMessage("El correo ya está registrado");
				existe=Boolean.TRUE;
			}
			else
				existe=Boolean.FALSE;
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return existe;
	}
	
	
	public void obtenerProvinciaChange() {
		try {
			getCatalogoProvincia();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}
	
	public void obtenerCiudadChange() {
		try {
			getCatalogoCiudad();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

}
