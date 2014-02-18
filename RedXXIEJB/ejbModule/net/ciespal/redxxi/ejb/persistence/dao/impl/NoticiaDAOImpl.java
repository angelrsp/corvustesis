package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.NoticiaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;

public class NoticiaDAOImpl extends AbstractFacadeImpl<NoticiaDTO> implements NoticiaDAO{

	public NoticiaDAOImpl() {
		super();
	}

	public NoticiaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<NoticiaDTO> getAll()
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaDTO> cq=cb.createQuery(NoticiaDTO.class);
		Root<NoticiaDTO> from = cq.from(NoticiaDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateEntidads",JoinType.LEFT);
		
		cq.where(cb.isNull(join1.get("entCodigo")));
		
		List<NoticiaDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
}
