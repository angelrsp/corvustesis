package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;

public interface AdicionalDAO extends AbstractFacade<AdicionalDTO> {

	List<AdicionalDTO> getAll(CandidatoDTO candidatoDTO);

}
