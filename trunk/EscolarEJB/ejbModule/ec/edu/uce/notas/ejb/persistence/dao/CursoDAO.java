package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;

public interface CursoDAO extends AbstractFacade<CursoDTO>{

	List<CursoDTO> getByAnd(CursoDTO objectDTO) throws CorvustecException;

	
	
}
