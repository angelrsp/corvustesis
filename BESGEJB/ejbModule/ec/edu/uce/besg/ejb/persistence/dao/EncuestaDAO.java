package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;

public interface EncuestaDAO extends AbstractFacade<EncuestaDTO> {

	List<EncuestaDTO> getByAnd(EncuestaDTO objetoDTO) throws SecurityException;

	
	
}
