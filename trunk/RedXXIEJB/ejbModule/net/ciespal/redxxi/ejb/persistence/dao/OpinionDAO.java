package net.ciespal.redxxi.ejb.persistence.dao;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.argos.OpinionDTO;

public interface OpinionDAO extends AbstractFacade<OpinionDTO>{

	int count(Object pais) throws CorvustecException;

	
}
