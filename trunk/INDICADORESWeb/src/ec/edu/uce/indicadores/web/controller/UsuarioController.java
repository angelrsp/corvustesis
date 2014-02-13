package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "usuarioController")
public class UsuarioController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	private UsuarioDTO user;
	private List<UsuarioDTO> userList;
	
	private Object iesSelect;
	
	
	public UsuarioController() {
	}

	@PostConstruct
	private void init()
	{
		user=new UsuarioDTO();
		userList=new ArrayList<UsuarioDTO>();
	}
	
	public UsuarioDTO getUser() {
		return user;
	}
	public void setUser(UsuarioDTO user) {
		this.user = user;
	}
	public List<UsuarioDTO> getUserList() {
		return userList;
	}
	public void setUserList(List<UsuarioDTO> userList) {
		this.userList = userList;
	}


	public Object getIesSelect() {
		return iesSelect;
	}

	public void setIesSelect(Object iesSelect) {
		this.iesSelect = iesSelect;
	}

	
	public void createUser() {
		try {
			administracionService.createUser(getUser());
			readUser();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void readUser()
	{
		IesDTO ies=new IesDTO();
		try {
			ies.setIesCodigo(Integer.valueOf(iesSelect.toString()));
			userList=administracionService.readUser(ies);
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
