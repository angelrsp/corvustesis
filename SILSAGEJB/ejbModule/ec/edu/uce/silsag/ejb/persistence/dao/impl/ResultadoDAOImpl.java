package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.commons.dto.util.ResultadoReportDTO;
import ec.edu.uce.silsag.ejb.persistence.dao.ResultadoDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.RespuestaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoListDTO;

public class ResultadoDAOImpl extends AbstractFacadeImpl<ResultadoDTO> implements ResultadoDAO{

	public ResultadoDAOImpl() {
		super();
	}

	public ResultadoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ResultadoDTO> getAll(CandidatoDTO candidatoDTO)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ResultadoDTO> cq=cb.createQuery(ResultadoDTO.class);
		Root<ResultadoDTO> from = cq.from(ResultadoDTO.class);
		
		Path<CandidatoDTO> join=from.join("bemCandidato").get("canCodigo");
		
		cq.where(cb.equal(join, candidatoDTO.getCanCodigo()));
		
		List<ResultadoDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;

	}

	@Override
	public List<ResultadoListDTO> getAllByRespuesta(RespuestaDTO respuesta)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ResultadoListDTO> cq=cb.createQuery(ResultadoListDTO.class);
		Root<ResultadoListDTO> from = cq.from(ResultadoListDTO.class);
				
		cq.where(cb.equal(from.get("resCodigo"), respuesta.getResCodigo()));
		
		List<ResultadoListDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;

	}

	@Override
	public List<ResultadoReportDTO> getAllByPregunta(PreguntaDTO pregunta)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ResultadoReportDTO> cq=cb.createQuery(ResultadoReportDTO.class);
		Root<ResultadoListDTO> from = cq.from(ResultadoListDTO.class);
		
		//Se puede mapear directamente en ResultadoListDTO por el momento se creo un pojo secundario las columnas en el multiselect
		//deben estar en un constructor
		cq.multiselect(cb.count(from.get("resCodigo")).alias("cantidad"),from.get("resCodigo"),from.get("resDescripcion"));
		
		cq.where(cb.equal(from.get("preCodigo"), pregunta.getPreCodigo()));
		
		cq.groupBy(from.get("resCodigo"),from.get("resDescripcion"));
		
		List<ResultadoReportDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;

	}

}
