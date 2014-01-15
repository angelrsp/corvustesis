package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.SoftwareDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.SoftwareListDTO;

@Local
public interface SoftwareDAO extends AbstractFacade<SoftwareDTO>{

	List<SoftwareListDTO> getAll(CandidatoDTO candidato) throws SilsagException;

	

}
