package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.ExperienciaDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadListDTO;
import ec.edu.uce.besg.ejb.entity.ReferenciaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;

@Local
public interface ServicioCandidato {

	CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO)
			throws SecurityException;

	void agregarHabilidad(HabilidadDTO habilidad) throws SecurityException;

	void eliminarHabilidad(HabilidadDTO habilidad) throws SecurityException;

	void agregarExperiencia(ExperienciaDTO experiencia)
			throws SecurityException;

	void eliminarExperiencia(ExperienciaDTO experiencia)
			throws SecurityException;

	void agregarReferencia(ReferenciaDTO referencia) throws SecurityException;

	void eliminarReferencia(ReferenciaDTO referencia) throws SecurityException;

	List<CatalogoDTO> obtenerCatalogo(CatalogoDTO catalogo)
			throws SecurityException;

	List<CandidatoDTO> obtenerCandidato(CandidatoDTO candidatoDTO)
			throws SecurityException;

	List<HabilidadListDTO> obtenerHabilidad(HabilidadListDTO habilidad)
			throws SecurityException;


}
