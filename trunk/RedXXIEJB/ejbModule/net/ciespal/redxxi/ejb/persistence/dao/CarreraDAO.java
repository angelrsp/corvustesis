package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

public interface CarreraDAO extends AbstractFacade<CarreraDTO> {


	List<CarreraDTO> getAll(CentroDTO centro, Object tipo)
			throws CorvustecException;

}
