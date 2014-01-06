package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;

public interface RepresentanteLegalDAO extends AbstractFacade<RepresentanteLegalDTO>{

	List<RepresentanteLegalDTO> getAll() throws IndicadoresException;

	
	
	
}
