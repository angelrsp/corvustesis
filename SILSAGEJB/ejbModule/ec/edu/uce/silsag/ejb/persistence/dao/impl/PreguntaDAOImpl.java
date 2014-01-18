package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.ejb.persistence.dao.PreguntaDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;

public class PreguntaDAOImpl extends AbstractFacadeImpl<PreguntaDTO> implements PreguntaDAO{

	public PreguntaDAOImpl() {
		super();
	}

	public PreguntaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	@Override
	public List<PreguntaDTO> getAll()
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PreguntaDTO> cq=cb.createQuery(PreguntaDTO.class);
		Root<PreguntaDTO> from= cq.from(PreguntaDTO.class);
		cq.orderBy(cb.asc(from.get("preCodigo")));
		
		List<PreguntaDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
