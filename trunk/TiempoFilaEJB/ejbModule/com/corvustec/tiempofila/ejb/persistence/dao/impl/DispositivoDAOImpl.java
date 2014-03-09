package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import com.corvustec.tiempofila.ejb.persistence.dao.DispositivoDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.DispositivoDTO;

public class DispositivoDAOImpl extends AbstractFacadeImpl<DispositivoDTO> implements DispositivoDAO{

	public DispositivoDAOImpl() {
		super();
	}

	public DispositivoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
