package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaListDTO;

@Local
public interface ExperienciaDAO extends AbstractFacade<ExperienciaDTO> {

	List<ExperienciaListDTO> getAll(CandidatoDTO candidato)
			throws SilsagException;

	
}
