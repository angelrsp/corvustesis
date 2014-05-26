package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;

public interface NoticiaDAO extends AbstractFacade<NoticiaDTO>{

	List<NoticiaDTO> getAll();

	void remove2(NoticiaDTO noticia) throws CorvustecException;

	List<NoticiaDTO> getAllPublic();

	List<NoticiaDTO> getAllPublic(int star, int end);

	List<NoticiaDTO> getAllPublic(int result);

	
}
