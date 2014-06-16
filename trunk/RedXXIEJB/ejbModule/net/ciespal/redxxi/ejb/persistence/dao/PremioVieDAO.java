package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioVieDTO;

public interface PremioVieDAO extends AbstractFacade<PremioVieDTO>{

	List<PremioVieDTO> getByAnd(PremioVieDTO objetoDTO)
			throws CorvustecException;

	
}
