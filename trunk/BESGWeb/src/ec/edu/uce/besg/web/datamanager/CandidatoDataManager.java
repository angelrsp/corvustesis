package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.CandidatoListDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;

@ViewScoped
@ManagedBean(name = "candidatoDataManager")
public class CandidatoDataManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CandidatoDTO candidatoInsertar;
	private List<CandidatoListDTO> candidatoListDTOs;
	private List<CatalogoDTO> tipoDocumentoListDTOs;
	private List<CatalogoDTO> estadoCivilListDTOs;
	private List<CatalogoDTO> generoListDTOs;
	
	public CandidatoDataManager() {
		candidatoInsertar=new CandidatoDTO();
		tipoDocumentoListDTOs=new ArrayList<CatalogoDTO>();
		estadoCivilListDTOs=new ArrayList<CatalogoDTO>();
		generoListDTOs=new ArrayList<CatalogoDTO>();
		
	}

	public CandidatoDTO getCandidatoInsertar() {
		return candidatoInsertar;
	}

	public void setCandidatoInsertar(CandidatoDTO candidatoInsertar) {
		this.candidatoInsertar = candidatoInsertar;
	}

	public List<CandidatoListDTO> getCandidatoListDTOs() {
		return candidatoListDTOs;
	}

	public void setCandidatoListDTOs(List<CandidatoListDTO> candidatoListDTOs) {
		this.candidatoListDTOs = candidatoListDTOs;
	}

	public List<CatalogoDTO> getTipoDocumentoListDTOs() {
		return tipoDocumentoListDTOs;
	}

	public void setTipoDocumentoListDTOs(List<CatalogoDTO> tipoDocumentoListDTOs) {
		this.tipoDocumentoListDTOs = tipoDocumentoListDTOs;
	}

	public List<CatalogoDTO> getEstadoCivilListDTOs() {
		return estadoCivilListDTOs;
	}

	public void setEstadoCivilListDTOs(List<CatalogoDTO> estadoCivilListDTOs) {
		this.estadoCivilListDTOs = estadoCivilListDTOs;
	}

	public List<CatalogoDTO> getGeneroListDTOs() {
		return generoListDTOs;
	}

	public void setGeneroListDTOs(List<CatalogoDTO> generoListDTOs) {
		this.generoListDTOs = generoListDTOs;
	}
	
	

}
