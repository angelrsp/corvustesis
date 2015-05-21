package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import ec.edu.uce.besg.common.util.Const;
import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.persistence.entity.TipoHabilidadDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.HabilidadViewDTO;
import ec.edu.uce.besg.ejb.service.CandidatoService;
import ec.edu.uce.besg.ejb.service.CatalogoService;
import ec.edu.uce.besg.ejb.service.CuestionarioService;
import ec.edu.uce.besg.web.datamanager.HojaVidaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;


@ViewScoped
@ManagedBean(name = "hojaVidaController")
public class HojaVidaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CuestionarioService cuestionarioService;
	
	@EJB
	private CatalogoService catalogoService;

	@EJB
	private CandidatoService candidatoService;

	
	@ManagedProperty(value="#{hojaVidaDataManager}")
	private HojaVidaDataManager hojaVidaDataManager;
	
	
	public HojaVidaController() {
		//verificarEncuesta();	
	}

	
	public HojaVidaDataManager getHojaVidaDataManager() {
		return hojaVidaDataManager;
	}
	public void setHojaVidaDataManager(HojaVidaDataManager hojaVidaDataManager) {
		this.hojaVidaDataManager = hojaVidaDataManager;
	}


	@PostConstruct
	private void init()
	{
		readCandidato();
		readIdentificationType();
		readEstadoCivil();
		readGenero();
		readNivelEstudio();
		readPais();
		readFormacionAcademica();
		readCurso();
		readAdicional();
		readIdioma();
		readIdiomaCatalogo();
		readNivelIdioma();
	}
	
	private void readCandidato()
	{
		try {
			hojaVidaDataManager.setUsuarioDTO((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			hojaVidaDataManager.getCandidatoDTO().setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			hojaVidaDataManager.setCandidatoDTO(candidatoService.readCandidato(hojaVidaDataManager.getCandidatoDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void readIdentificationType() {
		try {
			hojaVidaDataManager.setTipoDocumentoList(catalogoService.readIdentificationType());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readEstadoCivil() {
		try {
			hojaVidaDataManager.setEstadoCivilList(catalogoService.readEstadoCivil());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readGenero() {
		try {
			hojaVidaDataManager.setGeneroList(catalogoService.readSex());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readNivelEstudio() {
		try {
			hojaVidaDataManager.setNivelEstudioList(catalogoService.readNivelEstudio());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readPais() {
		try {
			hojaVidaDataManager.setPaisList(catalogoService.readPais());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readIdiomaCatalogo() {
		try {
			hojaVidaDataManager.setIdiomaCatalogoList(catalogoService.readIdioma());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readNivelIdioma() {
		try {
			hojaVidaDataManager.setNivelIdiomaList(catalogoService.readNivelIdioma());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	private void readFormacionAcademica()
	{
		HabilidadViewDTO habilidadViewDTO;
		try {
			habilidadViewDTO=new HabilidadViewDTO();
			habilidadViewDTO.setHabTipo(Const.FORMACION_ACADEMICA);
			habilidadViewDTO.setCanCodigo(hojaVidaDataManager.getCandidatoDTO().getCanCodigo());
			hojaVidaDataManager.setFormacionAcademicaList(candidatoService.readHabilidadView(habilidadViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readCurso()
	{
		HabilidadViewDTO habilidadViewDTO;
		try {
			habilidadViewDTO=new HabilidadViewDTO();
			habilidadViewDTO.setHabTipo(Const.CURSO);
			habilidadViewDTO.setCanCodigo(hojaVidaDataManager.getCandidatoDTO().getCanCodigo());
			hojaVidaDataManager.setCursoList(candidatoService.readHabilidadView(habilidadViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void readAdicional()
	{
		HabilidadViewDTO habilidadViewDTO;
		try {
			habilidadViewDTO=new HabilidadViewDTO();
			habilidadViewDTO.setHabTipo(Const.ADICIONAL);
			habilidadViewDTO.setCanCodigo(hojaVidaDataManager.getCandidatoDTO().getCanCodigo());
			hojaVidaDataManager.setAdicionalList(candidatoService.readHabilidadView(habilidadViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private void readIdioma()
	{
		HabilidadViewDTO habilidadViewDTO;
		try {
			habilidadViewDTO=new HabilidadViewDTO();
			habilidadViewDTO.setHabTipo(Const.IDIOMA);
			habilidadViewDTO.setCanCodigo(hojaVidaDataManager.getCandidatoDTO().getCanCodigo());
			hojaVidaDataManager.setIdiomaList(candidatoService.readHabilidadView(habilidadViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public void handleFileUpload(FileUploadEvent event) {
		hojaVidaDataManager.getCandidatoDTO().setCanFoto(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), JsfUtil.getRandomName(event.getFile().getFileName().split("\\.")[1])));
		hojaVidaDataManager.getCandidatoDTO().setCanFotoByte(event.getFile().getContents());
    }
	
	
	public void onClickSaveFormacionAcademica()
	{
		TipoHabilidadDTO tipoHabilidadDTO;
		try {
			tipoHabilidadDTO=new TipoHabilidadDTO();
			tipoHabilidadDTO.setThaCodigo(Const.FORMACION_ACADEMICA);
			hojaVidaDataManager.getFormacionAcademicaDTO().setBemTipoHabilidad(tipoHabilidadDTO);		
			hojaVidaDataManager.getFormacionAcademicaDTO().setBemCandidato(hojaVidaDataManager.getCandidatoDTO());
			candidatoService.createOrUpdateHabilidad(hojaVidaDataManager.getFormacionAcademicaDTO());
			readFormacionAcademica();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		finally{
			tipoHabilidadDTO=null;
		}
	}

	public void onClickSaveCurso()
	{
		TipoHabilidadDTO tipoHabilidadDTO;
		try {
			tipoHabilidadDTO=new TipoHabilidadDTO();
			tipoHabilidadDTO.setThaCodigo(Const.CURSO);
			hojaVidaDataManager.getCursoDTO().setBemTipoHabilidad(tipoHabilidadDTO);		
			hojaVidaDataManager.getCursoDTO().setBemCandidato(hojaVidaDataManager.getCandidatoDTO());
			candidatoService.createOrUpdateHabilidad(hojaVidaDataManager.getCursoDTO());
			readCurso();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		finally{
			tipoHabilidadDTO=null;
		}
	}
	
	public void onClickSaveIdioma()
	{
		TipoHabilidadDTO tipoHabilidadDTO;
		try {
			tipoHabilidadDTO=new TipoHabilidadDTO();
			tipoHabilidadDTO.setThaCodigo(Const.IDIOMA);
			hojaVidaDataManager.getIdiomaDTO().setBemTipoHabilidad(tipoHabilidadDTO);		
			hojaVidaDataManager.getIdiomaDTO().setBemCandidato(hojaVidaDataManager.getCandidatoDTO());
			candidatoService.createOrUpdateHabilidad(hojaVidaDataManager.getIdiomaDTO());
			readIdioma();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		finally{
			tipoHabilidadDTO=null;
		}
	}

	public void onClickSaveAdicional()
	{
		TipoHabilidadDTO tipoHabilidadDTO;
		try {
			tipoHabilidadDTO=new TipoHabilidadDTO();
			tipoHabilidadDTO.setThaCodigo(Const.ADICIONAL);
			hojaVidaDataManager.getAdicionalDTO().setBemTipoHabilidad(tipoHabilidadDTO);		
			hojaVidaDataManager.getAdicionalDTO().setBemCandidato(hojaVidaDataManager.getCandidatoDTO());
			candidatoService.createOrUpdateHabilidad(hojaVidaDataManager.getAdicionalDTO());
			readAdicional();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		finally{
			tipoHabilidadDTO=null;
		}
	}


	public void onClickUpdate()
	{
		try {
			hojaVidaDataManager.setCandidatoDTO(candidatoService.updateCandidato(hojaVidaDataManager.getCandidatoDTO()));
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void onRowDeleteEstudio(HabilidadViewDTO habilidadViewDTO)
	{
		HabilidadDTO habilidadDTO;
		try {
			habilidadDTO=new HabilidadDTO();
			habilidadDTO.setHabCodigo(habilidadViewDTO.getHabCodigo());
			candidatoService.removeHabilidad(habilidadDTO);
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
			readFormacionAcademica();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void onRowDeleteCurso(HabilidadViewDTO habilidadViewDTO)
	{
		HabilidadDTO habilidadDTO;
		try {
			habilidadDTO=new HabilidadDTO();
			habilidadDTO.setHabCodigo(habilidadViewDTO.getHabCodigo());
			candidatoService.removeHabilidad(habilidadDTO);
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
			readCurso();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void onRowDeleteAdicional(HabilidadViewDTO habilidadViewDTO)
	{
		HabilidadDTO habilidadDTO;
		try {
			habilidadDTO=new HabilidadDTO();
			habilidadDTO.setHabCodigo(habilidadViewDTO.getHabCodigo());
			candidatoService.removeHabilidad(habilidadDTO);
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
			readAdicional();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public void onRowDeleteIdioma(HabilidadViewDTO habilidadViewDTO)
	{
		HabilidadDTO habilidadDTO;
		try {
			habilidadDTO=new HabilidadDTO();
			habilidadDTO.setHabCodigo(habilidadViewDTO.getHabCodigo());
			candidatoService.removeHabilidad(habilidadDTO);
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
			readIdioma();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
}
