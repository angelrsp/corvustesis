package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import com.corvustec.tiempofila.ejb.persistence.dao.AsesorDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.AsesorDTO;

public class AsesorDAOImpl extends AbstractFacadeImpl<AsesorDTO> implements AsesorDAO{

	public AsesorDAOImpl() {
		super();
	}

	public AsesorDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
