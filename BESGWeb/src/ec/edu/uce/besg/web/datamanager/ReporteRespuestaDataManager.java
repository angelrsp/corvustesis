package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;

@ViewScoped
@ManagedBean(name = "reporteRespuestaDataManager")
public class ReporteRespuestaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ResultadoViewDTO> resultadoViewList;
	
	private List<EncuestaDTO> encuestaList;
	private EncuestaDTO encuestaDTO;

	private List<CategoriaDTO> categoriaList;
	private CategoriaDTO categoriaDTO;

	private List<PreguntaDTO> preguntaList;
	private PreguntaDTO preguntaDTO;

	private Boolean visibleDataTable;
	private Boolean visibleCharts;
	
	private List<ResultadoViewDTO> resultadoList;
	
	public ReporteRespuestaDataManager() {
		
		resultadoViewList=new ArrayList<ResultadoViewDTO>();
		
		encuestaList=new ArrayList<EncuestaDTO>();
		encuestaDTO=new EncuestaDTO();
		
		categoriaList=new ArrayList<CategoriaDTO>();
		categoriaDTO=new CategoriaDTO();
		
		preguntaList=new ArrayList<PreguntaDTO>();
		preguntaDTO=new PreguntaDTO();
		
		resultadoList=new ArrayList<ResultadoViewDTO>();
	}

	public List<ResultadoViewDTO> getResultadoViewList() {
		return resultadoViewList;
	}

	public void setResultadoViewList(List<ResultadoViewDTO> resultadoViewList) {
		this.resultadoViewList = resultadoViewList;
	}

	public List<EncuestaDTO> getEncuestaList() {
		return encuestaList;
	}

	public void setEncuestaList(List<EncuestaDTO> encuestaList) {
		this.encuestaList = encuestaList;
	}

	public EncuestaDTO getEncuestaDTO() {
		return encuestaDTO;
	}

	public void setEncuestaDTO(EncuestaDTO encuestaDTO) {
		this.encuestaDTO = encuestaDTO;
	}

	public List<CategoriaDTO> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<CategoriaDTO> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	public List<PreguntaDTO> getPreguntaList() {
		return preguntaList;
	}

	public void setPreguntaList(List<PreguntaDTO> preguntaList) {
		this.preguntaList = preguntaList;
	}

	public PreguntaDTO getPreguntaDTO() {
		return preguntaDTO;
	}

	public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
		this.preguntaDTO = preguntaDTO;
	}

	public List<ResultadoViewDTO> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<ResultadoViewDTO> resultadoList) {
		this.resultadoList = resultadoList;
	}

	public Boolean getVisibleDataTable() {
		return visibleDataTable;
	}

	public void setVisibleDataTable(Boolean visibleDataTable) {
		this.visibleDataTable = visibleDataTable;
	}

	public Boolean getVisibleCharts() {
		return visibleCharts;
	}

	public void setVisibleCharts(Boolean visibleCharts) {
		this.visibleCharts = visibleCharts;
	}
	
}
