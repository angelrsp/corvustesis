package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.vo.UsuarioVO;
import ec.edu.uce.notas.ejb.service.AdministracionService;
import ec.edu.uce.notas.ejb.service.CatalogoService;
import ec.edu.uce.notas.web.datamanager.UsuarioDataManager;

@ViewScoped
@ManagedBean(name = "usuarioController")
public class UsuarioController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{usuarioDataManager}")
	private UsuarioDataManager usuarioDataManager;

		
	@EJB
	private CatalogoService servicioCatalogo;
	
	@EJB
	private AdministracionService administracionService;
	

	public UsuarioController () {
		
	}

	public UsuarioDataManager getUsuarioDataManager() {
		return usuarioDataManager;
	}

	public void setUsuarioDataManager(UsuarioDataManager usuarioDataManager) {
		this.usuarioDataManager = usuarioDataManager;
	}

	@PostConstruct
	private void init()
	{
		readUsuario();
		readPerfil();
	}


	private void readPerfil()
	{
		try {
			usuarioDataManager.setPerfilList(administracionService.readPerfil(new PerfilDTO()));
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readUsuario()
	{
		UsuarioDTO usuarioDTO;
		try {
			usuarioDTO=new UsuarioDTO();
			usuarioDataManager.setUsuarioList(administracionService.readUsuarios(usuarioDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			usuarioDTO=null;
		}
	}
	
	
	private void clear()
	{
		usuarioDataManager.setUsuarioDTO(new UsuarioDTO());
		usuarioDataManager.setPassRequired(Boolean.TRUE);
	}
	
	public void onClickEdit(UsuarioDTO usuarioDTO)
	{
	    usuarioDataManager.setUsuarioDTO(usuarioDTO);	
	    usuarioDataManager.setPassRequired(Boolean.FALSE);
	    usuarioDataManager.setPerfilDTO(usuarioDTO.getSegUsuarioPerfils().get(0).getSegPerfil());
	}
	
	public void onClickSave()
	{
		UsuarioVO usuarioVO;
		try {
			usuarioVO=new UsuarioVO();
			
			usuarioVO.setUsuarioDTO(usuarioDataManager.getUsuarioDTO());
			usuarioVO.setPerfilDTO(usuarioDataManager.getPerfilDTO());
			
			if(usuarioDataManager.getPassword()!=null&usuarioDataManager.getPassword().trim()!="")
				usuarioVO.setPassword(usuarioDataManager.getPassword());
			
			administracionService.createUpdateUsuario(usuarioVO);

			clear();
			readUsuario();
			JsfUtil.addInfoMessage("Registro Exitoso");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			usuarioVO=null;
		}
	}
	
	public void onChangeEntity()
	{
		readUsuario();
	}
	
	public void onClickSearch()
	{
		UsuarioDTO usuarioDTO;
		try {
			usuarioDTO=new UsuarioDTO();
			usuarioDataManager.setUsuarioList(administracionService.readUsuarioDynamic(usuarioDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			usuarioDTO=null;
		}
	}
	
	public void onClickNew()
	{
		clear();
	}
}
