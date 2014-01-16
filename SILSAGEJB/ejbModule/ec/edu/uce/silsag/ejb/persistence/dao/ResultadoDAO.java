package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoDTO;

public interface ResultadoDAO extends AbstractFacade<ResultadoDTO>{

	List<ResultadoDTO> getAll(CandidatoDTO candidatoDTO);

}
