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

	private HabilidadDTO adicionalDTO;
	private List<HabilidadViewDTO> adicionalList;

	private HabilidadDTO idiomaDTO;
	private List<HabilidadViewDTO> idiomaList;

	private List<CatalogoDTO> nivelIdiomaList;
	private Integer nivelIdiomaCode;

	private List<CatalogoDTO> idiomaCatalogoList;
	private Integer idiomaCode;

	
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
		
		adicionalDTO=new HabilidadDTO();
		adicionalList=new ArrayList<HabilidadViewDTO>();
		
		idiomaDTO=new HabilidadDTO();
		idiomaList=new ArrayList<HabilidadViewDTO>();
		
		nivelIdiomaList=new ArrayList<CatalogoDTO>();

		idiomaCatalogoList=new ArrayList<CatalogoDTO>();

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

	public HabilidadDTO getAdicionalDTO() {
		return adicionalDTO;
	}

	public void setAdicionalDTO(HabilidadDTO adicionalDTO) {
		this.adicionalDTO = adicionalDTO;
	}

	public List<HabilidadViewDTO> getAdicionalList() {
		return adicionalList;
	}

	public void setAdicionalList(List<HabilidadViewDTO> adicionalList) {
		this.adicionalList = adicionalList;
	}

	public HabilidadDTO getIdiomaDTO() {
		return idiomaDTO;
	}

	public void setIdiomaDTO(HabilidadDTO idiomaDTO) {
		this.idiomaDTO = idiomaDTO;
	}

	public List<HabilidadViewDTO> getIdiomaList() {
		return idiomaList;
	}

	public void setIdiomaList(List<HabilidadViewDTO> idiomaList) {
		this.idiomaList = idiomaList;
	}

	public List<CatalogoDTO> getNivelIdiomaList() {
		return nivelIdiomaList;
	}

	public void setNivelIdiomaList(List<CatalogoDTO> nivelIdiomaList) {
		this.nivelIdiomaList = nivelIdiomaList;
	}

	public Integer getNivelIdiomaCode() {
		return nivelIdiomaCode;
	}

	public void setNivelIdiomaCode(Integer nivelIdiomaCode) {
		this.nivelIdiomaCode = nivelIdiomaCode;
	}

	public List<CatalogoDTO> getIdiomaCatalogoList() {
		return idiomaCatalogoList;
	}

	public void setIdiomaCatalogoList(List<CatalogoDTO> idiomaCatalogoList) {
		this.idiomaCatalogoList = idiomaCatalogoList;
	}

	public Integer getIdiomaCode() {
		return idiomaCode;
	}

	public void setIdiomaCode(Integer idiomaCode) {
		this.idiomaCode = idiomaCode;
	}
}
