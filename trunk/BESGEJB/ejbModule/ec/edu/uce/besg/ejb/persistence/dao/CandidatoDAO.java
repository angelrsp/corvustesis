package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.CandidatoListDTO;

public interface CandidatoDAO extends AbstractFacade<CandidatoDTO>  {

	List<CandidatoListDTO> getByAnd(CandidatoListDTO objeto)
			throws SecurityException;

	Boolean getByIdentificacion(CandidatoDTO candidatoDTO);

	List<CandidatoDTO> getByAndDTO(CandidatoDTO objeto)
			throws SecurityException;


}
