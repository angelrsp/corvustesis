package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.ObservatorioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;

public class ObservatorioDAOImpl extends AbstractFacadeImpl<ObservatorioDTO> implements ObservatorioDAO {

	public ObservatorioDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObservatorioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
