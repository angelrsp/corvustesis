package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CursoDTO;

public interface CursoDAO extends AbstractFacade<CursoDTO>{

	List<CursoDTO> getAll(CandidatoDTO candidatoDTO);

}
