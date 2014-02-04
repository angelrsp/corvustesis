package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;

import com.corvustec.commons.util.CorvustecException;


@Stateless
public class AdministracionServiceImpl implements AdministracionService{

	private static final Logger logger = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws CorvustecException
	{
		logger.info("getCatalogo");
		try{
			return factoryDAO.getCatalogoImpl().getAll(catalogo);
		}
		catch(Exception e)
		{
			logger.info("Error al obtener catalogo" +e.toString());
			throw new CorvustecException("Error al obtener catalogo");
		}
	}
	
	@Override
	public CatalogoDTO createCatalogo(CatalogoDTO catalogo) throws CorvustecException
	{
		logger.info("createCatalogo");
		try{
			return factoryDAO.getCatalogoImpl().create(catalogo);
		}
		catch(Exception e)
		{
			logger.info("Error al createCatalogo" +e.toString());
			throw new CorvustecException("Error al createCatalogo");
		}
	}
	
}
