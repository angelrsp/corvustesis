package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.LeyDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;

import com.corvustec.commons.util.CorvustecException;

public class LeyDAOImpl extends AbstractFacadeImpl<LeyDTO> implements LeyDAO {

	public LeyDAOImpl() {
		super();
		
	}

	public LeyDAOImpl(EntityManager entityManager) {
		super(entityManager);
	
	}

	
	@Override
	public List<LeyDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<LeyDTO> cq=cb.createQuery(LeyDTO.class);
		Root<LeyDTO> from= cq.from(LeyDTO.class);
		
		cq.where(cb.equal(from.get("leyCiudad"), ciudad));
		
		List<LeyDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
