package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.ObraDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;

public class ObraDAOImpl extends AbstractFacadeImpl<ObraEspejoDTO> implements ObraDAO {

	public ObraDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObraDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
