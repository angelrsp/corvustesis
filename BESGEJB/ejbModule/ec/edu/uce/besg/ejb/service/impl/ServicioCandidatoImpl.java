package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.ExperienciaDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadListDTO;
import ec.edu.uce.besg.ejb.entity.ReferenciaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.service.ServicioCandidato;

@Stateless
public class ServicioCandidatoImpl implements ServicioCandidato {
	
	//private static final Logger log = LoggerFactory
		//	.getLogger(ServicioCandidatoImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	
	@Override
	public CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO)throws SecurityException {
		//log.info("registrarCandidato");
		try {
			//UsuarioDTO user = candidatoDTO.getCanUsuario();
			//user.setBemPerfil(factoryDAO.getPerfilDAOImpl().find(1));
			//candidatoDTO.setBemUsuario(user);
			if(factoryDAO.getCandidatoDAOImpl().getByAnd(candidatoDTO).get(0) != null)
				throw new SecurityException("El número de identificación ingresado ya existe en el sistema");
			else
			{
				if(candidatoDTO.getCanCodigo()!=null)
					return factoryDAO.getCandidatoDAOImpl().edit(candidatoDTO);
				else
					return factoryDAO.getCandidatoDAOImpl().create(candidatoDTO);
			}	
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SecurityException(e);
		}

	}

	@Override
	public List<CandidatoDTO> obtenerCandidato(CandidatoDTO candidatoDTO)throws SecurityException {
		//log.info("obtenerCandidato");
		try {
			return factoryDAO.getCandidatoDAOImpl().getByAnd(candidatoDTO);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SecurityException(e);
		}

	}
	
	@Override
	public List<CatalogoDTO> obtenerCatalogo(CatalogoDTO catalogo) throws SecurityException
	{
		try {
			return factoryDAO.getCatalogoDAOImpl().getAll(catalogo);
		} catch (Exception e) {
			//log.info("Error al registrar Aviso {}", e.toString());
			throw new SecurityException("Error al obtener catalogo");
		}				
	}
	
	@Override
	public List<HabilidadListDTO> obtenerHabilidad(HabilidadListDTO habilidad) throws SecurityException
	{
		try {
			return factoryDAO.getHabilidadDAOImpl().getByAnd(habilidad);
		} catch (Exception e) {
			//log.info("Error al registrar Aviso {}", e.toString());
			throw new SecurityException("Error al obtener catalogo");
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
	public void agregarHabilidad(HabilidadDTO habilidad) throws SecurityException {
		//log.info("agregarHabilidad");
		try {
			factoryDAO.getHabilidadDAOImpl().create(habilidad);
			CandidatoDTO can=habilidad.getBemCandidato();
		//	Integer es=factoryDAO.getEstudioDAOImpl().getMax(can);
			//can.setCanMaxEstudio(es);
			//can.setCanFechaUltima(new Timestamp(new Date().getTime()));
			factoryDAO.getCandidatoDAOImpl().edit(can);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SecurityException("Error al registrar la Habilidad");
		}
	}
	
	@Override
	public void eliminarHabilidad(HabilidadDTO habilidad) throws SecurityException {
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
			factoryDAO.getCandidatoDAOImpl().edit(can);
		} catch (Exception e) {
			//log.info("Error al eliminarEstudio {}", e.toString());
			throw new SecurityException("Error al eliminarHabilidad");
		}
	}
	
	@Override
	public void agregarExperiencia(ExperienciaDTO experiencia) throws SecurityException {
		//log.info("agregarExperiencia");

		try {
			factoryDAO.getExperienciaDAOImpl().create(experiencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SecurityException("Error al agregarExperiencia");
		}
	}
	
	@Override
	public void eliminarExperiencia(ExperienciaDTO experiencia) throws SecurityException {
		//log.info("eliminarExperiencia");

		try {
			factoryDAO.getExperienciaDAOImpl().remove(experiencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SecurityException("Error al eliminarExperiencia");
		}
	}

	
	@Override
	public void agregarReferencia(ReferenciaDTO referencia) throws SecurityException {
		//log.info("agregarHerramientas");

		try {
			factoryDAO.getReferenciaDAOImpl().create(referencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SecurityException("Error al agregarReferencia");
		}
	}
	
	@Override
	public void eliminarReferencia(ReferenciaDTO referencia) throws SecurityException {
		//log.info("eliminarReferencia");

		try {
			factoryDAO.getReferenciaDAOImpl().remove(referencia);
		} catch (Exception e) {
			//log.info("Error al registrar el Candidato {}", e.toString());
			throw new SecurityException("Error al eliminarReferencia");
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
