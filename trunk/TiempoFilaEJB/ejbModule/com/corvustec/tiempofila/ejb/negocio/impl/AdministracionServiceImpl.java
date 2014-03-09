package com.corvustec.tiempofila.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.tiempofila.ejb.negocio.AdministracionService;
import com.corvustec.tiempofila.ejb.persistence.dao.FactoryDAO;


@Stateless
public class AdministracionServiceImpl implements AdministracionService{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB 
	private FactoryDAO factoryDAO;

	
}
