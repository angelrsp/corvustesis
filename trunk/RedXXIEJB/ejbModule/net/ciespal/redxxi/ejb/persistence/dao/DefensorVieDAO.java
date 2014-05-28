package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorVieDTO;

import com.corvustec.commons.util.CorvustecException;

public interface DefensorVieDAO extends AbstractFacade<DefensorVieDTO>{

	List<DefensorVieDTO> getByAnd(DefensorVieDTO objetoDTO)
			throws CorvustecException;

	
	
	
}
