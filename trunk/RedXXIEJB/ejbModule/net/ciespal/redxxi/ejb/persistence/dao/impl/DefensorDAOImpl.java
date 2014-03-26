package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.DefensorDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;

public class DefensorDAOImpl extends AbstractFacadeImpl<DefensorDTO> implements DefensorDAO {

	public DefensorDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefensorDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
