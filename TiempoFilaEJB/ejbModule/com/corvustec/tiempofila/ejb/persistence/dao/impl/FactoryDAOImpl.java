package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corvustec.tiempofila.ejb.persistence.dao.FactoryDAO;

@Stateless
public class FactoryDAOImpl implements FactoryDAO{

	
	@PersistenceContext(unitName = "tiempoFilaPU")
	private EntityManager entityManager;

	
}
