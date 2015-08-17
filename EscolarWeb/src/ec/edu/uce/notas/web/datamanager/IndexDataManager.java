package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.dto.CredencialDTO;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "indexDataManager")
public class IndexDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CredencialDTO credencialDTO;
	private UsuarioDTO usuarioDTO; 
	
	
	public IndexDataManager() {
		credencialDTO=new CredencialDTO();
		usuarioDTO=new UsuarioDTO();
	}

	public CredencialDTO getCredencialDTO() {
		return credencialDTO;
	}

	public void setCredencialDTO(CredencialDTO credencialDTO) {
		this.credencialDTO = credencialDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
}
