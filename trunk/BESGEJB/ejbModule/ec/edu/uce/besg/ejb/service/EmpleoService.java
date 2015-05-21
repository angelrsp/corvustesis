package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.AvisoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PostulacionDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoPostulacionViewDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CandidatoPostulacionViewDTO;

@Local
public interface EmpleoService {

	AvisoDTO createOrUpdateAviso(AvisoDTO avisoDTO) throws CorvustecException;

	List<AvisoViewDTO> readAviso(AvisoViewDTO avisoViewDTO)
			throws CorvustecException;

	AvisoDTO findAviso(Object object) throws CorvustecException;

	PostulacionDTO createOrUpdatePosulacion(PostulacionDTO postulacionDTO)
			throws CorvustecException;

	List<AvisoPostulacionViewDTO> readAvisoPostulacion(
			AvisoPostulacionViewDTO avisoPostulacionViewDTO)
			throws CorvustecException;

	List<CandidatoPostulacionViewDTO> readCandidatoPostulacion(
			CandidatoPostulacionViewDTO candidatoPostulacionViewDTO)
			throws CorvustecException;

	List<AvisoPostulacionViewDTO> readAvisoPostulacionToday(
			AvisoPostulacionViewDTO avisoPostulacionViewDTO)
			throws CorvustecException;

	
}
