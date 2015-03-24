package ec.edu.uce.besg.ejb.vo;

import java.io.Serializable;

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

public class CandidatoVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioDTO usuarioDTO;
	private CandidatoDTO candidatoDTO;
	
	public CandidatoVO() {
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
