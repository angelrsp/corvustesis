package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;

public class CarreraDAOImpl extends AbstractFacadeImpl<CarreraDTO> implements CarreraDAO{

	public CarreraDAOImpl() {
		super();
	}

	public CarreraDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

}
