package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.ComponenteDTO;

public interface ComponenteDAO extends AbstractFacade<ComponenteDTO>{

	List<ComponenteDTO> getByAnd(ComponenteDTO componenteDTO)
			throws CorvustecException;

}
