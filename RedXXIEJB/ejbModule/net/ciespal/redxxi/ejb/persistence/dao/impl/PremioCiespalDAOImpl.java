package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.PremioCiespalDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;

public class PremioCiespalDAOImpl extends AbstractFacadeImpl<PremioCiespalDTO> implements PremioCiespalDAO{

	public PremioCiespalDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PremioCiespalDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
