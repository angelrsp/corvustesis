package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaDTO;

@Local
public interface IdiomaDAO extends AbstractFacade<IdiomaDTO> {

	List<IdiomaDTO> getAll(CandidatoDTO candidato);

	
}
