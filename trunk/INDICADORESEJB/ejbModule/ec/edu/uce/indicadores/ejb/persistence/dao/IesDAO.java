package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;

public interface IesDAO extends AbstractFacade<IesDTO>{

	List<IesDTO> getAll() throws IndicadoresException;

	void remove2(IesDTO ies);

}
