package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsae.ejb.persistence.dao.IdiomaDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaDTO;

public class IdiomaDAOImpl extends AbstractFacadeImpl<IdiomaDTO> implements IdiomaDAO{

	public IdiomaDAOImpl() {
		super();
	}

	public IdiomaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<IdiomaDTO> getAll(CandidatoDTO candidato)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IdiomaDTO> cq=cb.createQuery(IdiomaDTO.class);
		Root<IdiomaDTO> from = cq.from(IdiomaDTO.class);
		
		Path<CandidatoDTO> join=from.join("bemCandidato").get("canCodigo");
		
		cq.where(cb.and(cb.equal(join, candidato.getCanCodigo())));
		
		List<IdiomaDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
}
