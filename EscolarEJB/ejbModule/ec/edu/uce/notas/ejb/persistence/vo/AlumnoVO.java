package ec.edu.uce.notas.ejb.persistence.vo;

import java.io.Serializable;

import ec.edu.uce.notas.ejb.persistence.entity.AlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;

public class AlumnoVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private AlumnoDTO alumnoDTO;
	private UsuarioDTO usuarioDTO;
	
	public AlumnoVO() {
		alumnoDTO=new AlumnoDTO();
		usuarioDTO=new UsuarioDTO();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public AlumnoDTO getAlumnoDTO() {
		return alumnoDTO;
	}

	public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
		this.alumnoDTO = alumnoDTO;
	}
	
}
