package ec.edu.uce.silsae.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.ejb.negocio.CatalogoService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;

public class CatalogoServiceImpl implements CatalogoService{
	
	
	private static final Logger log = LoggerFactory.getLogger(CandidatosServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;


}
