package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ControlDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ResultadoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CuestionarioViewDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;

@Local
public interface CuestionarioService {

	List<CuestionarioViewDTO> readCuestionario(
			CuestionarioViewDTO cuestionarioViewDTO) throws CorvustecException;

	List<PreguntaDTO> readPregunta(PreguntaDTO preguntaDTO)
			throws CorvustecException;

	List<RespuestaDTO> readRespuesta(RespuestaDTO respuestaDTO)
			throws CorvustecException;

	EncuestaDTO createOrUpdateEncuesta(EncuestaDTO encuestaDTO)
			throws CorvustecException;

	List<EncuestaDTO> readEncuesta(EncuestaDTO encuestaDTO)
			throws CorvustecException;

	List<CategoriaDTO> readCategoria(CategoriaDTO categoriaDTO)
			throws CorvustecException;

	CategoriaDTO createOrUpdateCategoria(CategoriaDTO categoriaDTO)
			throws CorvustecException;

	PreguntaDTO createOrUpdatePregunta(PreguntaDTO preguntaDTO)
			throws CorvustecException;

	RespuestaDTO createOrUpdateRespuesta(RespuestaDTO respuestaDTO)
			throws CorvustecException;

	List<ControlDTO> readControl(ControlDTO controlDTO)
			throws CorvustecException;

	void createOrUpdateResultado(List<ResultadoDTO> resultadoList)
			throws CorvustecException;

	List<ResultadoViewDTO> readResultadoView(ResultadoViewDTO resultadoViewDTO)
			throws CorvustecException;

	List<ResultadoViewDTO> readResultadoCountView(
			ResultadoViewDTO resultadoViewDTO) throws CorvustecException;

	PreguntaDTO readPregunta(Object id) throws CorvustecException;

}
