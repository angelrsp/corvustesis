package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import com.corvustec.tiempofila.ejb.persistence.dao.TiempoDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.TiempoDTO;

public class TiempoDAOImpl extends AbstractFacadeImpl<TiempoDTO> implements TiempoDAO {

	public TiempoDAOImpl() {
		super();
	}

	public TiempoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
