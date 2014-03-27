package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.PremioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

import com.corvustec.commons.util.CorvustecException;

public class PremioDAOImpl extends AbstractFacadeImpl<PremioDTO> implements PremioDAO {

	public PremioDAOImpl() {
		super();
		
	}

	public PremioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}
	
	@Override
	public List<PremioDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PremioDTO> cq=cb.createQuery(PremioDTO.class);
		Root<PremioDTO> from= cq.from(PremioDTO.class);
		
		cq.where(cb.equal(from.get("preCiudad"), ciudad));
		
		List<PremioDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
