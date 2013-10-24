package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.ejb.Stateless;

import ec.edu.uce.silsae.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class UsuarioDAOImpl extends AbstractFacadeImpl<UsuarioDTO> implements UsuarioDAO{
	
	public UsuarioDAOImpl () {
		super(UsuarioDTO.class);
	}

}
