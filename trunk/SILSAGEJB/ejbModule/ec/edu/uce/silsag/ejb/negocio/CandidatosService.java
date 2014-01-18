package ec.edu.uce.silsag.ejb.negocio;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
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

@Local
public interface CandidatosService {
	
	/**
	 * Registrar <code>UsuarioDTO</code> en el sistema
	 * @return
	 */
	CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO) throws SilsagException;

	void agregarEstudio(EstudioDTO estudio) throws SilsagException;


	void agregarExperiencia(ExperienciaDTO experiencia) throws SilsagException;


	PostulacionDTO postular(PostulacionDTO postulacionDTO)
			throws SilsagException;


	void agregarReferencia(ReferenciaDTO referencia) throws SilsagException;


	List<ReferenciaDTO> obtenerReferencia(CandidatoDTO candidato)
			throws SilsagException;

	CandidatoDTO actualizarCandidato(CandidatoDTO candidatoDTO)
			throws SilsagException;

	void eliminarEstudio(EstudioDTO estudio) throws SilsagException;

	void eliminarExperiencia(ExperienciaDTO experiencia) throws SilsagException;

	void eliminarReferencia(ReferenciaDTO referencia) throws SilsagException;

	CandidatoDTO obtenerCandidato(Object id) throws SilsagException;

	List<ResultadoDTO> obtenerResutado(CandidatoDTO candidatoDTO)
			throws SilsagException;

	List<PreguntaDTO> obtenerPregunta() throws SilsagException;

	List<RespuestaDTO> obtenerRespuestaPorTipo(int tipo) throws SilsagException;

	void guardarResultados(Object[] respuestas,
			Map<Integer, String> respuestaTexto, CandidatoDTO candidatoDTO);

	List<RespuestaDTO> obtenerRespuesta() throws SilsagException;

	List<CursoDTO> obtenerCurso(CandidatoDTO candidatoDTO)
			throws SilsagException;

	CursoDTO agregarCurso(CursoDTO cursoDTO) throws SilsagException;

	AdicionalDTO agregarAdicional(AdicionalDTO adicionalDTO)
			throws SilsagException;

	List<AdicionalDTO> obtenerAdicional(CandidatoDTO candidatoDTO)
			throws SilsagException;

	void eliminarAdicional(AdicionalDTO adicionalDTO) throws SilsagException;

	void eliminarCurso(CursoDTO cursoDTO) throws SilsagException;

	List<ExperienciaListDTO> obtenerExperiencia(CandidatoDTO candidato)
			throws SilsagException;

}
