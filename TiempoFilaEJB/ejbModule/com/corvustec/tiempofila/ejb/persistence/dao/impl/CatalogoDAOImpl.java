package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import com.corvustec.tiempofila.ejb.persistence.dao.CatalogoDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.CatalogoDTO;

public class CatalogoDAOImpl extends AbstractFacadeImpl<CatalogoDTO> implements CatalogoDAO{

	public CatalogoDAOImpl() {
		super();
	}

	public CatalogoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
