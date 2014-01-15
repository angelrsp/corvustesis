package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.IdiomaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.IdiomaListDTO;

@Local
public interface IdiomaDAO extends AbstractFacade<IdiomaDTO> {

	List<IdiomaListDTO> getAll(CandidatoDTO candidato);

	
}
