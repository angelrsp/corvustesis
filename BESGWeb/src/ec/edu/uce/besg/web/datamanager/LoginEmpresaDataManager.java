package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "loginEmpresaDataManager")
public class LoginEmpresaDataManager implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioDTO usuarioDTO;
	
	
	public LoginEmpresaDataManager()
	{
		usuarioDTO=new UsuarioDTO();
	}


	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}


	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
}
