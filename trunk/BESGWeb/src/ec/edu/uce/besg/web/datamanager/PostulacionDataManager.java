package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CandidatoPostulacionViewDTO;

@ViewScoped
@ManagedBean(name = "postulacionDataManager")
public class PostulacionDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CandidatoPostulacionViewDTO> candidatoPostulacionViewList;
	
	private UsuarioDTO usuarioDTO;
	private EmpresaDTO empresaDTO;
	
	public PostulacionDataManager() {
		candidatoPostulacionViewList=new ArrayList<CandidatoPostulacionViewDTO>();
		usuarioDTO=new UsuarioDTO();
		empresaDTO=new EmpresaDTO();
	}

	public List<CandidatoPostulacionViewDTO> getCandidatoPostulacionViewList() {
		return candidatoPostulacionViewList;
	}

	public void setCandidatoPostulacionViewList(
			List<CandidatoPostulacionViewDTO> candidatoPostulacionViewList) {
		this.candidatoPostulacionViewList = candidatoPostulacionViewList;
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
