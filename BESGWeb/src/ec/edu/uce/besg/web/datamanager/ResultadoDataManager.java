package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;

@ViewScoped
@ManagedBean(name = "resultadoDataManager")
public class ResultadoDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<EncuestaDTO> encuestaList;
	private Integer encuestaCode;
	
	private List<ResultadoViewDTO> resultadoViewList;
	
	public ResultadoDataManager() {
		encuestaList=new ArrayList<EncuestaDTO>();
		resultadoViewList=new ArrayList<ResultadoViewDTO>();
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

	public List<ResultadoViewDTO> getResultadoViewList() {
		return resultadoViewList;
	}

	public void setResultadoViewList(List<ResultadoViewDTO> resultadoViewList) {
		this.resultadoViewList = resultadoViewList;
	}
	
}
