package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "userDataManager")
public class UserDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDTO user;
	
	private List<UsuarioDTO> userList;
	
	private Boolean required;
	private Boolean disabled; 
	
	private String pass;
	
	private List<PerfilDTO> perfilList;
	
	private Integer perfilCode;
	
	public UserDataManager() {
		user=new UsuarioDTO();
		userList=new ArrayList<UsuarioDTO>();
		required=true;
		perfilList=new ArrayList<PerfilDTO>();
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

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<PerfilDTO> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<PerfilDTO> perfilList) {
		this.perfilList = perfilList;
	}

	public Integer getPerfilCode() {
		return perfilCode;
	}

	public void setPerfilCode(Integer perfilCode) {
		this.perfilCode = perfilCode;
	}

	
}
