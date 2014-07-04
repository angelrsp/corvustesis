package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuDTO;

public interface ComponenteMenuVieDAO extends AbstractFacade<ComponenteMenuDTO>{

	List<ComponenteMenuDTO> getBySubquery(AccesoVieDTO objetoDTO,
			ComponenteMenuDTO componenteMenuDTO) throws CorvustecException;

	
}
