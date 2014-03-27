package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EntidadEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class EspejoServiceImpl implements EspejoService{

	private static final Logger logger = LoggerFactory.getLogger(EspejoServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	/*Etica*/
	@Override
	public EticaDTO createOrUpdateEtica(EticaDTO etica) throws CorvustecException
	{
		logger.info("createOrUpdateEtica");
		try{
			if(etica.getEtiCodigo()!=null)
				return factoryDAO.getEticaDAOImpl().edit(etica);
			else			
			{
				etica.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getEticaDAOImpl().create(etica);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateRed {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateRed");
		}
	}

	@Override
	public List<EticaDTO> readEtica(Object ciudad) throws CorvustecException
	{
		logger.info("readEtica");
		try{
			return factoryDAO.getEticaDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readEtica {}",e.toString());
			throw new CorvustecException("Error al readEtica");
		}
	}

	/*Maestro Periodismo*/
	@Override
	public GranMaestroDTO createOrUpdateMaestroPeriodismo(GranMaestroDTO granMaestro) throws CorvustecException
	{
		logger.info("createOrUpdateMaestroPeriodismo");
		try{
			if(granMaestro.getGmaCodigo()!=null)
				return factoryDAO.getGranMaestroDAOImpl().edit(granMaestro);
			else			
			{
				granMaestro.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getGranMaestroDAOImpl().create(granMaestro);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateMaestroPeriodismo {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroPeriodismo");
		}
	}

	@Override
	public List<GranMaestroDTO> readMaestroPeriodismo(Object ciudad) throws CorvustecException
	{
		logger.info("readMaestroPeriodismo");
		try{
			return factoryDAO.getGranMaestroDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readMaestroPeriodismo {}",e.toString());
			throw new CorvustecException("Error al readMaestroPeriodismo");
		}
	}

	
}
