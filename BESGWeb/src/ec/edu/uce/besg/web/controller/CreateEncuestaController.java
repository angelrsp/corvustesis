package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ControlDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.service.CuestionarioService;
import ec.edu.uce.besg.web.datamanager.CreateEncuestaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "createEncuestaController")
public class CreateEncuestaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CuestionarioService cuestionarioService;
	
	@ManagedProperty(value="#{createEncuestaDataManager}")
	private CreateEncuestaDataManager createEncuestaDataManager;

	
	public CreateEncuestaController() {
		
	}


	public CreateEncuestaDataManager getCreateEncuestaDataManager() {
		return createEncuestaDataManager;
	}

	public void setCreateEncuestaDataManager(
			CreateEncuestaDataManager createEncuestaDataManager) {
		this.createEncuestaDataManager = createEncuestaDataManager;
	}
	
	@PostConstruct
	private void init()
	{
		readEncuesta();
		readControl();
	}
	
	private void readEncuesta()
	{
		try {
			createEncuestaDataManager.setEncuestaList(cuestionarioService.readEncuesta(new EncuestaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readCategoria()
	{
		CategoriaDTO categoriaDTO;
		try {
			categoriaDTO=new CategoriaDTO();
			categoriaDTO.setCueEncuesta(createEncuestaDataManager.getEncuestaDTO());
			createEncuestaDataManager.setCategoriaList(cuestionarioService.readCategoria(categoriaDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readPregunta()
	{
		PreguntaDTO preguntaDTO;
		try {
			preguntaDTO=new PreguntaDTO();
			preguntaDTO.setCueCategoria(createEncuestaDataManager.getCategoriaDTO());;
			createEncuestaDataManager.setPreguntaList(cuestionarioService.readPregunta(preguntaDTO));;
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readRespuesta()
	{
		RespuestaDTO respuestaDTO;
		try {
			respuestaDTO=new RespuestaDTO();
			respuestaDTO.setCuePregunta(createEncuestaDataManager.getPreguntaDTO());
			createEncuestaDataManager.setRespuestaList(cuestionarioService.readRespuesta(respuestaDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readControl()
	{
		try {
			createEncuestaDataManager.setControlList(cuestionarioService.readControl(new ControlDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onClickSave()
	{
		try {
			cuestionarioService.createOrUpdateEncuesta(createEncuestaDataManager.getEncuestaDTO());
			readEncuesta();
			createEncuestaDataManager.setEncuestaDTO(new EncuestaDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onClickSaveCategoria()
	{
		try {
			createEncuestaDataManager.getCategoriaDTO().setCueEncuesta(createEncuestaDataManager.getEncuestaDTO());
			cuestionarioService.createOrUpdateCategoria(createEncuestaDataManager.getCategoriaDTO());
			readCategoria();
			createEncuestaDataManager.setCategoriaDTO(new CategoriaDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onClickSavePregunta()
	{
		ControlDTO controlDTO;
		try {
			controlDTO=new ControlDTO();
			controlDTO.setConCodigo(createEncuestaDataManager.getControlCode());
			createEncuestaDataManager.getPreguntaDTO().setCueControl(controlDTO);
			createEncuestaDataManager.getCategoriaDTO().setCueEncuesta(createEncuestaDataManager.getEncuestaDTO());
			createEncuestaDataManager.getPreguntaDTO().setCueCategoria(createEncuestaDataManager.getCategoriaDTO());
			cuestionarioService.createOrUpdatePregunta(createEncuestaDataManager.getPreguntaDTO());
			readPregunta();
			createEncuestaDataManager.setPreguntaDTO(new PreguntaDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onClickSaveRespuesta()
	{
		try {
			createEncuestaDataManager.getRespuestaDTO().setCuePregunta(createEncuestaDataManager.getPreguntaDTO());
			cuestionarioService.createOrUpdateRespuesta(createEncuestaDataManager.getRespuestaDTO());
			readRespuesta();
			createEncuestaDataManager.setRespuestaDTO(new RespuestaDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void onClickEdit(EncuestaDTO encuestaDTO)
	{
		createEncuestaDataManager.setEncuestaDTO(encuestaDTO);
	}
	
	public void onClickEditCategoria(CategoriaDTO categoriaDTO)
	{
		createEncuestaDataManager.setCategoriaDTO(categoriaDTO);
	}
	
	public void onClickEditPregunta(PreguntaDTO preguntaDTO)
	{
		createEncuestaDataManager.setPreguntaDTO(preguntaDTO);
		createEncuestaDataManager.setControlCode(preguntaDTO.getCueControl().getConCodigo());
	}

	public void onClickEditRespuesta(RespuestaDTO respuestaDTO)
	{
		createEncuestaDataManager.setRespuestaDTO(respuestaDTO);
	}
	
	
	public void onClickViewCategoria(EncuestaDTO encuestaDTO)
	{
		createEncuestaDataManager.setEncuestaDTO(encuestaDTO);
		readCategoria();
		RequestContext.getCurrentInstance().execute("PF('dlgCategoria').show();");
	}
	
	public void onClickViewRespuesta(PreguntaDTO preguntaDTO)
	{
		createEncuestaDataManager.setPreguntaDTO(preguntaDTO);
		readRespuesta();
		RequestContext.getCurrentInstance().execute("PF('dlgRespuesta').show();");
	}
	
	public void onClickViewPreguntas(CategoriaDTO categoriaDTO)
	{
		createEncuestaDataManager.setCategoriaDTO(categoriaDTO);
		readPregunta();
		RequestContext.getCurrentInstance().execute("PF('dlgPreguntas').show();");
	}
	
	
	public void onCloseCategoria()
	{
		createEncuestaDataManager.setEncuestaDTO(new EncuestaDTO());
	}
	
	public void onClosePregunta()
	{
		createEncuestaDataManager.setCategoriaDTO(new CategoriaDTO());
	}

	public void onCloseRespuesta()
	{
		createEncuestaDataManager.setPreguntaDTO(new PreguntaDTO());
	}

	
}

