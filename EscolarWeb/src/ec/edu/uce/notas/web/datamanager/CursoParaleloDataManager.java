package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.vo.CursoVO;

@ViewScoped
@ManagedBean(name = "cursoParaleloDataManager")
public class CursoParaleloDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CursoVO cursoParalelo; 
	
	private List<CursoVO> cursoParaleloList;
	
	private List<CursoDTO> cursoList; 
	
	private List<ParaleloDTO> paraleloList;

	public CursoParaleloDataManager() {
		cursoParalelo=new CursoVO();
		cursoParaleloList=new ArrayList<CursoVO>();
		cursoList=new ArrayList<CursoDTO>();
		paraleloList=new ArrayList<ParaleloDTO>();
	}

	
	
	
	public CursoVO getCursoParalelo() {
		return cursoParalelo;
	}


	public void setCursoParalelo(CursoVO cursoParalelo) {
		this.cursoParalelo = cursoParalelo;
	}




	public List<CursoVO> getCursoParaleloList() {
		return cursoParaleloList;
	}

	public void setCursoParaleloList(List<CursoVO> cursoParaleloList) {
		this.cursoParaleloList = cursoParaleloList;
	}

	public List<CursoDTO> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<CursoDTO> cursoList) {
		this.cursoList = cursoList;
	}

	public List<ParaleloDTO> getParaleloList() {
		return paraleloList;
	}

	public void setParaleloList(List<ParaleloDTO> paraleloList) {
		this.paraleloList = paraleloList;
	}

	
}
