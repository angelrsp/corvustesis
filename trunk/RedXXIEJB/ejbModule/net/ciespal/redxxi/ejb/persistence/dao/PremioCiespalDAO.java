package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;

public interface PremioCiespalDAO extends AbstractFacade<PremioCiespalDTO>{

	List<PremioCiespalDTO> findAll(Object ciudad) throws CorvustecException;

}
