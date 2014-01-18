package ec.edu.uce.silsag.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CursoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
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
	
	private Date fechaInicioExp;
	private Date fechaFinExp;
	
//	private List<EstudioListDTO> listEstudio;
	private List<ExperienciaListDTO> experienciaList;
	private List<ReferenciaDTO> listReferencia;
	private List<CursoDTO> cursoList;
	private List<AdicionalDTO> adicionalList;
	
	private UploadedFile uploadedFile;
	
	private Date fechaNacimiento;
	private Date fechaMaximo;
	
	private Date fechaInicioCurso;
	private Date fechaFinCurso;
	private Date fechaMaximoActual;
	
	private Part file1;
	
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
//		listEstudio=new ArrayList<EstudioListDTO>();
		experiencia=new ExperienciaDTO();
		experienciaList=new ArrayList<ExperienciaListDTO>();
		referencia=new ReferenciaDTO();
		listReferencia=new ArrayList<ReferenciaDTO>();
		
		curso=new CursoDTO();
		cursoList=new ArrayList<CursoDTO>();
		
		adicional=new AdicionalDTO();
		adicionalList=new ArrayList<AdicionalDTO>();
		
		
		
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
	
	
    public String upload() throws IOException {  
        InputStream inputStream = file1.getInputStream();          
       FileOutputStream outputStream = new FileOutputStream(getFilename(file1));  
         
       byte[] buffer = new byte[4096];          
       int bytesRead = 0;  
       while(true) {                          
           bytesRead = inputStream.read(buffer);  
           if(bytesRead > 0) {  
               outputStream.write(buffer, 0, bytesRead);  
           }else {  
               break;  
           }                         
       }  
       outputStream.close();  
       inputStream.close();  
        
       return "success";  
   }  
 
   private static String getFilename(Part part) {  
       for (String cd : part.getHeader("content-disposition").split(";")) {  
           if (cd.trim().startsWith("filename")) {  
               String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");  
               return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.  
           }  
       }  
       return null;  
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

	

//	public List<EstudioListDTO> getListEstudio() {
//		try {
//			this.listEstudio=candidatosService.obtenerEstudio(getCandidato());
//		} catch (SilsagException e) {
//			JsfUtil.addErrorMessage(e.getMessage());
//		}
//		return this.listEstudio;
//	}

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

	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
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
			//estudio=new EstudioDTO();
			estudio.setBemCandidato(candidato);
			estudio.setEstNivel(Integer.valueOf(nivelEstudio.toString()));
			estudio.setEstPais(Integer.valueOf(pais.toString()));
			candidatosService.agregarEstudio(estudio);
//			getListEstudio();
			resetEstudio();
			JsfUtil.addInfoMessage("Agregado Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
//	public void onRowDelEstudios(EstudioListDTO est)
//	{
//		try {
//			estudio=new EstudioDTO();
//			estudio.setEstCodigo(est.getEstCodigo());
//			estudio.setBemCandidato(getCandidato());
//			candidatosService.eliminarEstudio(estudio);
//			estudio=new EstudioDTO();
//			getListEstudio();
//			JsfUtil.addInfoMessage("Eliminado Exitosamente");
//		} catch (SilsagException e) {
//			JsfUtil.addErrorMessage(e.getMessage());
//		}
//		catch (Exception e) {
//			JsfUtil.addErrorMessage(e.getMessage());
//		}
//	}
	
	private void resetEstudio()
	{
		setNivelEstudio(null);
		setPais(null);
		estudio.setEstCarrera("");
		estudio.setEstEstablecimiento("");
		estudio=new EstudioDTO();
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
			candidatosService.actualizarCandidato(candidato);
			JsfUtil.addInfoMessage("Datos Actulizados Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void subirImagen()
	{
		logger.info("subirImagen");
		//candidato.setCanFoto(uploadedFile.getContents());
	    if(uploadedFile != null) {  
            FacesMessage msg = new FacesMessage("Succesful", uploadedFile.getFileName() + " is uploaded.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
            logger.info("Si");
	    }
	    else
	    {
            FacesMessage msg = new FacesMessage("Succesful", "No subio");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
            logger.info("No");
	    }
	}
	
	  public void handleFileUpload(FileUploadEvent event) {  
		  logger.info("Entro imagen");
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }
}
