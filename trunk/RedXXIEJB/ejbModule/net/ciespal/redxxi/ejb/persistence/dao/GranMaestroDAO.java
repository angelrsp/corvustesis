package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;

public interface GranMaestroDAO extends AbstractFacade<GranMaestroDTO> {

	List<GranMaestroDTO> findAll(Object ciudad) throws CorvustecException;

}
