package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "usuarioDataManager")
public class UsuarioDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuarioDTO;
	private List<UsuarioDTO> usuarioList;
	
	private PerfilDTO perfilDTO;
	private List<PerfilDTO> perfilList;
	
	private String password;	
	
	private Boolean passRequired;
	
	public  UsuarioDataManager()
	{
		usuarioDTO=new UsuarioDTO();
		usuarioList=new ArrayList<UsuarioDTO>();
				
		passRequired=Boolean.TRUE;
		
		perfilDTO=new PerfilDTO();
		perfilList=new ArrayList<PerfilDTO>();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public List<UsuarioDTO> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<UsuarioDTO> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getPassRequired() {
		return passRequired;
	}

	public void setPassRequired(Boolean passRequired) {
		this.passRequired = passRequired;
	}

	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	public List<PerfilDTO> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<PerfilDTO> perfilList) {
		this.perfilList = perfilList;
	}
	
	
}
