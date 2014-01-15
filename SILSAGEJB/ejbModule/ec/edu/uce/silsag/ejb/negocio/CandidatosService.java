package ec.edu.uce.silsag.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.IdiomaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.IdiomaListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.SoftwareDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.SoftwareListDTO;

@Local
public interface CandidatosService {
	
	/**
	 * Registrar <code>UsuarioDTO</code> en el sistema
	 * @return
	 */
	CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO) throws SilsagException;

	void agregarEstudio(EstudioDTO estudio) throws SilsagException;

	List<EstudioListDTO> obtenerEstudio(CandidatoDTO candidato)
			throws SilsagException;

	List<ExperienciaListDTO> obtenerExperiencia(CandidatoDTO candidato)
			throws SilsagException;

	void agregarExperiencia(ExperienciaDTO experiencia) throws SilsagException;

	List<AvisoListDTO> verOfertas() throws SilsagException;

	PostulacionDTO postular(PostulacionDTO postulacionDTO)
			throws SilsagException;

	void agregarHerramientas(SoftwareDTO software) throws SilsagException;

	List<SoftwareListDTO> obtenerHerramientas(CandidatoDTO candidato)
			throws SilsagException;

	void agregarIdioma(IdiomaDTO idioma) throws SilsagException;

	void agregarReferencia(ReferenciaDTO referencia) throws SilsagException;

	List<IdiomaListDTO> obtenerIdioma(CandidatoDTO candidato)
			throws SilsagException;

	List<ReferenciaDTO> obtenerReferencia(CandidatoDTO candidato)
			throws SilsagException;

	CandidatoDTO actualizarCandidato(CandidatoDTO candidatoDTO)
			throws SilsagException;

	void eliminarEstudio(EstudioDTO estudio) throws SilsagException;

	void eliminarExperiencia(ExperienciaDTO experiencia) throws SilsagException;

	void eliminarHerramientas(SoftwareDTO software) throws SilsagException;

	void eliminarIdioma(IdiomaDTO idioma) throws SilsagException;

	void eliminarReferencia(ReferenciaDTO referencia) throws SilsagException;

	CandidatoDTO obtenerCandidato(Object id) throws SilsagException;

	List<CandidatoDatoDTO> obtenerCandidatoDato(CandidatoDTO candidato)
			throws SilsagException;

	List<CandidatoEstudioDTO> obtenerCandidatoEstudio(CandidatoDTO candidato)
			throws SilsagException;
}
