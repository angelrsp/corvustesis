package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PostulacionDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoPostulacionViewDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;

@ViewScoped
@ManagedBean(name = "verOfertasDataManager")
public class VerOfertasDataManager implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PostulacionDTO postulacionDTO;
	
	private CandidatoDTO candidatoDTO;
	private List<AvisoPostulacionViewDTO> avisoPostulacionViewList;
	
	private List<AvisoViewDTO> avisoViewList;
	
	
	public VerOfertasDataManager() {
		
		postulacionDTO=new PostulacionDTO();
		candidatoDTO=new CandidatoDTO();
		avisoPostulacionViewList=new ArrayList<AvisoPostulacionViewDTO>();
		avisoViewList=new ArrayList<AvisoViewDTO>();
	}

	public PostulacionDTO getPostulacionDTO() {
		return postulacionDTO;
	}

	public void setPostulacionDTO(PostulacionDTO postulacionDTO) {
		this.postulacionDTO = postulacionDTO;
	}

	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}

	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}

	public List<AvisoPostulacionViewDTO> getAvisoPostulacionViewList() {
		return avisoPostulacionViewList;
	}

	public void setAvisoPostulacionViewList(
			List<AvisoPostulacionViewDTO> avisoPostulacionViewList) {
		this.avisoPostulacionViewList = avisoPostulacionViewList;
	}

	public List<AvisoViewDTO> getAvisoViewList() {
		return avisoViewList;
	}

	public void setAvisoViewList(List<AvisoViewDTO> avisoViewList) {
		this.avisoViewList = avisoViewList;
	}

}
