package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalVieDTO;

public interface PremioCiespalVieDAO extends AbstractFacade<PremioCiespalDTO>{

	List<PremioCiespalVieDTO> getByAnd(PremioCiespalVieDTO objetoDTO)
			throws CorvustecException;

	
}
