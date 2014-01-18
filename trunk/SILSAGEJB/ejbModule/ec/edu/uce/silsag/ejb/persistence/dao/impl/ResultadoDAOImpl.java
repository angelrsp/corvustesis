package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.ejb.persistence.dao.ResultadoDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoDTO;

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
	
}
