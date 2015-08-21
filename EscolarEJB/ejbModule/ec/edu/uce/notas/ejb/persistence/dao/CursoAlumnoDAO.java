package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.CursoAlumnoDTO;

public interface CursoAlumnoDAO extends AbstractFacade<CursoAlumnoDTO>{

	List<CursoAlumnoDTO> getByAnd(CursoAlumnoDTO objectDTO) throws CorvustecException;

	
	
}
