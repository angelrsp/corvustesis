package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.web.datamanager.CandidatoDataManager;

@ViewScoped
@ManagedBean(name = "candidatoController")
public class CandidatoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{candidatoDataManager}")
	private CandidatoDataManager candidatoDataManager;
	
	public CandidatoDataManager getCandidatoDataManager() {
		return candidatoDataManager;
	}
	public void setCandidatoDataManager(CandidatoDataManager candidatoDataManager) {
		this.candidatoDataManager = candidatoDataManager;
	}
	
	/*public List<EstudioListDTO> getListEstudio() {
		try {
			this.listEstudio=candidatosService.obtenerEstudio(getCandidato());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		return this.listEstudio;
	}
	
	public List<ExperienciaListDTO> getExperienciaList() {
		try {
			this.experienciaList=candidatosService.obtenerExperiencia(candidato);
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return this.experienciaList;
	}
	
	public List<ReferenciaDTO> getListReferencia() throws SilsagException {
		listReferencia=candidatosService.obtenerReferencia(candidato);
		return listReferencia;
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
	
	*/
	
	

}
