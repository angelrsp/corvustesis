package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioListDTO;

@Local
public interface EstudioDAO extends AbstractFacade<EstudioDTO>{

	List<EstudioListDTO> getAll(CandidatoDTO can);

	Integer getMax(CandidatoDTO can);

	
}
