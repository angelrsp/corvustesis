package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.OpinionDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.OpinionDTO;

public class OpinionDAOImpl extends AbstractFacadeImpl<OpinionDTO> implements OpinionDAO{

	public OpinionDAOImpl() {
		super();
	}

	public OpinionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
}
