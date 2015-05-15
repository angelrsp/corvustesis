package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@SessionScoped
@ManagedBean(name = "encuestaDataManager")
public class EncuestaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ResultadoDTO> resultadoList;
	
	private UsuarioDTO usuarioDTO;
	private CandidatoDTO candidatoDTO;
	
	public EncuestaDataManager() {
		resultadoList=new ArrayList<ResultadoDTO>();
		usuarioDTO=new UsuarioDTO();
		candidatoDTO=new CandidatoDTO();
	}

	public List<ResultadoDTO> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<ResultadoDTO> resultadoList) {
		this.resultadoList = resultadoList;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}

	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}

}
