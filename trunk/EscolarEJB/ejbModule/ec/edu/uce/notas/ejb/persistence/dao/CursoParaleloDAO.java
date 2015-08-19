package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.CursoParaleloDTO;

public interface CursoParaleloDAO extends AbstractFacade<CursoParaleloDTO>{

	List<CursoParaleloDTO> getByAnd(CursoParaleloDTO objectDTO) throws CorvustecException;

	
	
}
