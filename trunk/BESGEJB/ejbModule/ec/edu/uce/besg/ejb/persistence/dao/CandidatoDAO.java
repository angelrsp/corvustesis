package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;

public interface CandidatoDAO extends AbstractFacade<CandidatoDTO>  {

	List<CandidatoDTO> getByAnd(CandidatoDTO candidato)
			throws SecurityException;


}
