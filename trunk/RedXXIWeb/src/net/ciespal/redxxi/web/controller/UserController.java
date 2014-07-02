package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.picketbox.util.StringUtil;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioPerfilDTO;
import net.ciespal.redxxi.ejb.persistence.vo.UsuarioVO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.UserDataManager;

@ViewScoped
@ManagedBean(name = "userController")
public class UserController {

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
	}
	
}
