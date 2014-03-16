package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;

public interface EntidadDAO extends AbstractFacade<EntidadDTO> {

	void remove2(EntidadDTO entidad) throws CorvustecException;

	List<EntidadDTO> getAll(CarreraDTO carrera) throws CorvustecException;

}
