package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import net.ciespal.redxxi.ejb.persistence.dao.RedDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;

import com.corvustec.commons.util.CorvustecException;

public class RedDAOImpl extends AbstractFacadeImpl<RedDTO> implements RedDAO {

	public RedDAOImpl() {
		super();
	}

	public RedDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<RedDTO> getAll() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<RedDTO> cq=cb.createQuery(RedDTO.class);
		cq.from(RedDTO.class);
		
		List<RedDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}	

	
}
