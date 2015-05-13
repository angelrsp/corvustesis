package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;

public interface ResultadoDAO extends AbstractFacade<ResultadoDTO> {

	List<ResultadoDTO> getByAnd(ResultadoDTO objetoDTO)
			throws SecurityException;

	
	
}
