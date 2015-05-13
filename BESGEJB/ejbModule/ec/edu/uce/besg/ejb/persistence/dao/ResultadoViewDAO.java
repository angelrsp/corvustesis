package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;

public interface ResultadoViewDAO extends AbstractFacade<ResultadoViewDTO> {

	List<ResultadoViewDTO> getByAnd(ResultadoViewDTO objetoDTO)
			throws SecurityException;

	
	
	
}
