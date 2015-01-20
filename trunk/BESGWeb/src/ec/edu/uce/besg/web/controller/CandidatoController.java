package ec.edu.uce.besg.web.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections.CollectionUtils;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadListDTO;
import ec.edu.uce.besg.ejb.service.ServicioCandidato;
import ec.edu.uce.besg.ejb.service.ServicioCatalogo;
import ec.edu.uce.besg.web.datamanager.CandidatoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "candidatoController")
public class CandidatoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{candidatoDataManager}")
	private CandidatoDataManager candidatoDataManager;
	
	
	@EJB
	private ServicioCandidato servicioCandidato;

	@EJB
	private ServicioCatalogo servicioCatalogo;
	
	
	public CandidatoDataManager getCandidatoDataManager() {
		return candidatoDataManager;
	}
	public void setCandidatoDataManager(CandidatoDataManager candidatoDataManager) {
		this.candidatoDataManager = candidatoDataManager;
	}
	
	
	@PostConstruct
	private void init()
	{
		buscarEstadoCivil();
		buscarSexo();
		buscarTipoDocumento();
		readCandidato();
		buscarPais();
		buscarNivelEstudio();
	}
	
	
	
	public void actualizar()
	{
		CandidatoDTO candidato;
		//UsuarioDTO user;
		try {
			//user=new UsuarioDTO();
			candidato=new CandidatoDTO();
			//candidato.setCanUsuario(user.getUsuCodigo());
			candidato.setCanFechaNacimiento(new Timestamp(candidatoDataManager.getFechaNac().getTime()));
			//candidato.setCanFoto(uploadedFile.getContents());
			candidato.setCanEstadoCivil(candidatoDataManager.getCodigoEstadoCivil());
			candidato.setCanSexo(candidatoDataManager.getCodigoSexo());
			servicioCandidato.registrarCandidato(candidato);
			JsfUtil.addInfoMessage("Datos Actualizados Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscarEstadoCivil() {
		try {
			this.candidatoDataManager.setEstadoCivilCatalogoList(servicioCatalogo.readEstadoCivil());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscarTipoDocumento() {
		try {
			this.candidatoDataManager.setTipoDocumentoCatalogoList(servicioCatalogo.readTipoDocumento());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void buscarSexo() {
		try {
			this.candidatoDataManager.setSexoCatalogoList(servicioCatalogo.readSexo());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	
	public void buscarNivelEstudio() {
		try {
			this.candidatoDataManager.setNivelEstudioCatalogoList(servicioCatalogo.readNivelEstudio());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscarPais() {
		try{
			this.candidatoDataManager.setPaisCatalogoList(servicioCatalogo.readPais());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	private void readCandidato()
	{
		List<CandidatoDTO> listaCandidatos=null;
		try {
			//ojo se manda de parametro new candidatoDto pero deberia mandar el usuario logeada
			listaCandidatos = this.servicioCandidato.obtenerCandidato(new CandidatoDTO());
			if (CollectionUtils.isEmpty(listaCandidatos) && listaCandidatos.size()==0) {
				JsfUtil.addInfoMessage("Busqueda vacia");
			} else {
				this.candidatoDataManager.setCandidatoInsertar(listaCandidatos.get(0));
				buscarEstadoCivil();
				this.candidatoDataManager.setCodigoEstadoCivil(listaCandidatos.get(0).getCanEstadoCivil());
				buscarSexo();
				this.candidatoDataManager.setCodigoSexo(listaCandidatos.get(0).getCanSexo());
				buscarTipoDocumento();
				this.candidatoDataManager.setCodigotipo(listaCandidatos.get(0).getCanTipoIdentificacion());
			}
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void agregarEstudio()
	{
		try {
			if(candidatoDataManager.getCodigoNivEst()!=0)
			{	
				candidatoDataManager.getEstudioInsertar().setBemCandidato(candidatoDataManager.getCandidatoInsertar());
				candidatoDataManager.getEstudioInsertar().setHabNivel(candidatoDataManager.getCodigoNivEst());
				candidatoDataManager.getEstudioInsertar().setHabEspecialidad(candidatoDataManager.getCodigoEspecialidad());
				candidatoDataManager.getEstudioInsertar().setHabPais(candidatoDataManager.getCodigoPais());
				candidatoDataManager.getEstudioInsertar().setHabFechaFin(new Timestamp(candidatoDataManager.getFechaFin().getTime()));
				candidatoDataManager.getEstudioInsertar().setHabFechaInicio(new Timestamp(candidatoDataManager.getFechaInicio().getTime()));
				servicioCandidato.agregarHabilidad(candidatoDataManager.getEstudioInsertar());
				buscarEstudio();
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
	
	public void onRowDelEstudio(HabilidadListDTO est)
	{
		HabilidadDTO habilidadDTO;
		CandidatoDTO candidatoDTO;
		try {
			candidatoDTO=new CandidatoDTO();
			habilidadDTO=new HabilidadDTO();
			habilidadDTO.setHabCodigo(est.getHabCodigo());
			candidatoDTO.setCanCodigo(est.getCanCodigo());
			habilidadDTO.setHabEspecialidad(est.getHabEspecialidad());
			habilidadDTO.setHabNivel(est.getHabNivel());
			habilidadDTO.setHabPais(est.getHabPais());
			habilidadDTO.setBemCandidato(candidatoDTO);
			servicioCandidato.eliminarHabilidad(habilidadDTO);
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void resetEstudio()
	{
		candidatoDataManager.setEstudioInsertar(new HabilidadDTO());
		candidatoDataManager.setCodigoEspecialidad(0);
		candidatoDataManager.setCodigoNivEst(0);
		candidatoDataManager.setCodigoPais(0);
		candidatoDataManager.setCodigotipo(0);
	}
	
	public void buscarEstudio() {
		List<HabilidadListDTO> listaHabilidad = null;
		try {
			listaHabilidad = this.servicioCandidato.obtenerHabilidad(new HabilidadListDTO());
			if (CollectionUtils.isEmpty(listaHabilidad) && listaHabilidad.size() == 0) {
				JsfUtil.addWarningMessage("Busqueda vacia");
			} else {
				this.candidatoDataManager.setEstudioDtos(listaHabilidad);
			}
		} catch (CorvustecException e) {
			//slf4jLogger.info("Error al buscarCatalogo {} ", e);
			JsfUtil.addErrorMessage(e.getMessage());
		}
	} 

	
	/*public void agregarExperiencia()
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
			//candidato.setBemUsuario(user);
			candidato.setCanFechaNacimiento(new Timestamp(fechaNacimiento.getTime()));
			//candidato.setCanFoto(uploadedFile.getContents());
			candidato.setCanEstadoCivil(Integer.valueOf(estadoCivil.toString()));
			candidato.setCanSexo(Integer.valueOf(genero.toString()));
			candidato.setCanFechaUltima(new Timestamp(new Date().getTime()));
			candidatosService.actualizarCandidato(candidato);
			JsfUtil.addInfoMessage("Datos Actualizados Exitosamente");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {  
		//logger.info("Entro imagen");      
		candidatoDataManager.getCandidatoInsertar().setCanFoto(event.getFile().getContents());
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
	}/*	
	
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
