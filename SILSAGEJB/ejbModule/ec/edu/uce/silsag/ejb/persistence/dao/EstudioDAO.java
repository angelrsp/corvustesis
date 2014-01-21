package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioListDTO;

@Local
public interface EstudioDAO extends AbstractFacade<EstudioDTO>{


	Integer getMax(CandidatoDTO can);

	List<EstudioDTO> getAll(CandidatoDTO candidato);

	List<EstudioListDTO> getAllList(CandidatoDTO can);

	
}
