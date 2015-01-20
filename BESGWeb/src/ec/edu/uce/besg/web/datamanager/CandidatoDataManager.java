package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.CandidatoListDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadListDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;

@ViewScoped
@ManagedBean(name = "candidatoDataManager")
public class CandidatoDataManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CandidatoDTO candidatoInsertar;
	
	
	private List<CandidatoDTO> candidatoDTOs;
	
	private List<CatalogoDTO> tipoDocumentoCatalogoList;
	private List<CatalogoDTO> estadoCivilCatalogoList;
	private List<CatalogoDTO> sexoCatalogoList;
	private List<CatalogoDTO> nivelEstudioCatalogoList;
	private List<CatalogoDTO> paisCatalogoList;
	
	private List<CatalogoDTO> especialidadListDTOs;
	private List<CatalogoDTO> especialidadCuartoListDTOs;
	private List<CatalogoDTO> especialidadTerceroListDTOs;
	
	
	
	private List<HabilidadListDTO> estudioDtos;
	private List<HabilidadListDTO> cursosDTOs;

	private int codigotipo;
	private int codigoEstadoCivil;
	private int codigoSexo;
	
	private Date fechaNac;
	
	private HabilidadDTO estudioInsertar;
	private HabilidadDTO cursoInsertar;
	private CandidatoListDTO candidatoListDTO;
	
	private int codigoNivEst;
	private int codigoEspecialidad;
	private int codigoEspTercero;
	private int codigoEspCuarto;
	private int codigoPais;
	
	private Date fechaInicio;
	private Date fechaFin;

	
	
	public CandidatoDataManager() {
		candidatoInsertar=new CandidatoDTO();
		
		tipoDocumentoCatalogoList=new ArrayList<CatalogoDTO>();
		estadoCivilCatalogoList=new ArrayList<CatalogoDTO>();
		sexoCatalogoList=new ArrayList<CatalogoDTO>();
		candidatoListDTO=new CandidatoListDTO();
		nivelEstudioCatalogoList=new ArrayList<CatalogoDTO>();
		especialidadListDTOs=new ArrayList<CatalogoDTO>();
		paisCatalogoList=new ArrayList<CatalogoDTO>();
		candidatoDTOs=new ArrayList<CandidatoDTO>();
		cursosDTOs=new ArrayList<HabilidadListDTO>();
		estudioDtos=new ArrayList<HabilidadListDTO>();
		estudioInsertar=new HabilidadDTO();
		cursoInsertar=new HabilidadDTO();
	}

	public int getCodigoNivEst() {
		return codigoNivEst;
	}

	public void setCodigoNivEst(int codigoNivEst) {
		this.codigoNivEst = codigoNivEst;
	}

	public int getCodigotipo() {
		return codigotipo;
	}

	public void setCodigotipo(int codigotipo) {
		this.codigotipo = codigotipo;
	}

	public int getCodigoEstadoCivil() {
		return codigoEstadoCivil;
	}

	public void setCodigoEstadoCivil(int codigoEstadoCivil) {
		this.codigoEstadoCivil = codigoEstadoCivil;
	}

	public int getCodigoSexo() {
		return codigoSexo;
	}

	public void setCodigoSexo(int codigoSexo) {
		this.codigoSexo = codigoSexo;
	}

	public CandidatoDTO getCandidatoInsertar() {
		return candidatoInsertar;
	}

	public void setCandidatoInsertar(CandidatoDTO candidatoInsertar) {
		this.candidatoInsertar = candidatoInsertar;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public CandidatoListDTO getCandidatoListDTO() {
		return candidatoListDTO;
	}

	public void setCandidatoListDTO(CandidatoListDTO candidatoListDTO) {
		this.candidatoListDTO = candidatoListDTO;
	}
	
	public List<CatalogoDTO> getEspecialidadListDTOs() {
		return especialidadListDTOs;
	}

	public void setEspecialidadListDTOs(List<CatalogoDTO> especialidadListDTOs) {
		this.especialidadListDTOs = especialidadListDTOs;
	}

	public int getCodigoEspecialidad() {
		return codigoEspecialidad;
	}

	public void setCodigoEspecialidad(int codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}

	public List<CatalogoDTO> getEspecialidadCuartoListDTOs() {
		return especialidadCuartoListDTOs;
	}

	public void setEspecialidadCuartoListDTOs(
			List<CatalogoDTO> especialidadCuartoListDTOs) {
		this.especialidadCuartoListDTOs = especialidadCuartoListDTOs;
	}

	public List<CatalogoDTO> getEspecialidadTerceroListDTOs() {
		return especialidadTerceroListDTOs;
	}

	public void setEspecialidadTerceroListDTOs(
			List<CatalogoDTO> especialidadTerceroListDTOs) {
		this.especialidadTerceroListDTOs = especialidadTerceroListDTOs;
	}

	public int getCodigoEspTercero() {
		return codigoEspTercero;
	}

	public void setCodigoEspTercero(int codigoEspTercero) {
		this.codigoEspTercero = codigoEspTercero;
	}

	public int getCodigoEspCuarto() {
		return codigoEspCuarto;
	}

	public void setCodigoEspCuarto(int codigoEspCuarto) {
		this.codigoEspCuarto = codigoEspCuarto;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<CandidatoDTO> getCandidatoDTOs() {
		return candidatoDTOs;
	}

	public void setCandidatoDTOs(List<CandidatoDTO> candidatoDTOs) {
		this.candidatoDTOs = candidatoDTOs;
	}

	public List<HabilidadListDTO> getCursosDTOs() {
		return cursosDTOs;
	}

	public void setCursosDTOs(List<HabilidadListDTO> cursosDTOs) {
		this.cursosDTOs = cursosDTOs;
	}

	public HabilidadDTO getEstudioInsertar() {
		return estudioInsertar;
	}

	public void setEstudioInsertar(HabilidadDTO estudioInsertar) {
		this.estudioInsertar = estudioInsertar;
	}

	public HabilidadDTO getCursoInsertar() {
		return cursoInsertar;
	}

	public void setCursoInsertar(HabilidadDTO cursoInsertar) {
		this.cursoInsertar = cursoInsertar;
	}

	public List<HabilidadListDTO> getEstudioDtos() {
		return estudioDtos;
	}

	public void setEstudioDtos(List<HabilidadListDTO> estudioDtos) {
		this.estudioDtos = estudioDtos;
	}

	public List<CatalogoDTO> getEstadoCivilCatalogoList() {
		return estadoCivilCatalogoList;
	}

	public void setEstadoCivilCatalogoList(List<CatalogoDTO> estadoCivilCatalogoList) {
		this.estadoCivilCatalogoList = estadoCivilCatalogoList;
	}

	public List<CatalogoDTO> getTipoDocumentoCatalogoList() {
		return tipoDocumentoCatalogoList;
	}

	public void setTipoDocumentoCatalogoList(
			List<CatalogoDTO> tipoDocumentoCatalogoList) {
		this.tipoDocumentoCatalogoList = tipoDocumentoCatalogoList;
	}

	public List<CatalogoDTO> getSexoCatalogoList() {
		return sexoCatalogoList;
	}

	public void setSexoCatalogoList(List<CatalogoDTO> sexoCatalogoList) {
		this.sexoCatalogoList = sexoCatalogoList;
	}

	public List<CatalogoDTO> getNivelEstudioCatalogoList() {
		return nivelEstudioCatalogoList;
	}

	public void setNivelEstudioCatalogoList(
			List<CatalogoDTO> nivelEstudioCatalogoList) {
		this.nivelEstudioCatalogoList = nivelEstudioCatalogoList;
	}

	public List<CatalogoDTO> getPaisCatalogoList() {
		return paisCatalogoList;
	}

	public void setPaisCatalogoList(List<CatalogoDTO> paisCatalogoList) {
		this.paisCatalogoList = paisCatalogoList;
	}

}
