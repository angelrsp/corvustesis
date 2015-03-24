package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;


@ViewScoped
@ManagedBean(name = "registroCandidatoDataManager")
public class RegistroCandidatoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioDTO usuarioDTO;
	private CandidatoDTO candidatoDTO;
	
	public RegistroCandidatoDataManager() {
		usuarioDTO=new UsuarioDTO();
		candidatoDTO=new CandidatoDTO();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}
	
	
	
	
}
