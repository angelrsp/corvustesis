package ec.edu.uce.notas.ejb.persistence.vo;

import java.io.Serializable;

import ec.edu.uce.notas.ejb.persistence.entity.DocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;

public class DocenteVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private DocenteDTO docenteDTO;
	private UsuarioDTO usuarioDTO;
	
	public DocenteVO() {
		docenteDTO=new DocenteDTO();
		usuarioDTO=new UsuarioDTO();
	}

	public DocenteDTO getDocenteDTO() {
		return docenteDTO;
	}

	public void setDocenteDTO(DocenteDTO docenteDTO) {
		this.docenteDTO = docenteDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
}
