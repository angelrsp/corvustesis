package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.view.CandidatoPostulacionViewDTO;

public interface CandidatoPostulacionViewDAO {

	List<CandidatoPostulacionViewDTO> getByAnd(
			CandidatoPostulacionViewDTO objetoDTO) throws SecurityException;

}
