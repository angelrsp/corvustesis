package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.HistoryPasswordDTO;

public interface HistorialPasswordDAO extends AbstractFacade<HistoryPasswordDTO> {

	List<HistoryPasswordDTO> getByAnd(HistoryPasswordDTO objeto)
			throws CorvustecException;

}
