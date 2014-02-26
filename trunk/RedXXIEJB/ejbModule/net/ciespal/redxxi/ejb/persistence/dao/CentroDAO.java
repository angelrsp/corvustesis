package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

public interface CentroDAO extends AbstractFacade<CentroDTO> {


	List<CentroDTO> findAllChild(CentroDTO centro) throws CorvustecException;

	List<CentroDTO> findAllPather() throws CorvustecException;

	List<CentroDTO> findAllPather(Object ubicacio) throws CorvustecException;

}
