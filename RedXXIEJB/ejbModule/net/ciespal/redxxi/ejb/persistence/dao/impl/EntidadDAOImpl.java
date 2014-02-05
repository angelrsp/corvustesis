package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.EntidadDAO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;

public class EntidadDAOImpl extends AbstractFacadeImpl<EntidadDTO> implements EntidadDAO{

	public EntidadDAOImpl() {
		super();
	}

	public EntidadDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	
}
