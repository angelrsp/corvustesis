package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.GranMaestroDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;

public class GranMaestroDAOImpl extends AbstractFacadeImpl<GranMaestroDTO> implements GranMaestroDAO{

	public GranMaestroDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GranMaestroDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
