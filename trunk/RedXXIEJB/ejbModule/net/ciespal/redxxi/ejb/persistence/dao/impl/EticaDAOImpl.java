package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.EticaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;

public class EticaDAOImpl extends AbstractFacadeImpl<EticaDTO> implements EticaDAO{

	public EticaDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EticaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
