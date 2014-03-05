package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

public interface EventoDAO extends AbstractFacade<EventoDTO>{

	List<EventoDTO> getAll(CarreraDTO carrera) throws CorvustecException;

	void remove2(EventoDTO eve);

	List<EventoDTO> getAll(OrganizacionDTO organizacion)
			throws CorvustecException;

	List<EventoDTO> getAll() throws CorvustecException;

	
}
