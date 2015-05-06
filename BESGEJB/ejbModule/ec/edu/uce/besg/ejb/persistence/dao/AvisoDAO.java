package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.AvisoDTO;

public interface AvisoDAO extends AbstractFacade<AvisoDTO> {

	List<AvisoDTO> getByAnd(AvisoDTO objeto) throws SecurityException;

}
