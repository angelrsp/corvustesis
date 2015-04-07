package ec.edu.uce.besg.ejb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.UtilEncryption;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ExperienciaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.persistence.entity.HabilidadListDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ReferenciaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.HistorialPasswordDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.ServicioCandidato;
import ec.edu.uce.besg.ejb.vo.CandidatoVO;

@Stateless
public class ServicioCandidatoImpl implements ServicioCandidato {
	

	private static final Logger logger = LoggerFactory.getLogger(ServicioEmpresaImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	
	@Override
	public CandidatoDTO registrarCandidato(CandidatoVO candidatoVO)throws CorvustecException {
		UsuarioDTO usuarioDTO;
		HistorialPasswordDTO historialPasswordDTO;
		try{
			if(candidatoVO.getCandidatoDTO().getCanCodigo()!=null)
				return factoryDAO.getCandidatoDAOImpl().update(candidatoVO.getCandidatoDTO());
			else
			{
				historialPasswordDTO=new HistorialPasswordDTO();
				candidatoVO.getUsuarioDTO().setUsuPassword(UtilEncryption.getInstancia().encriptar(candidatoVO.getUsuarioDTO().getUsuPassword()));
				candidatoVO.getUsuarioDTO().setUsuMail(candidatoVO.getUsuarioDTO().getUsuLogin());
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().create(candidatoVO.getUsuarioDTO());
				
				historialPasswordDTO.setSegUsuario(usuarioDTO);
				historialPasswordDTO.setHpaFecha(new Timestamp(new Date().getTime()));
				historialPasswordDTO.setHpaPassword(UtilEncryption.getInstancia().encriptar(candidatoVO.getUsuarioDTO().getUsuPassword()));
				
				factoryDAO.getHistorialPasswordDAOImpl().create(historialPasswordDTO);
				
				candidatoVO.getCandidatoDTO().setSegUsuario(usuarioDTO);
				return factoryDAO.getCandidatoDAOImpl().create(candidatoVO.getCandidatoDTO());
			}
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			usuarioDTO=null;
			historialPasswordDTO=null;
		}
	}

	@Override
	public List<CandidatoDTO> obtenerCandidato(CandidatoDTO candidatoDTO)throws CorvustecException {
		//log.info("obtenerCandidato");
		try {
			return factoryDAO.getCandidatoDAOImpl().getByAnd(candidatoDTO);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new CorvustecException(e);
		}

	}
	
	@Override
	public List<HabilidadListDTO> obtenerHabilidad(HabilidadListDTO habilidad) throws CorvustecException
	{
		try {
			return factoryDAO.getHabilidadDAOImpl().getByAnd(habilidad);
		} catch (Exception e) {
			//log.info("Error al registrar Aviso {}", e.toString());
			throw new CorvustecException("Error al obtener catalogo");
		}				
	}
	
	/*@Override
	public CandidatoDTO actualizarCandidato(CandidatoDTO candidatoDTO)throws SilsagException {
		log.info("actualizarCandidato");
		try {
			candidatoDTO.setCanFechaUltima(new Timestamp(new Date().getTime()));
			if(factoryDAO.getEstudioDAOImpl().getAll(candidatoDTO)!=null){
				Integer es=factoryDAO.getEstudioDAOImpl().getMax(candidatoDTO);
				candidatoDTO.setCanMaxEstudio(es);
			}
		
			//ApplicationUtil.saveToDisk(candidatoDTO.getCanFoto());
			
			return factoryDAO.getCandidatoDAOImpl().edit(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}

	}*/	

	
	
	@Override
	public void agregarHabilidad(HabilidadDTO habilidad) throws CorvustecException {
		//log.info("agregarHabilidad");
		try {
			factoryDAO.getHabilidadDAOImpl().create(habilidad);
			CandidatoDTO can=habilidad.getBemCandidato();
		//	Integer es=factoryDAO.getEstudioDAOImpl().getMax(can);
			//can.setCanMaxEstudio(es);
			//can.setCanFechaUltima(new Timestamp(new Date().getTime()));
			factoryDAO.getCandidatoDAOImpl().update(can);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar la Habilidad");
		}
	}
	
	@Override
	public void eliminarHabilidad(HabilidadDTO habilidad) throws CorvustecException {
		//log.info("eliminarEstudio");

		try {
			CandidatoDTO can=habilidad.getBemCandidato();
			factoryDAO.getHabilidadDAOImpl().remove(habilidad);
			/*if(factoryDAO.getCandidatoDAOImpl().getByAndDTO(can)!=null)
			{
				Integer es=factoryDAO.getEstudioDAOImpl().getMax(can);
				can.setCanMaxEstudio(es);
			}
			else
			{
				can.setCanMaxEstudio(null);
			}*/
			factoryDAO.getCandidatoDAOImpl().update(can);
		} catch (Exception e) {
			//log.info("Error al eliminarEstudio {}", e.toString());
			throw new CorvustecException("Error al eliminarHabilidad");
		}
	}
	
	@Override
	public void agregarExperiencia(ExperienciaDTO experiencia) throws CorvustecException {
		//log.info("agregarExperiencia");

		try {
			factoryDAO.getExperienciaDAOImpl().create(experiencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new CorvustecException("Error al agregarExperiencia");
		}
	}
	
	@Override
	public void eliminarExperiencia(ExperienciaDTO experiencia) throws CorvustecException {
		//log.info("eliminarExperiencia");

		try {
			factoryDAO.getExperienciaDAOImpl().remove(experiencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new CorvustecException("Error al eliminarExperiencia");
		}
	}

	
	@Override
	public void agregarReferencia(ReferenciaDTO referencia) throws CorvustecException {
		//log.info("agregarHerramientas");

		try {
			factoryDAO.getReferenciaDAOImpl().create(referencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new CorvustecException("Error al agregarReferencia");
		}
	}
	
	@Override
	public void eliminarReferencia(ReferenciaDTO referencia) throws CorvustecException {
		//log.info("eliminarReferencia");

		try {
			factoryDAO.getReferenciaDAOImpl().remove(referencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new CorvustecException("Error al eliminarReferencia");
		}
	}
	/*
	@Override
	public List<EstudioListDTO> obtenerEstudio(CandidatoDTO candidato)throws SilsagException {
		try {
			return factoryDAO.getEstudioDAOImpl().getAllList(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");

		}
	}
*/
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
	
/*
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

	
	/*@Override
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
			new MailUtil().send(postulacionDTO.getBemAviso().getBemEmpresa().getBemUsuario().getUsuMail(), "Postulacion", "Nueva postulacion");
			return factoryDAO.getPostulacionDAOImpl().create(postulacionDTO);
		} catch (Exception e) {
			log.info("Error al insertar postulacion {}", e.toString());
			throw new SilsagException("Error al insertar postulacion");
		}
		
	}
	*/
/*	@Override
	public CandidatoDTO obtenerCandidato(Object id)throws SilsagException {
		//log.info("obtenerCandidato");
		try {
			return factoryDAO.getCandidatoDAOImpl().find(id);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsagException("Error al registrar el Candidato");
		}
	}
	*/
	/*
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
*/
	
	/*@Override
	public List<CandidatoEstudioDTO> obtenerCandidatos(int nivelEstudio, int genero) throws SilsagException
	{
		log.info("obtenerCandidatos");
		try{
			return factoryDAO.getCandidatoDAOImpl().getCandidatoEstudio(nivelEstudio,genero);
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsagException("Error al obtenerCandidatos");
		}
	}
	
	
	
	@Override
	public List<AnioEstudioDTO> obtenerAnios() throws SilsagException
	{
		log.info("obtenerAnios");
		try{
			return factoryDAO.getCandidatoDAOImpl().getYearEstudio();
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsagException("Error al obtenerCandidatos");
		}
	}
	
	@Override
	public List<EstudioReportDTO> obtenerNivelReporte(int anio) throws SilsagException
	{
		log.info("obtenerNivelReporte");
		try{
			return factoryDAO.getCandidatoDAOImpl().getNivel(anio);
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsagException("Error al obtenerCandidatos");
		}
	}
	
	@Override
	public List<EstudioReportDTO> obtenerNivelReporte() throws SilsagException
	{
		log.info("obtenerNivelReporte");
		try{
			return factoryDAO.getCandidatoDAOImpl().getNivel();
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsagException("Error al obtenerCandidatos");
		}
	}

	@Override
	public EstudioDTO obtenerEstudio(Object id) throws SilsagException
	{
		log.info("obtenerEstudio");
		try{
			return factoryDAO.getEstudioDAOImpl().find(id);
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsagException("Error al obtenerCandidatos");
		}		
	}
	
	
	@Override
	public ExperienciaDTO obtenerEsperiencia(Object id) throws SilsagException
	{
		log.info("obtenerEstudio");
		try{
			return factoryDAO.getExperienciaDAOImpl().find(id);
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsagException("Error al obtenerCandidatos");
		}		
	
	}
*/
}
