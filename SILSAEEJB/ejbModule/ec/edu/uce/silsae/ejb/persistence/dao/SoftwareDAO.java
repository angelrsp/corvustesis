package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareListDTO;

@Local
public interface SoftwareDAO extends AbstractFacade<SoftwareDTO>{

	List<SoftwareListDTO> getAll(CandidatoDTO candidato) throws SilsaeException;

	

}
