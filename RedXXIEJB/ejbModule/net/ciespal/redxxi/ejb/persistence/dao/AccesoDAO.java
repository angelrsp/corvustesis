package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoDTO;

public interface AccesoDAO extends AbstractFacade<AccesoDTO>{

	List<AccesoDTO> getByAnd(AccesoDTO objetoDTO) throws CorvustecException;

	List<AccesoDTO> getByAndDistinctMenu(AccesoDTO objetoDTO)
			throws CorvustecException;

	
	
}
