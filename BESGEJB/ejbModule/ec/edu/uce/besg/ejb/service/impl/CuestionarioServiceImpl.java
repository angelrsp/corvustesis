package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ControlDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CuestionarioViewDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;
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
	public PreguntaDTO createOrUpdatePregunta(PreguntaDTO preguntaDTO) throws CorvustecException
	{
		try {
			if(preguntaDTO.getPreCodigo()!=null)
				return factoryDAO.getPreguntaDAOImpl().update(preguntaDTO);
			else
				return factoryDAO.getPreguntaDAOImpl().create(preguntaDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
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
	public RespuestaDTO createOrUpdateRespuesta(RespuestaDTO respuestaDTO) throws CorvustecException
	{
		try {
			if(respuestaDTO.getResCodigo()!=null)
				return factoryDAO.getRespuestaDAOImpl().update(respuestaDTO);
			else
				return factoryDAO.getRespuestaDAOImpl().create(respuestaDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
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
	
	
	@Override
	public EncuestaDTO createOrUpdateEncuesta(EncuestaDTO encuestaDTO) throws CorvustecException
	{
		try {
			if(encuestaDTO.getEncCodigo()!=null)
				return factoryDAO.getEncuestaDAOImpl().update(encuestaDTO);
			else
				return factoryDAO.getEncuestaDAOImpl().create(encuestaDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			
		}
	}
	
	@Override
	public List<EncuestaDTO> readEncuesta(EncuestaDTO encuestaDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getEncuestaDAOImpl().getByAnd(encuestaDTO);
		} catch (Exception e) {
			logger.info("Error al readCuestionario {}", e.toString());
			throw new CorvustecException("Error al registrar readCuestionario "+e.toString());
		}
		finally{
			
		}		
	}

	@Override
	public CategoriaDTO createOrUpdateCategoria(CategoriaDTO categoriaDTO) throws CorvustecException
	{
		try {
			if(categoriaDTO.getCatCodigo()!=null)
				return factoryDAO.getCategoriaDAOImpl().update(categoriaDTO);
			else
				return factoryDAO.getCategoriaDAOImpl().create(categoriaDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			
		}
	}
	
	@Override
	public List<CategoriaDTO> readCategoria(CategoriaDTO categoriaDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getCategoriaDAOImpl().getByAnd(categoriaDTO);
		} catch (Exception e) {
			logger.info("Error al readCuestionario {}", e.toString());
			throw new CorvustecException("Error al registrar readCuestionario "+e.toString());
		}
		finally{
			
		}		
	}
	
	@Override
	public List<ControlDTO> readControl(ControlDTO controlDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getControlDAOImpl().getByAnd(controlDTO);
		} catch (Exception e) {
			logger.info("Error al readCuestionario {}", e.toString());
			throw new CorvustecException("Error al registrar readCuestionario "+e.toString());
		}
		finally{
			
		}
	}
	

	@Override
	public void createOrUpdateResultado(List<ResultadoDTO> resultadoList) throws CorvustecException
	{
		try {
			for(ResultadoDTO resultadoDTO:resultadoList)
			{
				if(resultadoDTO.getResValorString()!=null)
					factoryDAO.getResultadoDAOImpl().create(resultadoDTO);
				else if(resultadoDTO.getResValorInt()!=null)
					factoryDAO.getResultadoDAOImpl().create(resultadoDTO);
			}
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			
		}
	}

	
	@Override
	public List<ResultadoViewDTO> readResultadoView(ResultadoViewDTO resultadoViewDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getResultadoViewDAOImpl().getByAnd(resultadoViewDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			
		}
	}

	
}
