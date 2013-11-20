package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsae.ejb.persistence.dao.SoftwareDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareDTO;

public class SoftwareDAOImpl extends AbstractFacadeImpl<SoftwareDTO> implements SoftwareDAO{

	public SoftwareDAOImpl() {
		super();
	}

	public SoftwareDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<SoftwareDTO> getAll(CandidatoDTO candidato)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<SoftwareDTO> cq=cb.createQuery(SoftwareDTO.class);
		Root<SoftwareDTO> from = cq.from(SoftwareDTO.class);
		
		Path<CandidatoDTO> join=from.join("bemCandidato").get("canCodigo");
		
		cq.where(cb.and(cb.equal(join, candidato.getCanCodigo())));
		
		List<SoftwareDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
