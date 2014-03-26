package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.EntidadEspejoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EntidadDTO;

public class EntidadEspejoDAOImpl extends AbstractFacadeImpl<EntidadDTO> implements EntidadEspejoDAO {

	public EntidadEspejoDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntidadEspejoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
