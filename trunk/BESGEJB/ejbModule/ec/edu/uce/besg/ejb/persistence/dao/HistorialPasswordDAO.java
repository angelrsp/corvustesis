package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.security.HistorialPasswordDTO;

public interface HistorialPasswordDAO extends AbstractFacade<HistorialPasswordDTO> {

	List<HistorialPasswordDTO> getByAnd(HistorialPasswordDTO objeto)
			throws CorvustecException;

}
