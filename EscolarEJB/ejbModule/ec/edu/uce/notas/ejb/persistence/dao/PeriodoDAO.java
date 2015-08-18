package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;

public interface PeriodoDAO extends AbstractFacade<PeriodoDTO>{

	List<PeriodoDTO> getByAnd(PeriodoDTO objectDTO) throws CorvustecException;

	
	
}
