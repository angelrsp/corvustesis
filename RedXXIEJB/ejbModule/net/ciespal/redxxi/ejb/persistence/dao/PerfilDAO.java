package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;

public interface PerfilDAO extends AbstractFacade<PerfilDTO>{

	List<PerfilDTO> getByAnd(PerfilDTO perfilDTO) throws CorvustecException;

	
}
