package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaListDTO;

@Local
public interface IdiomaDAO extends AbstractFacade<IdiomaDTO> {

	List<IdiomaListDTO> getAll(CandidatoDTO candidato);

	
}
