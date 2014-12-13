package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.entity.HabilidadDTO;

public interface HabilidadDAO extends AbstractFacade<HabilidadDTO> {

	List<HabilidadDTO> getByAnd(HabilidadDTO objeto) throws SecurityException;
	

}
