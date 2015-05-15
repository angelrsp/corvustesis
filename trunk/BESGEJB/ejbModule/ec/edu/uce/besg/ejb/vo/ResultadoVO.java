package ec.edu.uce.besg.ejb.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;

public class ResultadoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ResultadoDTO> resultadoList;
	private String[] checkBoxCode;
	private PreguntaDTO preguntaDTO;
	private ResultadoDTO resultadoDTO;
	private CandidatoDTO candidatoDTO;
	private RespuestaDTO respuestaDTO;
			
	public ResultadoVO() {
		resultadoList=new ArrayList<ResultadoDTO>();
		preguntaDTO=new PreguntaDTO();
		resultadoDTO=new ResultadoDTO();
		candidatoDTO=new CandidatoDTO();
		respuestaDTO=new RespuestaDTO();
	}

	public List<ResultadoDTO> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<ResultadoDTO> resultadoList) {
		this.resultadoList = resultadoList;
	}

	public String[] getCheckBoxCode() {
		return checkBoxCode;
	}

	public void setCheckBoxCode(String[] checkBoxCode) {
		this.checkBoxCode = checkBoxCode;
	}

	public PreguntaDTO getPreguntaDTO() {
		return preguntaDTO;
	}

	public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
		this.preguntaDTO = preguntaDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}

	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}

	public RespuestaDTO getRespuestaDTO() {
		return respuestaDTO;
	}

	public void setRespuestaDTO(RespuestaDTO respuestaDTO) {
		this.respuestaDTO = respuestaDTO;
	}

	
	
}
