package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;

import com.corvustec.commons.util.CorvustecException;

public interface UsuarioDAO extends AbstractFacade<UsuarioDTO>{

	List<UsuarioDTO> getByAnd(UsuarioDTO usuarioDTO) throws CorvustecException;


	
}
