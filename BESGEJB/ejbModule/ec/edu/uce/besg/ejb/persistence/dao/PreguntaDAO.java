package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;

public interface PreguntaDAO extends AbstractFacade<PreguntaDTO> {

	List<PreguntaDTO> getByAnd(PreguntaDTO objetoDTO) throws SecurityException;

}
