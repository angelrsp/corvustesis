package ec.edu.uce.silsag.ejb.negocio.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CursoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.RespuestaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class CandidatosServiceImpl implements CandidatosService {

	private static final Logger log = LoggerFactory
			.getLogger(CandidatosServiceImpl.class);

	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO)throws SilsagException {

		log.info("registrarCandidato");

		try {
			UsuarioDTO user = candidatoDTO.getBemUsuario();
			user.setBemPerfil(factoryDAO.getPerfilDAOImpl().find(1));
			candidatoDTO.setBemUsuario(user);
			return factoryDAO.getCandidatoDAOImpl().create(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}

	}

	
	@Override
	public CandidatoDTO actualizarCandidato(CandidatoDTO candidatoDTO)throws SilsagException {

		log.info("registrarCandidato");

		try {
			return factoryDAO.getCandidatoDAOImpl().edit(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}

	}

	
	
	@Override
	public void agregarEstudio(EstudioDTO estudio) throws SilsagException {
		log.info("agregarEstudio");

		try {
			factoryDAO.getEstudioDAOImpl().create(estudio);
			CandidatoDTO can=estudio.getBemCandidato();
			Integer es=factoryDAO.getEstudioDAOImpl().getMax(can);
			can.setCanMaxEstudio(es);
			factoryDAO.getCandidatoDAOImpl().edit(can);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void eliminarEstudio(EstudioDTO estudio) throws SilsagException {
		log.info("eliminarEstudio");

		try {
			CandidatoDTO can=estudio.getBemCandidato();
			factoryDAO.getEstudioDAOImpl().remove(estudio);
			if(factoryDAO.getEstudioDAOImpl().getAll(can)!=null)
			{
				Integer es=factoryDAO.getEstudioDAOImpl().getMax(can);
				can.setCanMaxEstudio(es);
			}
			else
			{
				can.setCanMaxEstudio(null);
			}
			factoryDAO.getCandidatoDAOImpl().edit(can);
		} catch (Exception e) {
			log.info("Error al eliminarEstudio {}", e.toString());
			throw new SilsagException("Error al eliminarEstudio");
		}
	}
	
	@Override
	public void agregarExperiencia(ExperienciaDTO experiencia) throws SilsagException {
		log.info("agregarExperiencia");

		try {
			factoryDAO.getExperienciaDAOImpl().create(experiencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void eliminarExperiencia(ExperienciaDTO experiencia) throws SilsagException {
		log.info("eliminarExperiencia");

		try {
			factoryDAO.getExperienciaDAOImpl().remove(experiencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}
	}

	
	@Override
	public void agregarReferencia(ReferenciaDTO referencia) throws SilsagException {
		log.info("agregarHerramientas");

		try {
			factoryDAO.getReferenciaDAOImpl().create(referencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void eliminarReferencia(ReferenciaDTO referencia) throws SilsagException {
		log.info("eliminarReferencia");

		try {
			factoryDAO.getReferenciaDAOImpl().remove(referencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}
	}
	
//	@Override
//	public List<EstudioListDTO> obtenerEstudio(CandidatoDTO candidato)throws SilsagException {
//		try {
//			return factoryDAO.getEstudioDAOImpl().getAll(candidato);
//		} catch (Exception e) {
//			log.info("Error al obtener datos de Estudio {}", e.toString());
//			throw new SilsagException("Error al registrar el Candidato");
//
//		}
//	}
//
//	@Override
//	public List<CandidatoDatoDTO> obtenerCandidatoDato(CandidatoDTO candidato)throws SilsagException {
//		try {
//			return factoryDAO.getCandidatoDAOImpl().getData(candidato);
//		} catch (Exception e) {
//			log.info("Error al obtener datos de Estudio {}", e.toString());
//			throw new SilsagException("Error al registrar el Candidato");
//
//		}
//	}
//	
//	@Override
//	public List<CandidatoEstudioDTO> obtenerCandidatoEstudio(CandidatoDTO candidato)throws SilsagException {
//		try {
//			List<CandidatoEstudioDTO> list=factoryDAO.getCandidatoDAOImpl().getCandidatoEstudio(candidato);
//			CandidatoDTO can=new CandidatoDTO();
//			can.setCanCodigo(candidato.getCanCodigo());
//			list.get(0).setCanEstudios(obtenerEstudio(can));
//			list.get(0).setCanExperiencia(obtenerExperiencia(can));
//			return list;
//		} catch (Exception e) {
//			log.info("Error al obtener datos de Estudio {}", e.toString());
//			throw new SilsagException("Error al registrar el Candidato");
//
//		}
//	}
	

	@Override
	public List<ExperienciaListDTO> obtenerExperiencia(CandidatoDTO candidato)throws SilsagException {
		try {
			return factoryDAO.getExperienciaDAOImpl().getAll(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");

		}
	}

	

	@Override
	public List<ReferenciaDTO> obtenerReferencia(CandidatoDTO candidato)throws SilsagException {
		try {
			return factoryDAO.getReferenciaDAOImpl().getAll(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
	}

	
	@Override
	public List<AvisoDTO> verOfertas(CandidatoDTO candidatoDTO) throws SilsagException
	{
		try {
			return factoryDAO.getAvisoDAOImpl().getOfertas(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsagException("Error al obtener datos Ofertas");

		}
	}
	
	@Override
	public PostulacionDTO postular(PostulacionDTO postulacionDTO) throws SilsagException{
		try {
			return factoryDAO.getPostulacionDAOImpl().create(postulacionDTO);
		} catch (Exception e) {
			log.info("Error al insertar postulacion {}", e.toString());
			throw new SilsagException("Error al insertar postulacion");
		}
		
	}
	
	@Override
	public CandidatoDTO obtenerCandidato(Object id)throws SilsagException {

		log.info("obtenerCandidato");

		try {
			return factoryDAO.getCandidatoDAOImpl().find(id);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public List<ResultadoDTO> obtenerResutado(CandidatoDTO candidatoDTO)throws SilsagException
	{
		log.info("obtenerResutado");
		try {
			return factoryDAO.getResultadoDAOImpl().getAll(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
		
	}
	
	
	@Override
	public List<PreguntaDTO> obtenerPregunta()throws SilsagException
	{
		log.info("obtenerPregunta");
		try {
			return factoryDAO.getPreguntaDAOImpl().getAll();
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
		
	}
	
	@Override
	public void guardarResultados(Object[] respuestas,Map<Integer, String> respuestaTexto,CandidatoDTO candidatoDTO)
	{
		log.info("guardarResultados");	
		
		RespuestaDTO respuesta;

		ResultadoDTO resul;
		
		for(int i=0; i<respuestas.length;i++)
		{
			if(respuestas[i]!=null)
			{
				resul=new ResultadoDTO();
				respuesta=new RespuestaDTO();
				respuesta.setResCodigo(Integer.valueOf(respuestas[i].toString()));
				resul.setBemRespuesta(respuesta);
				resul.setBemCandidato(candidatoDTO);
				factoryDAO.getResultadoDAOImpl().create(resul);
			}
		}
		
		for(Integer integ:respuestaTexto.keySet())
		{
			if(respuestaTexto.get(integ)!=null)
			{
				resul=new ResultadoDTO();
				respuesta=new RespuestaDTO();
				respuesta.setResCodigo(integ);
				resul.setBemRespuesta(respuesta);
				resul.setBemCandidato(candidatoDTO);
				resul.setRsuAdicional(respuestaTexto.get(integ));
				factoryDAO.getResultadoDAOImpl().create(resul);
			}
		}
		
	}
	
	
	@Override
	public List<RespuestaDTO> obtenerRespuestaPorTipo(int tipo)throws SilsagException
	{
		log.info("obtenerRespuestaPorTipo");
		try {
			return factoryDAO.getRespuestaDAOImpl().getByType(tipo);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
		
	}
	
	
	@Override
	public List<RespuestaDTO> obtenerRespuesta()throws SilsagException
	{
		log.info("obtenerRespuesta");
		try {
			return factoryDAO.getRespuestaDAOImpl().getAll();
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
		
	}
	
	
	@Override
	public CursoDTO agregarCurso(CursoDTO cursoDTO)throws SilsagException
	{
		log.info("agregarCurso");
		try {
			return factoryDAO.getCursoDAOImpl().create(cursoDTO);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
	}
	
	@Override
	public void eliminarCurso(CursoDTO cursoDTO)throws SilsagException
	{
		log.info("eliminarCurso");
		try {
			factoryDAO.getCursoDAOImpl().remove(cursoDTO);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
	}
	
	@Override
	public List<CursoDTO> obtenerCurso(CandidatoDTO candidatoDTO)throws SilsagException
	{
		log.info("obtenerCurso");
		try {
			return factoryDAO.getCursoDAOImpl().getAll(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
		
	}


	@Override
	public AdicionalDTO agregarAdicional(AdicionalDTO adicionalDTO)throws SilsagException
	{
		log.info("agregarAdicional");
		try {
			return factoryDAO.getAdicionalDAOImpl().create(adicionalDTO);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
	}

	@Override
	public void eliminarAdicional(AdicionalDTO adicionalDTO)throws SilsagException
	{
		log.info("eliminarAdicional");
		try {
			factoryDAO.getAdicionalDAOImpl().remove(adicionalDTO);;
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
	}
	
	@Override
	public List<AdicionalDTO> obtenerAdicional(CandidatoDTO candidatoDTO)throws SilsagException
	{
		log.info("obtenerAdicional");
		try {
			return factoryDAO.getAdicionalDAOImpl().getAll(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsagException("Error al obtener datos de Herramientas "+e.toString());

		}
		
	}

	
	@Override
	public List<PostulacionDTO> obtenerPostulacion(CandidatoDTO candidatoDTO)throws SilsagException
	{
		log.info("obtenerPostulacion");
		try {
			return factoryDAO.getPostulacionDAOImpl().getAll(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al obtenerPostulacion {}", e.toString());
			throw new SilsagException("Error al obtenerPostulacion "+e.toString());

		}
		
	}

	
}
