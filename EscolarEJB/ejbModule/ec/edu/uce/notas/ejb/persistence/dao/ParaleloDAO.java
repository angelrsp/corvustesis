package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;

public interface ParaleloDAO extends AbstractFacade<ParaleloDTO>{

	List<ParaleloDTO> getByAnd(ParaleloDTO objectDTO) throws CorvustecException;

	
	
}
