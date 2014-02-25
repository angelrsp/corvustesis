package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;

public interface PublicacionDAO extends AbstractFacade<PublicacionDTO>{

	List<PublicacionDTO> getAll(CarreraDTO carrera) throws CorvustecException;

	void remove2(PublicacionDTO pub);

	List<PublicacionDTO> getAll(Object ubicacion) throws CorvustecException;

	List<PublicacionDTO> getAll() throws CorvustecException;

}
