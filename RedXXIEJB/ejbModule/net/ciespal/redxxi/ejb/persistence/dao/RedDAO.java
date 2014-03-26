package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;

public interface RedDAO extends AbstractFacade<RedDTO>{

	List<RedDTO> getAll() throws CorvustecException;

}
