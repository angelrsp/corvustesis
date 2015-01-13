package ec.edu.uce.besg.ejb.vo;

import java.io.Serializable;

import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

public class EmpresaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDTO usuarioDTO;
	private EmpresaDTO empresaDTO;
	
	public EmpresaVO()
	{
		empresaDTO = new EmpresaDTO();
		usuarioDTO = new UsuarioDTO();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}

	
	
}
