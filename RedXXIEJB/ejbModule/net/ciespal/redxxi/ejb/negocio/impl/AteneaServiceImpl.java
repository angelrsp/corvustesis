package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class AteneaServiceImpl implements AteneaService{

	private static final Logger logger = LoggerFactory.getLogger(AteneaServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public CentroDTO createCentro(CentroDTO centro) throws CorvustecException
	{
		logger.info("createCentro");
		try{
			return factoryDAO.getCentroDAOImpl().create(centro);
		}
		catch(Exception e)
		{
			logger.info("Error createCentro {}",e.toString());
			throw new CorvustecException("Error al createCentro");
		}
	}
	
	@Override
	public List<CentroDTO> obtenerCentroPadre() throws CorvustecException
	{
		logger.info("obtenerCentroPadre");
		try{
			return factoryDAO.getCentroDAOImpl().findAllPather();
		}
		catch(Exception e)
		{
			logger.info("Error obtenerCentroPadre {}",e.toString());
			throw new CorvustecException("Error al obtenerCentroPadre");
		}
	}
	
	@Override
	public List<CentroDTO> obtenerCentroHijo(CentroDTO centro) throws CorvustecException
	{
		logger.info("obtenerCentroPadre");
		try{
			return factoryDAO.getCentroDAOImpl().findAllChild(centro);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerCentroPadre {}",e.toString());
			throw new CorvustecException("Error al obtenerCentroPadre");
		}
	}
}
