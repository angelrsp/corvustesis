package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.AccesoDTO;

public interface AccesoDAO extends AbstractFacade<AccesoDTO>{

	List<AccesoDTO> getByAnd(AccesoDTO objetoDTO) throws CorvustecException;

	List<AccesoDTO> getByAndDistinctMenu(AccesoDTO objetoDTO)
			throws CorvustecException;

	void remove2(AccesoDTO acceso);

	
	
}
