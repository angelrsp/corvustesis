package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.CatalogoDTO;

public interface CatalogoDAO extends AbstractFacade<CatalogoDTO>{

	List<CatalogoDTO> getByAnd(CatalogoDTO objectDTO) throws CorvustecException;

}
