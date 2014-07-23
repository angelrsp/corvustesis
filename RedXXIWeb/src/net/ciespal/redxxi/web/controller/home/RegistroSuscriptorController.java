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
import net.ciespal.redxxi.web.datamanager.home.RegistroSuscriptorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean (name = "registroSuscriptorController")
public class RegistroSuscriptorController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{registroSuscriptorDataManager}")
	private RegistroSuscriptorDataManager registroSuscriptorDataManager;

	@EJB
	private AdministracionService administracionService;
	
	public void registrar()
	{
		UsuarioVO userVo;
		PerfilDTO perfil;
		try {
			userVo=new UsuarioVO();
			perfil=new PerfilDTO();
			perfil.setPerCodigo(-2);
			registroSuscriptorDataManager.getUser().setUsuTipo(2);
			registroSuscriptorDataManager.getUser().setUsuPais(Integer.valueOf(getPais().toString()));
			registroSuscriptorDataManager.getUser().setUsuProvincia(Integer.valueOf(getProvincia().toString()));
			registroSuscriptorDataManager.getUser().setUsuCiudad(Integer.valueOf(getCiudad().toString()));
			userVo.setPerfil(perfil);
			userVo.setUser(registroSuscriptorDataManager.getUser());
			administracionService.createOrUpdateUsuario(userVo);
			registroSuscriptorDataManager.setUser(new UsuarioDTO());
			JsfUtil.addInfoMessage("Registrado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}		
	}

	
	public RegistroSuscriptorDataManager getRegistroSuscriptorDataManager() {
		return registroSuscriptorDataManager;
	}


	public void setRegistroSuscriptorDataManager(
			RegistroSuscriptorDataManager registroSuscriptorDataManager) {
		this.registroSuscriptorDataManager = registroSuscriptorDataManager;
	}


	public Boolean verificarMail()
	{
		UsuarioDTO user;
		Boolean existe = Boolean.TRUE;
		try {
			user=new UsuarioDTO();
			user.setUsuLogin(registroSuscriptorDataManager.getUser().getUsuLogin());
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
