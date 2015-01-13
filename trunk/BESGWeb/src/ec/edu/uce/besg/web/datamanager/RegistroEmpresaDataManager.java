package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "registroEmpresaDataManager")
public class RegistroEmpresaDataManager implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmpresaDTO empresaDTO;
	private UsuarioDTO usuarioDTO;
		
	
	public RegistroEmpresaDataManager()
	{
		empresaDTO=new EmpresaDTO();
		usuarioDTO=new UsuarioDTO();
	}


	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}


	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}


	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}


	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	
}
