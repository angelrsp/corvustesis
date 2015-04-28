package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;



@ViewScoped
@ManagedBean(name = "hojaVidaDataManager")
public class HojaVidaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CatalogoDTO> tipoDocumentoList;
	private Integer tipoDocumentoCode;
	
	private List<CatalogoDTO> estadoCivilList;
	private Integer estadoCivilCode;
	
	private CandidatoDTO candidatoDTO;
	private UsuarioDTO usuarioDTO;

	private List<CatalogoDTO> generoList;
	private Integer generoCode;
 
	
	public HojaVidaDataManager() {
		tipoDocumentoList=new ArrayList<CatalogoDTO>();
		estadoCivilList=new ArrayList<CatalogoDTO>();
		generoList=new ArrayList<CatalogoDTO>();
		
		candidatoDTO=new CandidatoDTO();
		usuarioDTO=new UsuarioDTO();
		
		
	}

	public List<CatalogoDTO> getTipoDocumentoList() {
		return tipoDocumentoList;
	}

	public void setTipoDocumentoList(List<CatalogoDTO> tipoDocumentoList) {
		this.tipoDocumentoList = tipoDocumentoList;
	}

	public Integer getTipoDocumentoCode() {
		return tipoDocumentoCode;
	}

	public void setTipoDocumentoCode(Integer tipoDocumentoCode) {
		this.tipoDocumentoCode = tipoDocumentoCode;
	}

	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}

	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public List<CatalogoDTO> getEstadoCivilList() {
		return estadoCivilList;
	}

	public void setEstadoCivilList(List<CatalogoDTO> estadoCivilList) {
		this.estadoCivilList = estadoCivilList;
	}

	public Integer getEstadoCivilCode() {
		return estadoCivilCode;
	}

	public void setEstadoCivilCode(Integer estadoCivilCode) {
		this.estadoCivilCode = estadoCivilCode;
	}

	public List<CatalogoDTO> getGeneroList() {
		return generoList;
	}

	public void setGeneroList(List<CatalogoDTO> generoList) {
		this.generoList = generoList;
	}

	public Integer getGeneroCode() {
		return generoCode;
	}

	public void setGeneroCode(Integer generoCode) {
		this.generoCode = generoCode;
	}
}
