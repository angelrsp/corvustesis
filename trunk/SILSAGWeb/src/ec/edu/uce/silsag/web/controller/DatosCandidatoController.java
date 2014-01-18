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
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaDTO;
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
	
//	private List<EstudioListDTO> listEstudio;
//	private List<ExperienciaListDTO> listExperiencia;
	private List<ReferenciaDTO> listReferencia;
	
	private UploadedFile uploadedFile;
	
	private Date fechaNacimiento;
	private Date fechaMaximo;
	
	
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
//		listExperiencia=new ArrayList<ExperienciaListDTO>();
		referencia=new ReferenciaDTO();
		listReferencia=new ArrayList<ReferenciaDTO>();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -18); // to get previous year add -1
		fechaMaximo = cal.getTime();
		
		estadoCivil=candidato.getCanEstadoCivil();
		
		try {
			if(candidatosService.obtenerResutado(candidato)==null)
			{
				JsfUtil.redirect("/SILSAGWeb/pages/candidato/encuesta.jsf");
			}
		} catch (SilsagException e) {
			// TODO Auto-generated catch block
			logger.info("AA",e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

//	public List<EstudioListDTO> getListEstudio() {
//		try {
//			this.listEstudio=candidatosService.obtenerEstudio(getCandidato());
//		} catch (SilsagException e) {
//			JsfUtil.addErrorMessage(e.getMessage());
//		}
//		return this.listEstudio;
//	}

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

//	public List<ExperienciaListDTO> getListExperiencia() throws SilsagException {
//			this.listExperiencia=candidatosService.obtenerExperiencia(candidato);
//		return this.listExperiencia;
//	}

	public Object getTipoExperiencia() {
		return tipoExperiencia;
	}

	public void setTipoExperiencia(Object tipoExperiencia) {
		this.tipoExperiencia = tipoExperiencia;
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
			experiencia.setExpFechaInicio(new Timestamp(fechaInicioExp.getTime()));
			experiencia.setExpFechaFin(new Timestamp(fechaFinExp.getTime()));
			candidatosService.agregarExperiencia(experiencia);
			resetExperiencia();
			//getListExperiencia();
			JsfUtil.addInfoMessage("Agregado Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

//	public void onRowDelExperiencia(ExperienciaListDTO exp)
//	{
//		try {
//			experiencia=new ExperienciaDTO();
//			experiencia.setExpCodigo(exp.getExpCodigo());
//			candidatosService.eliminarExperiencia(experiencia);
//			experiencia=new ExperienciaDTO();
//			getListExperiencia();
//			JsfUtil.addInfoMessage("Eliminado Exitosamente");
//		} catch (SilsagException e) {
//			JsfUtil.addErrorMessage(e.getMessage());
//		}
//		catch (Exception e) {
//			JsfUtil.addErrorMessage(e.getMessage());
//		}
//	}
	
	private void resetExperiencia()
	{
		setTipoExperiencia(null);
		experiencia=new ExperienciaDTO();
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
		} catch (SilsagException e) {
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
