package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.RedDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;

public class RedDAOImpl extends AbstractFacadeImpl<RedDTO> implements RedDAO {

	public RedDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RedDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
