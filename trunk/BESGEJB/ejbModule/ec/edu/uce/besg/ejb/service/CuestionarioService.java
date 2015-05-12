package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CuestionarioViewDTO;

@Local
public interface CuestionarioService {

	List<CuestionarioViewDTO> readCuestionario(
			CuestionarioViewDTO cuestionarioViewDTO) throws CorvustecException;

	List<PreguntaDTO> readPregunta(PreguntaDTO preguntaDTO)
			throws CorvustecException;

	List<RespuestaDTO> readRespuesta(RespuestaDTO respuestaDTO)
			throws CorvustecException;

}
