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
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AlumnoVO;

@ViewScoped
@ManagedBean(name = "estudianteCursoDataManager")
public class EstudianteCursoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AlumnoVO estudianteCurso;
	
	private List<AlumnoVO> estudianteCursoList;
	private List<PeriodoDTO> periodoList;
	private List<CursoDTO> cursoList;
	private List<ParaleloDTO> paraleloList;
	private List<AlumnoViewDTO> estudianteList;
	private List<MateriaDTO> materiaList;
	private boolean isSave=false;
	
	public EstudianteCursoDataManager() {
		estudianteCurso=new AlumnoVO();
		estudianteCursoList=new ArrayList<AlumnoVO>();
		periodoList=new ArrayList<PeriodoDTO>();
		cursoList=new ArrayList<CursoDTO>();
		paraleloList=new ArrayList<ParaleloDTO>();
		estudianteList=new ArrayList<AlumnoViewDTO>();
		materiaList=new ArrayList<MateriaDTO>();
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




	public AlumnoVO getEstudianteCurso() {
		return estudianteCurso;
	}




	public void setEstudianteCurso(AlumnoVO estudianteCurso) {
		this.estudianteCurso = estudianteCurso;
	}




	public List<AlumnoVO> getEstudianteCursoList() {
		return estudianteCursoList;
	}




	public void setEstudianteCursoList(List<AlumnoVO> estudianteCursoList) {
		this.estudianteCursoList = estudianteCursoList;
	}




	public List<AlumnoViewDTO> getEstudianteList() {
		return estudianteList;
	}




	public void setEstudianteList(List<AlumnoViewDTO> estudianteList) {
		this.estudianteList = estudianteList;
	}

	
	
}
