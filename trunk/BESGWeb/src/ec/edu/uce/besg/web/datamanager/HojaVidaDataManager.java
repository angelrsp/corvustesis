package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.HabilidadViewDTO;



@ViewScoped
@ManagedBean(name = "hojaVidaDataManager")
public class HojaVidaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CatalogoDTO> tipoDocumentoList;
	
	private List<CatalogoDTO> estadoCivilList;
	
	private CandidatoDTO candidatoDTO;
	private UsuarioDTO usuarioDTO;

	private List<CatalogoDTO> generoList;
 
	private List<CatalogoDTO> nivelEstudioList;
	private Integer nivelEstudioCode;
	
	private List<CatalogoDTO> paisList;
	
	private HabilidadDTO formacionAcademicaDTO;
	private List<HabilidadViewDTO> formacionAcademicaList;
	
	private HabilidadDTO cursoDTO;
	private List<HabilidadViewDTO> cursoList;
	
	
	public HojaVidaDataManager() {
		tipoDocumentoList=new ArrayList<CatalogoDTO>();
		estadoCivilList=new ArrayList<CatalogoDTO>();
		generoList=new ArrayList<CatalogoDTO>();
		paisList=new ArrayList<CatalogoDTO>();
		
		
		candidatoDTO=new CandidatoDTO();
		usuarioDTO=new UsuarioDTO();
		
		nivelEstudioList=new ArrayList<CatalogoDTO>();
		
		formacionAcademicaDTO=new HabilidadDTO();
		formacionAcademicaList=new ArrayList<HabilidadViewDTO>();
		
		cursoDTO=new HabilidadDTO();
		cursoList=new ArrayList<HabilidadViewDTO>();
	}

	public List<CatalogoDTO> getTipoDocumentoList() {
		return tipoDocumentoList;
	}

	public void setTipoDocumentoList(List<CatalogoDTO> tipoDocumentoList) {
		this.tipoDocumentoList = tipoDocumentoList;
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

	public List<CatalogoDTO> getGeneroList() {
		return generoList;
	}

	public void setGeneroList(List<CatalogoDTO> generoList) {
		this.generoList = generoList;
	}

	public List<CatalogoDTO> getNivelEstudioList() {
		return nivelEstudioList;
	}

	public void setNivelEstudioList(List<CatalogoDTO> nivelEstudioList) {
		this.nivelEstudioList = nivelEstudioList;
	}

	public Integer getNivelEstudioCode() {
		return nivelEstudioCode;
	}

	public void setNivelEstudioCode(Integer nivelEstudioCode) {
		this.nivelEstudioCode = nivelEstudioCode;
	}

	public List<CatalogoDTO> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<CatalogoDTO> paisList) {
		this.paisList = paisList;
	}

	public HabilidadDTO getFormacionAcademicaDTO() {
		return formacionAcademicaDTO;
	}

	public void setFormacionAcademicaDTO(HabilidadDTO formacionAcademicaDTO) {
		this.formacionAcademicaDTO = formacionAcademicaDTO;
	}

	public List<HabilidadViewDTO> getFormacionAcademicaList() {
		return formacionAcademicaList;
	}

	public void setFormacionAcademicaList(
			List<HabilidadViewDTO> formacionAcademicaList) {
		this.formacionAcademicaList = formacionAcademicaList;
	}

	public HabilidadDTO getCursoDTO() {
		return cursoDTO;
	}

	public void setCursoDTO(HabilidadDTO cursoDTO) {
		this.cursoDTO = cursoDTO;
	}

	public List<HabilidadViewDTO> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<HabilidadViewDTO> cursoList) {
		this.cursoList = cursoList;
	}
}
