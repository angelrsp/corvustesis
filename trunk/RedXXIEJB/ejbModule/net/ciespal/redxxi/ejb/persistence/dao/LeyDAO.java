package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;

public interface LeyDAO extends AbstractFacade<LeyDTO> {

	List<LeyDTO> findAll(Object ciudad) throws CorvustecException;

}
