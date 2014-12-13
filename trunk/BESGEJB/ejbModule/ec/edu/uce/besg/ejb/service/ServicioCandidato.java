package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.CandidatoListDTO;
import ec.edu.uce.besg.ejb.entity.ExperienciaDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.entity.ReferenciaDTO;

@Local
public interface ServicioCandidato {

	CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO)
			throws SecurityException;

	List<CandidatoListDTO> obtenerCandidato(CandidatoListDTO candidatoListDTO)
			throws SecurityException;

	void agregarHabilidad(HabilidadDTO habilidad) throws SecurityException;

	void eliminarHabilidad(HabilidadDTO habilidad) throws SecurityException;

	void agregarExperiencia(ExperienciaDTO experiencia)
			throws SecurityException;

	void eliminarExperiencia(ExperienciaDTO experiencia)
			throws SecurityException;

	void agregarReferencia(ReferenciaDTO referencia) throws SecurityException;

	void eliminarReferencia(ReferenciaDTO referencia) throws SecurityException;


}
