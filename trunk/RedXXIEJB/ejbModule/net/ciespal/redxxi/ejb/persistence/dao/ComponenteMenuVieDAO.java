package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuVieDTO;

public interface ComponenteMenuVieDAO extends AbstractFacade<ComponenteMenuDTO>{

	List<ComponenteMenuVieDTO> getBySubquery(AccesoVieDTO objetoDTO,
			ComponenteMenuVieDTO componenteMenuDTO) throws CorvustecException;

	
}
