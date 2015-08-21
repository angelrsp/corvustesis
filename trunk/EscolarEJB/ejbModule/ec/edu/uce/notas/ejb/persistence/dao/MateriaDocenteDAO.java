package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.MateriaDocenteDTO;

public interface MateriaDocenteDAO extends AbstractFacade<MateriaDocenteDTO>{

	List<MateriaDocenteDTO> getByAnd(MateriaDocenteDTO objectDTO) throws CorvustecException;

	
	
}
