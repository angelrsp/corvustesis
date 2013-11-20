package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;

@Local
public interface ExperienciaDAO extends AbstractFacade<ExperienciaDTO> {

	List<ExperienciaListDTO> getAll(CandidatoDTO candidato)
			throws SilsaeException;

	

}
