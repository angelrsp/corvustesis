package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsag.commons.dto.util.ResultadoReportDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.RespuestaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoListDTO;

public interface ResultadoDAO extends AbstractFacade<ResultadoDTO>{

	List<ResultadoDTO> getAll(CandidatoDTO candidatoDTO);

	List<ResultadoListDTO> getAllByRespuesta(RespuestaDTO respuesta);

	List<ResultadoReportDTO> getAllByPregunta(PreguntaDTO pregunta);

}
