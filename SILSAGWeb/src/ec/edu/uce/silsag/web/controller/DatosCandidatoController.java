package ec.edu.uce.silsag.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CursoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean (name = "datosCandidatoController")
public class DatosCandidatoController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(DatosCandidatoController.class);
	
	@EJB
	private CandidatosService candidatosService;
	
	private UsuarioDTO user;
	private CandidatoDTO candidato;
	private EstudioDTO estudio;
	private ExperienciaDTO experiencia;
	private ReferenciaDTO referencia;
	private CursoDTO curso;
	private AdicionalDTO adicional;
	
	private Object tipoDocumento;
	private Object nivelEstudio;
	private Object pais;
	private Object tipoEmpresa;
	private Object estadoCivil;
	private Object genero;
	private Object especialidad;
	
	private Date fechaInicioExp;
	private Date fechaFinExp;
	
	private List<EstudioListDTO> listEstudio;
	private List<ExperienciaListDTO> experienciaList;
	private List<ReferenciaDTO> listReferencia;
	private List<CursoDTO> cursoList;
	private List<AdicionalDTO> adicionalList;
	
	private Date fechaNacimiento;
	private Date fechaMaximo;
	
	private Date fechaInicioCurso;
	private Date fechaFinCurso;
	private Date fechaMaximoActual;
	
	private Date fechaInicioEstudio;
	private Date fechaFinEstudio;
	
	
		
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
		genero=candidato.getCanSexo();
		estudio=new EstudioDTO();
		listEstudio=new ArrayList<EstudioListDTO>();
		experiencia=new ExperienciaDTO();
		experienciaList=new ArrayList<ExperienciaListDTO>();
		referencia=new ReferenciaDTO();
		listReferencia=new ArrayList<ReferenciaDTO>();
		
		
		//foto=new DefaultStreamedContent();
		curso=new CursoDTO();
		cursoList=new ArrayList<CursoDTO>();
		
		adicional=new AdicionalDTO();
		adicionalList=new ArrayList<AdicionalDTO>();
		
		nivelEstudio=0;
		
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -18); // to get previous year add -1
		fechaMaximo = cal.getTime();
		
		cal=Calendar.getInstance();
		fechaMaximoActual=cal.getTime() ;
		
		estadoCivil=candidato.getCanEstadoCivil();
		
		try {
			if(candidatosService.obtenerResutado(candidato)==null)
				JsfUtil.redirect("/SILSAGWeb/pages/candidato/encuesta.jsf");
		} catch (SilsagException e) {
			logger.info(e.toString());
		} catch (IOException e) {
			logger.info(e.toString());
		}
		logger.info("Inicio");
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

	public Date getFechaInicioEstudio() {
		return fechaInicioEstudio;
	}

	public void setFechaInicioEstudio(Date fechaInicioEstudio) {
		this.fechaInicioEstudio = fechaInicioEstudio;
	}

	public Date getFechaFinEstudio() {
		return fechaFinEstudio;
	}

	public void setFechaFinEstudio(Date fechaFinEstudio) {
		this.fechaFinEstudio = fechaFinEstudio;
	}

	public Object getPais() {
		return pais;
	}

	public void setPais(Object pais) {
		this.pais = pais;
	}

	public List<EstudioListDTO> getListEstudio() {
		try {
			this.listEstudio=candidatosService.obtenerEstudio(getCandidato());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		return this.listEstudio;
	}

	public Date getFechaInicioCurso() {
		return fechaInicioCurso;
	}

	public void setFechaInicioCurso(Date fechaInicioCurso) {
		this.fechaInicioCurso = fechaInicioCurso;
	}

	public Date getFechaFinCurso() {
		return fechaFinCurso;
	}

	public void setFechaFinCurso(Date fechaFinCurso) {
		this.fechaFinCurso = fechaFinCurso;
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

	public List<ExperienciaListDTO> getExperienciaList() {
		try {
			this.experienciaList=candidatosService.obtenerExperiencia(candidato);
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return this.experienciaList;
	}

	public Object getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(Object tipoEmpresa) {
		this.tipoEmpresa=tipoEmpresa;
	}

	public Object getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Object especialidad) {
		this.especialidad = especialidad;
	}

	public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}

	public AdicionalDTO getAdicional() {
		return adicional;
	}

	public void setAdicional(AdicionalDTO adicional) {
		this.adicional = adicional;
	}

	public ReferenciaDTO getReferencia() {
		return referencia;
	}

	public void setReferencia(ReferenciaDTO referencia) {
		this.referencia = referencia;
	}

	public List<ReferenciaDTO> getListReferencia() throws SilsagException {
		listReferencia=candidatosService.obtenerReferencia(candidato);
		return listReferencia;
	}

	public Date getFechaNacimiento() {
		this.fechaNacimiento=candidato.getCanFechaNacimiento();
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaMaximoActual() {
		return fechaMaximoActual;
	}

	public List<CursoDTO> getCursoList() {
		try {
			this.cursoList=candidatosService.obtenerCurso(getCandidato());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return cursoList;
	}

	public void setCursoList(List<CursoDTO> cursoList) {
		this.cursoList = cursoList;
	}

	public List<AdicionalDTO> getAdicionalList() {
		try {
			this.adicionalList=candidatosService.obtenerAdicional(getCandidato());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return adicionalList;
	}

	public void setAdicionalList(List<AdicionalDTO> adicionalList) {
		this.adicionalList = adicionalList;
	}

	public Date getFechaMaximo() {
		return fechaMaximo;
	}

	public Object getEstadoCivil() {
		return estadoCivil;
	}

	public Object getGenero() {
		return genero;
	}

	public void setGenero(Object genero) {
		this.genero = genero;
	}

	public void setEstadoCivil(Object estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void agregarEstudio()
	{
		try {
			if(Integer.valueOf(nivelEstudio.toString())!=0)
			{	
				getEstudio().setBemCandidato(getCandidato());
				getEstudio().setEstNivel(Integer.valueOf(nivelEstudio.toString()));
				getEstudio().setEstPais(pais!=null?Integer.valueOf(pais.toString()):null);
				getEstudio().setEstEspecialidad(especialidad!=null?Integer.valueOf(especialidad.toString()):null);
				getEstudio().setEstFechaInicio(new Timestamp(getFechaInicioEstudio().getTime()));
				getEstudio().setEstFechaFin(new Timestamp(getFechaFinEstudio().getTime()));
				candidatosService.agregarEstudio(getEstudio());
				getListEstudio();
				resetEstudio();
				JsfUtil.addInfoMessage("Agregado Exitosamente");
			}
			else
			{
				JsfUtil.addErrorMessage("Seleccione Nivel de Estudios");
			}
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void onRowDelEstudios(EstudioListDTO est)
	{
		try {
			estudio=new EstudioDTO();
			estudio.setEstCodigo(est.getEstCodigo());
			estudio.setBemCandidato(getCandidato());
			candidatosService.eliminarEstudio(estudio);
			estudio=new EstudioDTO();
			getListEstudio();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void resetEstudio()
	{
		setNivelEstudio(null);
		setPais(null);
		getEstudio().setEstCarrera("");
		getEstudio().setEstEstablecimiento("");
		setEstudio(new EstudioDTO());
	}

	
	public void agregarExperiencia()
	{
		try {
			 getExperiencia().setBemCandidato(getCandidato());
			 getExperiencia().setExpFechaInicio(new Timestamp(fechaInicioExp.getTime()));
			 getExperiencia().setExpFechaFin(new Timestamp(fechaFinExp.getTime()));
			 getExperiencia().setExpTipoEmpresa(Integer.valueOf(getTipoEmpresa().toString()));
			 candidatosService.agregarExperiencia(getExperiencia());
			 setExperiencia(new ExperienciaDTO());
			 getExperienciaList();
			 JsfUtil.addInfoMessage("Agregado Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void onRowDelExperiencia(ExperienciaListDTO exp)
	{
		try {
			setExperiencia(new ExperienciaDTO());
			getExperiencia().setExpCodigo(exp.getExpCodigo());
			candidatosService.eliminarExperiencia(getExperiencia());
			setExperiencia(new ExperienciaDTO());
			getExperienciaList();
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void agregarReferencia()
	{
		try{
			getReferencia().setBemCandidato(getCandidato());
			candidatosService.agregarReferencia(getReferencia());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			getListReferencia();
			setReferencia(new ReferenciaDTO());	
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
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
		
	
	public void agregarCurso()
	{
		try {
			getCurso().setBemCandidato(getCandidato());
			getCurso().setCurFechaInicio(new Timestamp(getFechaInicioCurso().getTime()));
			getCurso().setCurFechaFin(new Timestamp(getFechaFinCurso().getTime()));
			candidatosService.agregarCurso(getCurso());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			getCursoList();
			setCurso(new CursoDTO());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onRowDelCurso(CursoDTO cur)
	{
		try {
			candidatosService.eliminarCurso(cur);
			getCursoList();
			setCurso(new CursoDTO());
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void agregarAdicional()
	{
		try {
			getAdicional().setBemCandidato(getCandidato());
			candidatosService.agregarAdicional(getAdicional());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			getAdicionalList();
			setAdicional(new AdicionalDTO());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void onRowDelAdicional(AdicionalDTO adi)
	{
		try {
			candidatosService.eliminarAdicional(adi);
			getAdicionalList();
			setAdicional(new AdicionalDTO());
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public void actualizar()
	{
		try {
			candidato.setBemUsuario(user);
			candidato.setCanFechaNacimiento(new Timestamp(fechaNacimiento.getTime()));
			//candidato.setCanFoto(uploadedFile.getContents());
			candidato.setCanEstadoCivil(Integer.valueOf(estadoCivil.toString()));
			candidato.setCanSexo(Integer.valueOf(genero.toString()));
			candidato.setCanFechaUltima(new Timestamp(new Date().getTime()));
			candidatosService.actualizarCandidato(candidato);
			JsfUtil.addInfoMessage("Datos Actulizados Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {  
		logger.info("Entro imagen");      
		getCandidato().setCanFoto(event.getFile().getContents());
	    JsfUtil.addInfoMessage("Succesful"+ event.getFile().getFileName() + " is uploaded.");
	    try {
			candidatosService.actualizarCandidato(getCandidato());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	

	
	public void handleFileUploadEstudio(FileUploadEvent event) {        
		getEstudio().setEstArchivo(event.getFile().getContents());
	    JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
	}
	

	
	public void descargarEstudio(EstudioListDTO est)
	{
		try {
			logger.info("descargarEstudio");
			EstudioDTO estu=candidatosService.obtenerEstudio(est.getEstCodigo());
			byte[] archivo=estu.getEstArchivo();
			if(archivo!=null)
				JsfUtil.descargarArchivo(archivo);
			else
				JsfUtil.addErrorMessage("No existe archivo");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void handleFileUploadCurso(FileUploadEvent event) {        
		getCurso().setCurArchivo(event.getFile().getContents());
	    JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
	}	
	
	public void descargarCurso(CursoDTO cur)
	{
		logger.info("descargarEstudio");
		byte[] archivo=cur.getCurArchivo();
		if(archivo!=null)
			JsfUtil.descargarArchivo(archivo);
		else
			JsfUtil.addErrorMessage("No existe archivo");
	}
	
	public void handleFileUploadAdicional(FileUploadEvent event) {        
		getAdicional().setAdiArchivo(event.getFile().getContents());
	    JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
	}	
	
	public void descargarAdicional(AdicionalDTO adi)
	{
		logger.info("descargarAdicional");
		byte[] archivo=adi.getAdiArchivo();
		if(archivo!=null)
			JsfUtil.descargarArchivo(archivo);
		else
			JsfUtil.addErrorMessage("No existe archivo");
	}
	
	public void handleFileUploadExperiencia(FileUploadEvent event) {        
		getExperiencia().setExpArchivo(event.getFile().getContents());
	    JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
	}	
	
	public void descargarExperiencia(ExperienciaListDTO exp)
	{
		logger.info("descargarAdicional");
		ExperienciaDTO expe;
		try {
			expe = candidatosService.obtenerEsperiencia(exp.getExpCodigo());
			byte[] archivo=expe.getExpArchivo();
			if(archivo!=null)
				JsfUtil.descargarArchivo(archivo);
			else
				JsfUtil.addErrorMessage("No existe archivo");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void handleFileUploadReferencia(FileUploadEvent event) {        
		getReferencia().setRefArchivo(event.getFile().getContents());
	    JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
	}	
	
	public void descargarReferencia(ReferenciaDTO ref)
	{
		byte[] archivo=ref.getRefArchivo();
		if(archivo!=null)
			JsfUtil.descargarArchivo(archivo);
		else
			JsfUtil.addErrorMessage("No existe archivo");
	}

	
}
