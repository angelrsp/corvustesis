package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;

@SessionScoped
@ManagedBean(name = "encuestaDataManager")
public class EncuestaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ResultadoDTO> resultadoList;
	
	
	public EncuestaDataManager() {
		resultadoList=new ArrayList<ResultadoDTO>();
		
	}

	public List<ResultadoDTO> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<ResultadoDTO> resultadoList) {
		this.resultadoList = resultadoList;
	}
	
}
