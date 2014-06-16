package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyVieDTO;

public interface LeyVieDAO extends AbstractFacade<LeyVieDTO>{

	List<LeyVieDTO> getByAnd(LeyVieDTO objetoDTO) throws CorvustecException;

	
}
