package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;

public interface MaestroCiespalDAO extends AbstractFacade<MaestroCiespalDTO> {

	List<MaestroCiespalDTO> findAll(Object ciudad) throws CorvustecException;

}
