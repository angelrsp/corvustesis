package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.ejb.persistence.dao.EstudioDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioListDTO;

public class EstudioDAOImpl extends AbstractFacadeImpl<EstudioDTO> implements EstudioDAO{

	public EstudioDAOImpl() {
		super();
	}

	public EstudioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<EstudioDTO> getAll(CandidatoDTO candidato)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EstudioDTO> cq=cb.createQuery(EstudioDTO.class);
		Root<EstudioDTO> from = cq.from(EstudioDTO.class);
		
		Path<CandidatoDTO> join=from.join("bemCandidato").get("canCodigo");
		
		cq.where(cb.and(cb.equal(join, candidato.getCanCodigo())));
		
		List<EstudioDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<EstudioListDTO> getAllList(CandidatoDTO can)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EstudioListDTO> cq=cb.createQuery(EstudioListDTO.class);
		Root<EstudioListDTO> from = cq.from(EstudioListDTO.class);
		cq.where(cb.equal(from.get("estCandidato"), can.getCanCodigo()));
		List<EstudioListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public Integer getMax(CandidatoDTO can)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<Integer> cq=cb.createQuery(Integer.class);
		Root<EstudioDTO> from = cq.from(EstudioDTO.class);
		Path<CandidatoDTO> join=from.join("bemCandidato");
		
		cq.multiselect(cb.max(from.get("estNivel").as(Integer.class)));
		
		cq.where(cb.equal(join, can.getCanCodigo()));
		
		List<Integer> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}
}
