package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;

@Local
public interface CandidatoDAO extends AbstractFacade<CandidatoDTO>{

	List<CandidatoDTO> getAll() throws SilsaeException;


}
