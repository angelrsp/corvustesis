package ec.edu.uce.silsag.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;

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

}
