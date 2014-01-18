package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.ejb.persistence.dao.AdicionalDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;

public class AdicionalDAOImpl extends AbstractFacadeImpl<AdicionalDTO> implements AdicionalDAO{

	public AdicionalDAOImpl() {
		super();
	}

	public AdicionalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<AdicionalDTO> getAll(CandidatoDTO candidatoDTO)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<AdicionalDTO> cq=cb.createQuery(AdicionalDTO.class);
		Root<AdicionalDTO> from = cq.from(AdicionalDTO.class);
		Path<AdicionalDTO> join=from.join("bemCandidato").get("canCodigo");
		
		cq.where(cb.and(cb.equal(join, candidatoDTO.getCanCodigo())));
		
		List<AdicionalDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
}
