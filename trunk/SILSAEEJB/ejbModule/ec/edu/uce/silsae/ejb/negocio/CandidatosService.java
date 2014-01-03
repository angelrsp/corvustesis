package ec.edu.uce.silsae.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareListDTO;

@Local
public interface CandidatosService {
	
	/**
	 * Registrar <code>UsuarioDTO</code> en el sistema
	 * @return
	 */
	CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO) throws SilsaeException;

	void agregarEstudio(EstudioDTO estudio) throws SilsaeException;

	List<EstudioListDTO> obtenerEstudio(CandidatoDTO candidato)
			throws SilsaeException;

	List<ExperienciaListDTO> obtenerExperiencia(CandidatoDTO candidato)
			throws SilsaeException;

	void agregarExperiencia(ExperienciaDTO experiencia) throws SilsaeException;

	List<AvisoListDTO> verOfertas() throws SilsaeException;

	PostulacionDTO postular(PostulacionDTO postulacionDTO)
			throws SilsaeException;

	void agregarHerramientas(SoftwareDTO software) throws SilsaeException;

	List<SoftwareListDTO> obtenerHerramientas(CandidatoDTO candidato)
			throws SilsaeException;

	void agregarIdioma(IdiomaDTO idioma) throws SilsaeException;

	void agregarReferencia(ReferenciaDTO referencia) throws SilsaeException;

	List<IdiomaListDTO> obtenerIdioma(CandidatoDTO candidato)
			throws SilsaeException;

	List<ReferenciaDTO> obtenerReferencia(CandidatoDTO candidato)
			throws SilsaeException;

	CandidatoDTO actualizarCandidato(CandidatoDTO candidatoDTO)
			throws SilsaeException;

	void eliminarEstudio(EstudioDTO estudio) throws SilsaeException;

	void eliminarExperiencia(ExperienciaDTO experiencia) throws SilsaeException;

	void eliminarHerramientas(SoftwareDTO software) throws SilsaeException;

	void eliminarIdioma(IdiomaDTO idioma) throws SilsaeException;

	void eliminarReferencia(ReferenciaDTO referencia) throws SilsaeException;

	CandidatoDTO obtenerCandidato(Object id) throws SilsaeException;

	List<CandidatoDatoDTO> obtenerCandidatoDato(CandidatoDTO candidato)
			throws SilsaeException;
}
