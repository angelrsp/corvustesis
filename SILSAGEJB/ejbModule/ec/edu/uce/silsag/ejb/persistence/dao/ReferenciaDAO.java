package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;

@Local
public interface ReferenciaDAO extends AbstractFacade<ReferenciaDTO>{

	List<ReferenciaDTO> getAll(CandidatoDTO candidato);

}
