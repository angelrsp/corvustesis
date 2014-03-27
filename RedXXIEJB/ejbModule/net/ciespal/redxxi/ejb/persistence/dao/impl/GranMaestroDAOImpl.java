package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.GranMaestroDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;

import com.corvustec.commons.util.CorvustecException;

public class GranMaestroDAOImpl extends AbstractFacadeImpl<GranMaestroDTO> implements GranMaestroDAO{

	public GranMaestroDAOImpl() {
		super();
	}

	public GranMaestroDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<GranMaestroDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<GranMaestroDTO> cq=cb.createQuery(GranMaestroDTO.class);
		Root<GranMaestroDTO> from= cq.from(GranMaestroDTO.class);
		
		cq.where(cb.equal(from.get("gmaCiudad"), ciudad));
		
		List<GranMaestroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
