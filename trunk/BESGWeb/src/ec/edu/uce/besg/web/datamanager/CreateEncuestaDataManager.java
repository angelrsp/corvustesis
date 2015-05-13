package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ControlDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;

@ViewScoped
@ManagedBean(name = "createEncuestaDataManager")
public class CreateEncuestaDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EncuestaDTO encuestaDTO;
	private List<EncuestaDTO> encuestaList;
	
	private CategoriaDTO categoriaDTO;
	private List<CategoriaDTO> categoriaList;
	
	private PreguntaDTO preguntaDTO;
	private List<PreguntaDTO> preguntaList;

	private RespuestaDTO respuestaDTO;
	private List<RespuestaDTO> respuestaList;

	private List<ControlDTO> controlList;
	
	private Integer controlCode;
	
	public CreateEncuestaDataManager() {
		encuestaDTO=new EncuestaDTO();
		encuestaList=new ArrayList<EncuestaDTO>();
		
		categoriaDTO=new CategoriaDTO();
		categoriaList=new ArrayList<CategoriaDTO>();
		
		preguntaDTO=new PreguntaDTO();
		preguntaList=new ArrayList<PreguntaDTO>();
		
		respuestaDTO=new RespuestaDTO();
		respuestaList=new ArrayList<RespuestaDTO>();
		
		controlList=new ArrayList<ControlDTO>();
	}


	public EncuestaDTO getEncuestaDTO() {
		return encuestaDTO;
	}


	public void setEncuestaDTO(EncuestaDTO encuestaDTO) {
		this.encuestaDTO = encuestaDTO;
	}


	public List<EncuestaDTO> getEncuestaList() {
		return encuestaList;
	}


	public void setEncuestaList(List<EncuestaDTO> encuestaList) {
		this.encuestaList = encuestaList;
	}


	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}


	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}


	public List<CategoriaDTO> getCategoriaList() {
		return categoriaList;
	}


	public void setCategoriaList(List<CategoriaDTO> categoriaList) {
		this.categoriaList = categoriaList;
	}


	public PreguntaDTO getPreguntaDTO() {
		return preguntaDTO;
	}


	public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
		this.preguntaDTO = preguntaDTO;
	}


	public List<PreguntaDTO> getPreguntaList() {
		return preguntaList;
	}


	public void setPreguntaList(List<PreguntaDTO> preguntaList) {
		this.preguntaList = preguntaList;
	}


	public RespuestaDTO getRespuestaDTO() {
		return respuestaDTO;
	}


	public void setRespuestaDTO(RespuestaDTO respuestaDTO) {
		this.respuestaDTO = respuestaDTO;
	}


	public List<RespuestaDTO> getRespuestaList() {
		return respuestaList;
	}


	public void setRespuestaList(List<RespuestaDTO> respuestaList) {
		this.respuestaList = respuestaList;
	}


	public List<ControlDTO> getControlList() {
		return controlList;
	}


	public void setControlList(List<ControlDTO> controlList) {
		this.controlList = controlList;
	}


	public Integer getControlCode() {
		return controlCode;
	}


	public void setControlCode(Integer controlCode) {
		this.controlCode = controlCode;
	}
	
	
}
