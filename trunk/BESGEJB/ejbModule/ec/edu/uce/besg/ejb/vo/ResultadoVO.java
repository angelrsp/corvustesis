package ec.edu.uce.besg.ejb.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;

public class ResultadoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ResultadoDTO> resultadoList;
	private List<Integer> codeRadioList;
			
	public ResultadoVO() {
		resultadoList=new ArrayList<ResultadoDTO>();
		codeRadioList=new ArrayList<Integer>();
	}

	public List<ResultadoDTO> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<ResultadoDTO> resultadoList) {
		this.resultadoList = resultadoList;
	}

	public List<Integer> getCodeRadioList() {
		return codeRadioList;
	}

	public void setCodeRadioList(List<Integer> codeRadioList) {
		this.codeRadioList = codeRadioList;
	}
	
	
	
}
