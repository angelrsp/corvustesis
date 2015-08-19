package ec.edu.uce.notas.ejb.persistence.vo;

import java.io.Serializable;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;

public class CursoVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CursoDTO cursoDTO;
	private ParaleloDTO paraleloDTO;
	
	public CursoVO() {
		cursoDTO=new CursoDTO();
		paraleloDTO=new ParaleloDTO();
	}

	public CursoDTO getCursoDTO() {
		return cursoDTO;
	}

	public void setCursoDTO(CursoDTO cursoDTO) {
		this.cursoDTO = cursoDTO;
	}

	public ParaleloDTO getParaleloDTO() {
		return paraleloDTO;
	}

	public void setParaleloDTO(ParaleloDTO paraleloDTO) {
		this.paraleloDTO = paraleloDTO;
	}

}
