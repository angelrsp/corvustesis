package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;

public interface MateriaDAO extends AbstractFacade<MateriaDTO>{

	List<MateriaDTO> getByAnd(MateriaDTO objectDTO) throws CorvustecException;

	
	
}
