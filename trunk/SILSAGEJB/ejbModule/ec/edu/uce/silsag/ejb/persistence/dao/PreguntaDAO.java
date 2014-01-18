package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;

public interface PreguntaDAO extends AbstractFacade<PreguntaDTO>{

	List<PreguntaDTO> getAll();

}
