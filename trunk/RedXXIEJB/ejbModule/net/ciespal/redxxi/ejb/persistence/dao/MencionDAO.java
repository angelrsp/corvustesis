package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;

public interface MencionDAO extends AbstractFacade<MencionDTO> {

	List<MencionDTO> getAll(CarreraDTO carrera) throws CorvustecException;

}
