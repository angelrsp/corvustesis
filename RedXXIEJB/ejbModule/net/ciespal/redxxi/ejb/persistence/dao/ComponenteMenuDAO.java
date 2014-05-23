package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuDTO;

public interface ComponenteMenuDAO extends AbstractFacade<ComponenteMenuDTO>{

	List<ComponenteMenuDTO> getByAnd(ComponenteMenuDTO componenteDTO)
			throws CorvustecException;

	
}
