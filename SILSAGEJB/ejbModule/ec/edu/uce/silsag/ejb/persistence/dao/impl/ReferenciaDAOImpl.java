package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.ejb.persistence.dao.ReferenciaDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;

public class ReferenciaDAOImpl extends AbstractFacadeImpl<ReferenciaDTO> implements ReferenciaDAO{

	public ReferenciaDAOImpl() {
		super();
	}

	public ReferenciaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ReferenciaDTO> getAll(CandidatoDTO candidato)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ReferenciaDTO> cq=cb.createQuery(ReferenciaDTO.class);
		Root<ReferenciaDTO> from = cq.from(ReferenciaDTO.class);
		
		Path<ReferenciaDTO> join=from.join("bemCandidato").get("canCodigo");
		
		cq.where(cb.and(cb.equal(join, candidato.getCanCodigo())));
		
		List<ReferenciaDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
