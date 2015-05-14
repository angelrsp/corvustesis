package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
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
	private Integer encuestaCode;
	
	public ReporteRespuestaDataManager() {
		resultadoViewList=new ArrayList<ResultadoViewDTO>();
		encuestaList=new ArrayList<EncuestaDTO>();
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

	public Integer getEncuestaCode() {
		return encuestaCode;
	}

	public void setEncuestaCode(Integer encuestaCode) {
		this.encuestaCode = encuestaCode;
	}
	
}
