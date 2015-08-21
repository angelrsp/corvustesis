package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.DocenteVO;

@ViewScoped
@ManagedBean(name = "materiaCursoDataManager")
public class MateriaCursoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DocenteVO materiaCurso;
	
	private List<DocenteVO> materiaCursoList;
	private List<PeriodoDTO> periodoList;
	private List<CursoDTO> cursoList;
	private List<ParaleloDTO> paraleloList;
	private List<DocenteViewDTO> docenteList;
	private List<MateriaDTO> materiaList;
	private boolean isSave=false;
	
	public MateriaCursoDataManager() {
		materiaCurso=new DocenteVO();
		materiaCursoList=new ArrayList<DocenteVO>();
		periodoList=new ArrayList<PeriodoDTO>();
		cursoList=new ArrayList<CursoDTO>();
		paraleloList=new ArrayList<ParaleloDTO>();
		docenteList=new ArrayList<DocenteViewDTO>();
		materiaList=new ArrayList<MateriaDTO>();
	}


	public DocenteVO getMateriaCurso() {
		return materiaCurso;
	}


	public void setMateriaCurso(DocenteVO materiaCurso) {
		this.materiaCurso = materiaCurso;
	}


	public List<DocenteVO> getMateriaCursoList() {
		return materiaCursoList;
	}


	public void setMateriaCursoList(List<DocenteVO> materiaCursoList) {
		this.materiaCursoList = materiaCursoList;
	}


	public List<PeriodoDTO> getPeriodoList() {
		return periodoList;
	}


	public void setPeriodoList(List<PeriodoDTO> periodoList) {
		this.periodoList = periodoList;
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


	


	public List<DocenteViewDTO> getDocenteList() {
		return docenteList;
	}


	public void setDocenteList(List<DocenteViewDTO> docenteList) {
		this.docenteList = docenteList;
	}


	public List<MateriaDTO> getMateriaList() {
		return materiaList;
	}


	public void setMateriaList(List<MateriaDTO> materiaList) {
		this.materiaList = materiaList;
	}


	public boolean getIsSave() {
		return isSave;
	}


	public void setIsSave(boolean isSave) {
		this.isSave = isSave;
	}

	
	
}
