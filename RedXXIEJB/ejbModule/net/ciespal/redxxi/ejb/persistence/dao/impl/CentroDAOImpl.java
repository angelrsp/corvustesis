package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.CentroDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

public class CentroDAOImpl extends AbstractFacadeImpl<CentroDTO> implements CentroDAO{

	public CentroDAOImpl() {
		super();
	}

	public CentroDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
