package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import com.corvustec.tiempofila.ejb.persistence.dao.ClienteDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.ClienteDTO;


public class ClienteDAOImpl extends AbstractFacadeImpl<ClienteDTO> implements ClienteDAO{

	public ClienteDAOImpl() {
		super();
	}

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
