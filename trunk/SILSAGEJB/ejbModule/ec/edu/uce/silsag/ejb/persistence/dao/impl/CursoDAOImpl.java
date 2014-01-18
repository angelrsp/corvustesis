package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.ejb.persistence.dao.CursoDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CursoDTO;

public class CursoDAOImpl extends AbstractFacadeImpl<CursoDTO> implements CursoDAO{

	public CursoDAOImpl() {
		super();
	}

	public CursoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<CursoDTO> getAll(CandidatoDTO candidatoDTO)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CursoDTO> cq=cb.createQuery(CursoDTO.class);
		Root<CursoDTO> from = cq.from(CursoDTO.class);
		Path<CandidatoDTO> join=from.join("bemCandidato").get("canCodigo");
		
		cq.where(cb.and(cb.equal(join, candidatoDTO.getCanCodigo())));
		
		List<CursoDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
}
