package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;


import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

public interface PremioDAO extends AbstractFacade<PremioDTO>{
	List<PremioDTO> findAll(Object ciudad) throws CorvustecException;
}
