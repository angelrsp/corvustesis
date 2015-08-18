package ec.edu.uce.notas.ejb.service;

import java.util.List;

import javax.ejb.Local;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AlumnoVO;
import ec.edu.uce.notas.ejb.persistence.vo.DocenteVO;

@Local
public interface AcademicoService {

	void createOrUpdateDocente(DocenteVO docenteVO) throws CorvustecException;

	List<DocenteViewDTO> readDocenteView(DocenteViewDTO docenteViewDTO)
			throws CorvustecException;

	void createOrUpdateAlumno(AlumnoVO alumnoVO) throws CorvustecException;

	List<AlumnoViewDTO> readAlumnoView(AlumnoViewDTO alumnoViewDTO)
			throws CorvustecException;

	CursoDTO createOrUpdateCurso(CursoDTO cursoDTO) throws CorvustecException;

	List<CursoDTO> readCurso(CursoDTO cursoDTO) throws CorvustecException;
	
	MateriaDTO createOrUpdateMateria(MateriaDTO materiaDTO) throws CorvustecException;

	List<MateriaDTO> readMateria(MateriaDTO materiaDTO) throws CorvustecException;
	
	PeriodoDTO createOrUpdatePeriodo(PeriodoDTO periodoDTO) throws CorvustecException;

	List<PeriodoDTO> readPeriodo(PeriodoDTO periodoDTO) throws CorvustecException;
	
	ParaleloDTO createOrUpdateParalelo(ParaleloDTO paraleloDTO) throws CorvustecException;

	List<ParaleloDTO> readParalelo(ParaleloDTO paraleloDTO) throws CorvustecException;

}
