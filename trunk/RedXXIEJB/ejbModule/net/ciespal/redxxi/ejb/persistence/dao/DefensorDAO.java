package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;

import com.corvustec.commons.util.CorvustecException;

public interface DefensorDAO extends AbstractFacade<DefensorDTO>{

	List<DefensorDTO> getByAnd(DefensorDTO defensorDTO)
			throws CorvustecException;

}
