package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import com.corvustec.tiempofila.ejb.persistence.dao.AgenciaDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.AgenciaDTO;

public class AgenciaDAOImpl extends AbstractFacadeImpl<AgenciaDTO> implements AgenciaDAO{

	public AgenciaDAOImpl() {
		super();
	}

	public AgenciaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	
}
