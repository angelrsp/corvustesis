package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RegistroDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;

public interface RegistroDAO extends AbstractFacade<RegistroDTO>{

	List<RegistroDTO> getAll(RepresentanteLegalDTO representanteLegalDTO,
			IesDTO iesDTO) throws IndicadoresException;

	List<RegistroDTO> getAll(IesDTO iesDTO) throws IndicadoresException;

}
