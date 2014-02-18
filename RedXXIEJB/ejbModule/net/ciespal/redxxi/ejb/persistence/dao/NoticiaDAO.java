package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;

public interface NoticiaDAO extends AbstractFacade<NoticiaDTO>{

	List<NoticiaDTO> getAll();

	
}
