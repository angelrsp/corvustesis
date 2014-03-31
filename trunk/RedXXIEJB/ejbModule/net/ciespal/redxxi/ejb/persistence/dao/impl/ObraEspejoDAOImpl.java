package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.ObraEspejoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;

public class ObraEspejoDAOImpl extends AbstractFacadeImpl<ObraEspejoDTO> implements ObraEspejoDAO {

	public ObraEspejoDAOImpl() {
		super();
	}

	public ObraEspejoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


}
