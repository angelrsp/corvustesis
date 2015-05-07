package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CandidatoPostulacionViewDTO;

@ViewScoped
@ManagedBean(name = "misPostulacionesDataManager")
public class MisPostulacionesDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CandidatoPostulacionViewDTO> candidatoPostulacionViewList;
	
	private CandidatoDTO candidatoDTO;
	
	public MisPostulacionesDataManager() {
		candidatoPostulacionViewList=new ArrayList<CandidatoPostulacionViewDTO>();
		candidatoDTO=new CandidatoDTO();
	}

	
	public List<CandidatoPostulacionViewDTO> getCandidatoPostulacionViewList() {
		return candidatoPostulacionViewList;
	}

	public void setCandidatoPostulacionViewList(
			List<CandidatoPostulacionViewDTO> candidatoPostulacionViewList) {
		this.candidatoPostulacionViewList = candidatoPostulacionViewList;
	}


	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}


	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}
	
	
	
}
