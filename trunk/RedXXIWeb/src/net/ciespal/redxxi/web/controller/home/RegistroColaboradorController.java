package net.ciespal.redxxi.web.controller.home;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.vo.UsuarioVO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.controller.SelectItemController;
import net.ciespal.redxxi.web.datamanager.home.RegistroColaboradorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean (name = "registroColaboradorController")
public class RegistroColaboradorController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{registroColaboradorDataManager}")
	private RegistroColaboradorDataManager registroColaboradorDataManager;

	@EJB
	private AdministracionService administracionService;
	
	public RegistroColaboradorController() {
	
	}

	public RegistroColaboradorDataManager getRegistroColaboradorDataManager() {
		return registroColaboradorDataManager;
	}

	public void setRegistroColaboradorDataManager(
			RegistroColaboradorDataManager registroColaboradorDataManager) {
		this.registroColaboradorDataManager = registroColaboradorDataManager;
	}
	
	
	public void registrar()
	{
		UsuarioVO userVo;
		PerfilDTO perfil;
		try {
			userVo=new UsuarioVO();
			perfil=new PerfilDTO();
			perfil.setPerCodigo(-3);
			registroColaboradorDataManager.getUser().setUsuTipo(2);
			userVo.setPerfil(perfil);
			userVo.setUser(registroColaboradorDataManager.getUser());
			administracionService.createOrUpdateUsuario(userVo);
			registroColaboradorDataManager.setUser(new UsuarioDTO());
			JsfUtil.addInfoMessage("Registrado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}

	

	public Boolean verificarMail()
	{
		UsuarioDTO user;
		Boolean existe = Boolean.TRUE;
		try {
			user=new UsuarioDTO();
			user.setUsuLogin(registroColaboradorDataManager.getUser().getUsuLogin());
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
