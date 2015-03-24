package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.ExperienciaDTO;

public interface ExperienciaDAO extends AbstractFacade<ExperienciaDTO> {

	List<ExperienciaDTO> getByAnd(ExperienciaDTO objeto)
			throws SecurityException;

}
