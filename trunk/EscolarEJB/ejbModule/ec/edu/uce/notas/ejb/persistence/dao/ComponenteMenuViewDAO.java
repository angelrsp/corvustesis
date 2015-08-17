package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.ComponenteMenuViewDTO;

public interface ComponenteMenuViewDAO extends AbstractFacade<ComponenteMenuDTO>{

	List<ComponenteMenuViewDTO> getBySubquery(AccesoViewDTO objetoDTO,
			ComponenteMenuViewDTO componenteMenuDTO) throws CorvustecException;

	
}
