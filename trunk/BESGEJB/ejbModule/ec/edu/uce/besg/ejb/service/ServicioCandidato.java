package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.ExperienciaDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.entity.HabilidadListDTO;
import ec.edu.uce.besg.ejb.entity.ReferenciaDTO;

@Local
public interface ServicioCandidato {

	CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO)
			throws CorvustecException;

	void agregarHabilidad(HabilidadDTO habilidad) throws CorvustecException;

	void eliminarHabilidad(HabilidadDTO habilidad) throws CorvustecException;

	void agregarExperiencia(ExperienciaDTO experiencia)
			throws CorvustecException;

	void eliminarExperiencia(ExperienciaDTO experiencia)
			throws CorvustecException;

	void agregarReferencia(ReferenciaDTO referencia) throws CorvustecException;

	void eliminarReferencia(ReferenciaDTO referencia) throws CorvustecException;

	List<CandidatoDTO> obtenerCandidato(CandidatoDTO candidatoDTO)
			throws CorvustecException;

	List<HabilidadListDTO> obtenerHabilidad(HabilidadListDTO habilidad)
			throws CorvustecException;


}
