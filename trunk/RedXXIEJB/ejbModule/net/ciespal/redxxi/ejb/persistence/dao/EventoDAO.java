package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;

public interface EventoDAO extends AbstractFacade<EventoDTO>{

	List<EventoDTO> getAll(CarreraDTO carrera) throws CorvustecException;

	
}
