package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.EntidadArgosDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.EntidadDTO;

public class EntidadArgosDAOImpl extends AbstractFacadeImpl<EntidadDTO> implements EntidadArgosDAO {

	public EntidadArgosDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntidadArgosDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
