package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoListDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO>{

	List<ContactoListDTO> getAll(RepresentanteLegalDTO representanteLegalDTO)
			throws IndicadoresException;

}
