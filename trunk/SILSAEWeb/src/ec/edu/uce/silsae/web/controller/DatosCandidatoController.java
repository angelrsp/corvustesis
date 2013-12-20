package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.CandidatosService;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ReferenciaDTO;
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
	private IdiomaDTO idioma;
	private ReferenciaDTO referencia;
	
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
	private Object idiomaObj;
	private Object nivelIdioma;
	private Object estadoCivil;
	
	private Date fechaInicioExp;
	private Date fechaFinExp;
	
	private List<EstudioListDTO> listEstudio;
	private List<ExperienciaListDTO> listExperiencia;
	private List<SoftwareListDTO> listHerramientas;
	private List<IdiomaListDTO> listIdioma;
	private List<ReferenciaDTO> listReferencia;
	
	private UploadedFile uploadedFile;
	
	private Date fechaNacimiento;
	private Date fechaMaximo;
	
	
	private StreamedContent foto;
	
	
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
		idioma=new IdiomaDTO();
		referencia=new ReferenciaDTO();
		listIdioma=new ArrayList<IdiomaListDTO>();
		listReferencia=new ArrayList<ReferenciaDTO>();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -18); // to get previous year add -1
		fechaMaximo = cal.getTime();
		
		estadoCivil=candidato.getCanEstadoCivil();
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

	public IdiomaDTO getIdioma() {
		return idioma;
	}

	public void setIdioma(IdiomaDTO idioma) {
		this.idioma = idioma;
	}

	public ReferenciaDTO getReferencia() {
		return referencia;
	}

	public void setReferencia(ReferenciaDTO referencia) {
		this.referencia = referencia;
	}

	public Object getIdiomaObj() {
		return idiomaObj;
	}

	public void setIdiomaObj(Object idiomaObj) {
		this.idiomaObj = idiomaObj;
	}

	public Object getNivelIdioma() {
		return nivelIdioma;
	}

	public void setNivelIdioma(Object nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}

	public List<IdiomaListDTO> getListIdioma() throws SilsaeException {
		this.listIdioma=candidatosService.obtenerIdioma(candidato);
		return listIdioma;
	}

	public List<ReferenciaDTO> getListReferencia() throws SilsaeException {
		listReferencia=candidatosService.obtenerReferencia(candidato);
		return listReferencia;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public Date getFechaNacimiento() {
		this.fechaNacimiento=candidato.getCanFechaNacimiento();
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaMaximo() {
		return fechaMaximo;
	}

	public StreamedContent getFoto() {
		
		//foto = new DefaultStreamedContent(new ByteArrayInputStream(candidato.getCanFoto()) , "image/jpeg");
		return foto;
	}

	public Object getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Object estadoCivil) {
		this.estadoCivil = estadoCivil;
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
	
	public void onRowDelEstudios(EstudioListDTO est)
	{
		try {
			estudio=new EstudioDTO();
			estudio.setEstCodigo(est.getEstCodigo());
			candidatosService.eliminarEstudio(estudio);
			estudio=new EstudioDTO();
			getListEstudio();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
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
		estudio=new EstudioDTO();
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

	public void onRowDelExperiencia(ExperienciaListDTO exp)
	{
		try {
			experiencia=new ExperienciaDTO();
			experiencia.setExpCodigo(exp.getExpCodigo());
			candidatosService.eliminarExperiencia(experiencia);
			experiencia=new ExperienciaDTO();
			getListExperiencia();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
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
			getListHerramientas();
			resetHerramientas();	
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void onRowDelHerramientas(SoftwareListDTO soft)
	{
		try {
			herramientas=new SoftwareDTO();
			herramientas.setProCodigo(soft.getProCodigo());
			candidatosService.eliminarHerramientas(herramientas);
			herramientas=new SoftwareDTO();
			getListHerramientas();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void resetHerramientas()
	{
		setNivelPrograma(null);
		setPrograma(null);
		herramientas=new SoftwareDTO();
	}
	
	public void agregarIdioma()
	{
		try{
			idioma.setBemCandidato(candidato);
			idioma.setIdiIdioma(Integer.valueOf(idiomaObj.toString()));
			idioma.setIdiNivel(Integer.valueOf(nivelIdioma.toString()));
			candidatosService.agregarIdioma(idioma);
			getListIdioma();
			resetIdioma();	
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void onRowDelIdioma(IdiomaListDTO idi)
	{
		try {
			idioma=new IdiomaDTO();
			idioma.setIdiCodigo(idi.getIdiCodigo());
			candidatosService.eliminarIdioma(idioma);
			idioma=new IdiomaDTO();
			getListHerramientas();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	private void resetIdioma()
	{
		setNivelIdioma(null);;
		setIdiomaObj(null);
		idioma=new IdiomaDTO();
	}
	
	public void agregarReferencia()
	{
		try{
			referencia.setBemCandidato(candidato);
			candidatosService.agregarReferencia(referencia);
			getListReferencia();
			resetReferencia();	
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void onRowDelReferencia(ReferenciaDTO ref)
	{
		try {
			candidatosService.eliminarReferencia(ref);
			getListReferencia();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void resetReferencia()
	{
		setReferencia(null);
		referencia=new ReferenciaDTO();
	}
	
	
	public void actualizar()
	{
		try {
			candidato.setBemUsuario(user);
			candidato.setCanFechaNacimiento(new Timestamp(fechaNacimiento.getTime()));
			//candidato.setCanFoto(uploadedFile.getContents());
			candidato.setCanEstadoCivil(Integer.valueOf(estadoCivil.toString()));
			candidatosService.actualizarCandidato(candidato);
			JsfUtil.addInfoMessage("Datos Actulizados Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void subirImagen()
	{
		//candidato.setCanFoto(uploadedFile.getContents());
	    if(uploadedFile != null) {  
            FacesMessage msg = new FacesMessage("Succesful", uploadedFile.getFileName() + " is uploaded.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    else
	    {
            FacesMessage msg = new FacesMessage("Succesful", "No subio");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
	    	
	    }
	}
	
	  public void handleFileUpload(FileUploadEvent event) {  
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }
}
