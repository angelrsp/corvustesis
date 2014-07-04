package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;

public interface AccesoVieDAO extends AbstractFacade<AccesoVieDTO>{

	List<AccesoVieDTO> getByAnd(AccesoVieDTO menuDTO) throws CorvustecException;

	List<AccesoVieDTO> getByAndPerfilIsNull(AccesoVieDTO objetoDTO)
			throws CorvustecException;

	List<AccesoVieDTO> getByAndDistinctMenu(AccesoVieDTO objetoDTO)
			throws CorvustecException;

	List<AccesoVieDTO> getBySubquery(AccesoVieDTO objetoDTO)
			throws CorvustecException;

	
	
}
