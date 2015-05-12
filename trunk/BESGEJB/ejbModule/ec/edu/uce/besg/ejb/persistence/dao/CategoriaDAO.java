package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;

public interface CategoriaDAO extends AbstractFacade<CategoriaDTO>{

	List<CategoriaDTO> getByAnd(CategoriaDTO objetoDTO)
			throws CorvustecException;

}
