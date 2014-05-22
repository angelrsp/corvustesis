package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteDTO;

public interface ComponenteDAO extends AbstractFacade<ComponenteDTO>{

	List<ComponenteDTO> getByAnd(ComponenteDTO componenteDTO)
			throws CorvustecException;

}
