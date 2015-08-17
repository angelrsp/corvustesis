package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;

public interface ComponenteMenuDAO extends AbstractFacade<ComponenteMenuDTO>{

	List<ComponenteMenuDTO> getByAnd(ComponenteMenuDTO componenteDTO)
			throws CorvustecException;

	
}
