package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.AvisoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PostulacionDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoPostulacionViewDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;
import ec.edu.uce.besg.ejb.service.EmpleoService;

@Stateless
public class EmpleoServiceImpl implements EmpleoService{

	
	private static final Logger logger = LoggerFactory.getLogger(EmpleoServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	
	@Override
	public AvisoDTO createOrUpdateAviso(AvisoDTO avisoDTO) throws CorvustecException
	{
		try {
			if(avisoDTO.getAviCodigo()!=null)
				return factoryDAO.getAvisoDAOImpl().update(avisoDTO);
			else
				return factoryDAO.getAvisoDAOImpl().create(avisoDTO);
		} catch (Exception e) {
			logger.info("Error al registrar createOrUpdateAviso {}", e.toString());
			throw new CorvustecException("Error al registrar createOrUpdateAviso "+e.toString());
		}
		finally{
			avisoDTO=null;
		}
			
	}


	@Override
	public List<AvisoViewDTO> readAviso(AvisoViewDTO avisoViewDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getAvisoViewDAOImpl().getByAnd(avisoViewDTO);
		} catch (Exception e) {
			logger.info("Error al registrar createOrUpdateAviso {}", e.toString());
			throw new CorvustecException("Error al registrar createOrUpdateAviso "+e.toString());
		}
		finally{
			avisoViewDTO=null;
		}
			
	}

	@Override
	public AvisoDTO findAviso(Object object) throws CorvustecException
	{
		try {
			return factoryDAO.getAvisoDAOImpl().find(object);
		} catch (Exception e) {
			logger.info("Error al registrar createOrUpdateAviso {}", e.toString());
			throw new CorvustecException("Error al registrar createOrUpdateAviso "+e.toString());
		}
		finally{
			object=null;
		}
			
	}

	@Override
	public PostulacionDTO createOrUpdatePosulacion(PostulacionDTO postulacionDTO) throws CorvustecException
	{
		try {
			if(postulacionDTO.getPosCodigo()!=null)
				return factoryDAO.getPostulacionDAOImpl().update(postulacionDTO);
			else
				return factoryDAO.getPostulacionDAOImpl().create(postulacionDTO);
		} catch (Exception e) {
			logger.info("Error al registrar createOrUpdateAviso {}", e.toString());
			throw new CorvustecException("Error al registrar createOrUpdateAviso "+e.toString());
		}
		finally{
			postulacionDTO=null;
		}
			
	}
	
	@Override
	public List<AvisoPostulacionViewDTO> readAvisoPostulacion(AvisoPostulacionViewDTO avisoPostulacionViewDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getAvisoPostulacionViewDAOImpl().getByAnd(avisoPostulacionViewDTO);
		} catch (Exception e) {
			logger.info("Error al registrar createOrUpdateAviso {}", e.toString());
			throw new CorvustecException("Error al registrar createOrUpdateAviso "+e.toString());
		}
		finally{
			avisoPostulacionViewDTO=null;
		}
			
	}

}
