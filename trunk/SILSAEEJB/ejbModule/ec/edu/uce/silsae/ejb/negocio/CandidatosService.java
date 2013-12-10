package ec.edu.uce.silsae.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionDTO;

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
}
