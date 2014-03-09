package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import com.corvustec.tiempofila.ejb.persistence.dao.ParametroDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.ParametroDTO;

public class ParametroDAOImpl extends AbstractFacadeImpl<ParametroDTO> implements ParametroDAO {

	public ParametroDAOImpl() {
		super();
	}

	public ParametroDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
