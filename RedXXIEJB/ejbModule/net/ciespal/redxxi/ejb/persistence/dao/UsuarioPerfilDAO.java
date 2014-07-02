package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioPerfilDTO;

public interface UsuarioPerfilDAO extends AbstractFacade<UsuarioPerfilDTO>{

	List<UsuarioPerfilDTO> getByAnd(UsuarioPerfilDTO objetoDTO)
			throws CorvustecException;

	
	
}
