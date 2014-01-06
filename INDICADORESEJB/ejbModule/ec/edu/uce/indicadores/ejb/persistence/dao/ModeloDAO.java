package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;

public interface ModeloDAO extends AbstractFacade<ModeloDTO>{

	List<ModeloDTO> getAll() throws IndicadoresException;

}
