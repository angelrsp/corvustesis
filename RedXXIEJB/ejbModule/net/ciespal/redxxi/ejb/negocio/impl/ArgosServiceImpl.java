package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.EntidadArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class ArgosServiceImpl implements ArgosService{

	private static final Logger logger = LoggerFactory.getLogger(ArgosServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	/*Red*/
	@Override
	public RedDTO createOrUpdateRed(RedDTO red) throws CorvustecException
	{
		logger.info("createOrUpdateRed");
		try{
			if(red.getRedCodigo()!=null)
				return factoryDAO.getRedDAOImpl().edit(red);
			else			
				return factoryDAO.getRedDAOImpl().create(red);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateRed {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateRed");
		}
	}
	
	@Override
	public List<RedDTO> readRed() throws CorvustecException
	{
		logger.info("readRed");
		try{
			return factoryDAO.getRedDAOImpl().getAll();
		}
		catch(Exception e)
		{
			logger.info("Error readRed {}",e.toString());
			throw new CorvustecException("Error al readRed");
		}
	}

	/*Observatorio*/
	@Override
	public ObservatorioDTO createOrUpdateObservatorio(ObservatorioDTO observatorio) throws CorvustecException
	{
		logger.info("createOrUpdateObservatorio");
		try{
			if(observatorio.getObsCodigo()!=null)
				return factoryDAO.getObservatorioDAOImpl().edit(observatorio);
			else			
			{
				observatorio.setArgEntidad(new EntidadArgosDTO());
				return factoryDAO.getObservatorioDAOImpl().create(observatorio);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateObservatorio {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateObservatorio");
		}
	}
	
	@Override
	public List<ObservatorioDTO> readObservatorio(Object ciudad) throws CorvustecException
	{
		logger.info("readObservatorio");
		try{
			return factoryDAO.getObservatorioDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readObservatorio {}",e.toString());
			throw new CorvustecException("Error al readObservatorio");
		}
	}
	
	/*Veeduria*/
	@Override
	public VeeduriaDTO createOrUpdateVeeduria(VeeduriaDTO veeduria) throws CorvustecException
	{
		logger.info("createOrUpdateVeeduria");
		try{
			if(veeduria.getVeeCodigo()!=null)
				return factoryDAO.getVeeduriaDAOImpl().edit(veeduria);
			else			
			{
				veeduria.setArgEntidad(new EntidadArgosDTO());
				return factoryDAO.getVeeduriaDAOImpl().create(veeduria);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateVeeduria {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateVeeduria");
		}
	}
	
	@Override
	public List<VeeduriaDTO> readVeeduria(Object ciudad) throws CorvustecException
	{
		logger.info("readVeeduria");
		try{
			return factoryDAO.getVeeduriaDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readObservatorio {}",e.toString());
			throw new CorvustecException("Error al readObservatorio");
		}
	}

}
