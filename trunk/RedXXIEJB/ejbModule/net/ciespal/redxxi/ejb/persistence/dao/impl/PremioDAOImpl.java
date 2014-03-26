package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.PremioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

public class PremioDAOImpl extends AbstractFacadeImpl<PremioDTO> implements PremioDAO {

	public PremioDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PremioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
