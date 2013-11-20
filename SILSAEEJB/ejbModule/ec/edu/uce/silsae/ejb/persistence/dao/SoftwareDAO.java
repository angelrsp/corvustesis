package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareDTO;

@Local
public interface SoftwareDAO extends AbstractFacade<SoftwareDTO>{

	List<SoftwareDTO> getAll(CandidatoDTO candidato);

}
