package ec.edu.uce.notas.ejb.persistence.vo;

import java.io.Serializable;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.DocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;

public class DocenteVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private DocenteDTO docenteDTO;
	private DocenteViewDTO docenteViewDTO;
	private UsuarioDTO usuarioDTO;
	private PeriodoDTO periodoDTO;
	private CursoDTO cursoDTO;
	private ParaleloDTO paraleloDTO;
	private MateriaDTO materiaDTO;
	private MateriaDocenteDTO materiaDocenteDTO;
	
	public DocenteVO() {
		docenteDTO=new DocenteDTO();
		docenteViewDTO=new DocenteViewDTO();
		usuarioDTO=new UsuarioDTO();
		periodoDTO=new PeriodoDTO();
		cursoDTO=new CursoDTO();
		paraleloDTO=new ParaleloDTO();
		materiaDTO=new MateriaDTO();
		materiaDocenteDTO=new MateriaDocenteDTO();
	}

	public DocenteDTO getDocenteDTO() {
		return docenteDTO;
	}

	public void setDocenteDTO(DocenteDTO docenteDTO) {
		this.docenteDTO = docenteDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
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

	public PeriodoDTO getPeriodoDTO() {
		return periodoDTO;
	}

	public void setPeriodoDTO(PeriodoDTO periodoDTO) {
		this.periodoDTO = periodoDTO;
	}

	public MateriaDTO getMateriaDTO() {
		return materiaDTO;
	}

	public void setMateriaDTO(MateriaDTO materiaDTO) {
		this.materiaDTO = materiaDTO;
	}

	public DocenteViewDTO getDocenteViewDTO() {
		return docenteViewDTO;
	}

	public void setDocenteViewDTO(DocenteViewDTO docenteViewDTO) {
		this.docenteViewDTO = docenteViewDTO;
	}

	public MateriaDocenteDTO getMateriaDocenteDTO() {
		return materiaDocenteDTO;
	}

	public void setMateriaDocenteDTO(MateriaDocenteDTO materiaDocenteDTO) {
		this.materiaDocenteDTO = materiaDocenteDTO;
	}
	
	
}
