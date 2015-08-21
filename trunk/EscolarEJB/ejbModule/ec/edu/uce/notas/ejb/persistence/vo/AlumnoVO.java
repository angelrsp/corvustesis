package ec.edu.uce.notas.ejb.persistence.vo;

import java.io.Serializable;

import ec.edu.uce.notas.ejb.persistence.entity.AlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoAlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;

public class AlumnoVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private AlumnoDTO alumnoDTO;
	private AlumnoViewDTO alumnoViewDTO;
	private UsuarioDTO usuarioDTO;
	private PeriodoDTO periodoDTO;
	private CursoDTO cursoDTO;
	private ParaleloDTO paraleloDTO;
	private CursoAlumnoDTO cursoAlumnoDTO;
	
	public AlumnoVO() {
		alumnoDTO=new AlumnoDTO();
		alumnoViewDTO=new AlumnoViewDTO();
		usuarioDTO=new UsuarioDTO();
		periodoDTO=new PeriodoDTO();
		cursoDTO=new CursoDTO();
		paraleloDTO=new ParaleloDTO();
		cursoAlumnoDTO=new CursoAlumnoDTO();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public AlumnoDTO getAlumnoDTO() {
		return alumnoDTO;
	}

	public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
		this.alumnoDTO = alumnoDTO;
	}

	public AlumnoViewDTO getAlumnoViewDTO() {
		return alumnoViewDTO;
	}

	public void setAlumnoViewDTO(AlumnoViewDTO alumnoViewDTO) {
		this.alumnoViewDTO = alumnoViewDTO;
	}

	public PeriodoDTO getPeriodoDTO() {
		return periodoDTO;
	}

	public void setPeriodoDTO(PeriodoDTO periodoDTO) {
		this.periodoDTO = periodoDTO;
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

	public CursoAlumnoDTO getCursoAlumnoDTO() {
		return cursoAlumnoDTO;
	}

	public void setCursoAlumnoDTO(CursoAlumnoDTO cursoAlumnoDTO) {
		this.cursoAlumnoDTO = cursoAlumnoDTO;
	}
	
	
	
}
