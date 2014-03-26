package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.LeyDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;

public class LeyDAOImpl extends AbstractFacadeImpl<LeyDTO> implements LeyDAO {

	public LeyDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeyDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
