package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.CandidatosService;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsae.web.util.JsfUtil;

@ViewScoped
@ManagedBean (name = "datosCandidatoController")
public class DatosCandidatoController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CandidatosService candidatosService;
	
	private UsuarioDTO user;
	private CandidatoDTO candidato;
	private EstudioDTO estudio;
	private ExperienciaDTO experiencia;
	private SoftwareDTO herramientas;
	
	private Object tipoDocumento;
	private Object nivelEstudio;
	private Object pais;
	private Object programa;
	private Object nivelPrograma;
	private Object anioInicio;
	private Object anioFin;
	private Object mesInicio;
	private Object mesFin;
	private Object tipoExperiencia;
	
	private Date fechaInicioExp;
	private Date fechaFinExp;
	
	private List<EstudioListDTO> listEstudio;
	private List<ExperienciaListDTO> listExperiencia;
	private List<SoftwareListDTO> listHerramientas;
	
	public DatosCandidatoController()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		user=new UsuarioDTO();
		candidato=new CandidatoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
		tipoDocumento=candidato.getCanTipoIdentificacion();
		estudio=new EstudioDTO();
		listEstudio=new ArrayList<EstudioListDTO>();
		experiencia=new ExperienciaDTO();
		listExperiencia=new ArrayList<ExperienciaListDTO>();
		listHerramientas=new ArrayList<SoftwareListDTO>();
		herramientas=new SoftwareDTO();
	}
	
	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public CandidatoDTO getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoDTO candidato) {
		this.candidato = candidato;
	}

	public Object getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Object tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
	public EstudioDTO getEstudio() {
		return estudio;
	}

	public void setEstudio(EstudioDTO estudio) {
		this.estudio = estudio;
	}

	public Object getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(Object nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public Object getPais() {
		return pais;
	}

	public void setPais(Object pais) {
		this.pais = pais;
	}

	public Object getPrograma() {
		return programa;
	}

	public void setPrograma(Object programa) {
		this.programa = programa;
	}

	public Object getNivelPrograma() {
		return nivelPrograma;
	}

	public void setNivelPrograma(Object nivelPrograma) {
		this.nivelPrograma = nivelPrograma;
	}

	public Object getAnioInicio() {
		return anioInicio;
	}

	public void setAnioInicio(Object anioInicio) {
		this.anioInicio = anioInicio;
	}

	public Object getAnioFin() {
		return anioFin;
	}

	public void setAnioFin(Object anioFin) {
		this.anioFin = anioFin;
	}

	public Object getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(Object mesInicio) {
		this.mesInicio = mesInicio;
	}

	public Object getMesFin() {
		return mesFin;
	}

	public void setMesFin(Object mesFin) {
		this.mesFin = mesFin;
	}

	public List<EstudioListDTO> getListEstudio() {
		try {
			this.listEstudio=candidatosService.obtenerEstudio(getCandidato());
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		return this.listEstudio;
	}

	public ExperienciaDTO getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ExperienciaDTO experiencia) {
		this.experiencia = experiencia;
	}

	public Date getFechaInicioExp() {
		return fechaInicioExp;
	}

	public void setFechaInicioExp(Date fechaInicioExp) {
		this.fechaInicioExp = fechaInicioExp;
	}

	public Date getFechaFinExp() {
		return fechaFinExp;
	}

	public void setFechaFinExp(Date fechaFinExp) {
		this.fechaFinExp = fechaFinExp;
	}

	public List<ExperienciaListDTO> getListExperiencia() throws SilsaeException {
			this.listExperiencia=candidatosService.obtenerExperiencia(candidato);
		return this.listExperiencia;
	}

	public Object getTipoExperiencia() {
		return tipoExperiencia;
	}

	public void setTipoExperiencia(Object tipoExperiencia) {
		this.tipoExperiencia = tipoExperiencia;
	}

	public SoftwareDTO getHerramientas() {
		return herramientas;
	}

	public void setHerramientas(SoftwareDTO herramientas) {
		this.herramientas = herramientas;
	}

	public List<SoftwareListDTO> getListHerramientas() throws SilsaeException {
		this.listHerramientas=candidatosService.obtenerHerramientas(candidato);
		return listHerramientas;
	}

	public void agregarEstudio()
	{
		try {
			estudio.setBemCandidato(candidato);
			estudio.setEstAnioFin(Integer.valueOf(anioFin.toString()));
			estudio.setEstAnioInicio(Integer.valueOf(anioInicio.toString()));
			estudio.setEstMesFin(Integer.valueOf(mesFin.toString()));
			estudio.setEstMesInicio(Integer.valueOf(mesInicio.toString()));
			estudio.setEstNivel(Integer.valueOf(nivelEstudio.toString()));
			estudio.setEstPais(Integer.valueOf(pais.toString()));
			candidatosService.agregarEstudio(estudio);
			getListEstudio();
			resetEstudio();
			JsfUtil.addInfoMessage("Agregado Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void resetEstudio()
	{
		setAnioFin(null);
		setAnioInicio(null);
		setMesFin(null);
		setMesInicio(null);
		setNivelEstudio(null);
		setPais(null);
		estudio.setEstCarrera("");
		estudio.setEstEstablecimiento("");
	}

	
	public void agregarExperiencia()
	{
		try {
			experiencia.setBemCandidato(candidato);
			experiencia.setExpTipoExperiencia(Integer.valueOf(tipoExperiencia.toString()));
			experiencia.setExpFechaInicio(new Timestamp(fechaInicioExp.getTime()));
			experiencia.setExpFechaFin(new Timestamp(fechaFinExp.getTime()));
			candidatosService.agregarExperiencia(experiencia);
			resetExperiencia();
			getListExperiencia();
			JsfUtil.addInfoMessage("Agregado Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void resetExperiencia()
	{
		setTipoExperiencia(null);
		experiencia=new ExperienciaDTO();
	}
	
	public void agregarHerramientas()
	{
		try{
			herramientas.setBemCandidato(candidato);
			herramientas.setProNivel(Integer.valueOf(nivelPrograma.toString()));
			herramientas.setProPrograma(Integer.valueOf(programa.toString()));
			candidatosService.agregarHerramientas(herramientas);
			getHerramientas();
			resetHerramientas();	
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void resetHerramientas()
	{
		setNivelPrograma(null);
		setPrograma(null);
		herramientas=new SoftwareDTO();
	}
}
