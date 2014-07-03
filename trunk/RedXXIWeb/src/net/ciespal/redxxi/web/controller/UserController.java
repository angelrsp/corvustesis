package net.ciespal.redxxi.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.vo.UsuarioVO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.UserDataManager;

import org.picketbox.util.StringUtil;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "userController")
public class UserController implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{userDataManager}")
	private UserDataManager userDataManager;

	@EJB
	private AdministracionService administracionService;

	public UserController() {
	
	}

	public UserDataManager getUserDataManager() {
		return userDataManager;
	}

	public void setUserDataManager(UserDataManager userDataManager) {
		this.userDataManager = userDataManager;
	}

	@PostConstruct
	private void init()
	{
		read();
		perfilRead();
		userDataManager.setRequired(true);
	}
	
	public void save()
	{
		UsuarioVO usuarioVO;
		PerfilDTO perfil;
		try {
			usuarioVO=new UsuarioVO();
			if(!StringUtil.isNullOrEmpty(userDataManager.getPass()))
				userDataManager.getUser().setUsuClave(userDataManager.getPass());
			userDataManager.getUser().setUsuTipo(1);
			perfil=new PerfilDTO();
			perfil.setPerCodigo(userDataManager.getPerfilCode());
			usuarioVO.setUser(userDataManager.getUser());
			usuarioVO.setPerfil(perfil);
			administracionService.createOrUpdateUsuario(usuarioVO);
			read();
			cancel();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancel()
	{
		userDataManager.setUser(new UsuarioDTO());
		read();
		userDataManager.setDisabled(false);
		userDataManager.setRequired(true);
		userDataManager.setPerfilCode(null);
	}
	
	private void read()
	{
		UsuarioDTO user;
		try {
			user=new UsuarioDTO();
			user.setUsuTipo(1);
			userDataManager.setUserList(administracionService.readAllUser(user));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void perfilRead()
	{
		try {
			userDataManager.setPerfilList(administracionService.perfilReadAll());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void edit(UsuarioDTO user)
	{
		userDataManager.setUser(user);
		userDataManager.setDisabled(true);
		userDataManager.setRequired(false);
		userDataManager.setPerfilCode(user.getSegUsuarioPerfils().get(0).getSegPerfil().getPerCodigo());
	}
	
}
