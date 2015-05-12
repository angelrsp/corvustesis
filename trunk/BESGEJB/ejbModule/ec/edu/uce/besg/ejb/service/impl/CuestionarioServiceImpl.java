package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CuestionarioViewDTO;
import ec.edu.uce.besg.ejb.service.CuestionarioService;

@Stateless
public class CuestionarioServiceImpl implements CuestionarioService{

	private static final Logger logger = LoggerFactory.getLogger(CuestionarioServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public List<CuestionarioViewDTO> readCuestionario(CuestionarioViewDTO cuestionarioViewDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getCuestionarioViewDAOImpl().getByAnd(cuestionarioViewDTO);	
		} catch (Exception e) {
			logger.info("Error al readCuestionario {}", e.toString());
			throw new CorvustecException("Error al registrar readCuestionario "+e.toString());
		}
		finally{
			
		}		
	}
	
	@Override
	public List<PreguntaDTO> readPregunta(PreguntaDTO preguntaDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getPreguntaDAOImpl().getByAnd(preguntaDTO);
		} catch (Exception e) {
			logger.info("Error al readCuestionario {}", e.toString());
			throw new CorvustecException("Error al registrar readCuestionario "+e.toString());
		}
		finally{
			
		}		
	}
	
	
	@Override
	public List<RespuestaDTO> readRespuesta(RespuestaDTO respuestaDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getRespuestaDAOImpl().getByAnd(respuestaDTO);
		} catch (Exception e) {
			logger.info("Error al readCuestionario {}", e.toString());
			throw new CorvustecException("Error al registrar readCuestionario "+e.toString());
		}
		finally{
			
		}		
	}
}
