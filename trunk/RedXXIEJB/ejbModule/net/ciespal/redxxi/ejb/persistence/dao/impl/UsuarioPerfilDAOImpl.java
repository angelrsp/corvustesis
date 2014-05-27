package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.UsuarioPerfilDAO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioPerfilDTO;

public class UsuarioPerfilDAOImpl extends AbstractFacadeImpl<UsuarioPerfilDTO> implements UsuarioPerfilDAO {


	public UsuarioPerfilDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	
	
}
