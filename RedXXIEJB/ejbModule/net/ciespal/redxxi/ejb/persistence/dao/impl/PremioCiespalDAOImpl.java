package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.PremioCiespalDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;

import com.corvustec.commons.util.CorvustecException;

public class PremioCiespalDAOImpl extends AbstractFacadeImpl<PremioCiespalDTO> implements PremioCiespalDAO{

	public PremioCiespalDAOImpl() {
		super();
		
	}

	public PremioCiespalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	
	}

	
	@Override
	public List<PremioCiespalDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PremioCiespalDTO> cq=cb.createQuery(PremioCiespalDTO.class);
		Root<PremioCiespalDTO> from= cq.from(PremioCiespalDTO.class);
		
		cq.where(cb.equal(from.get("pciCiudad"), ciudad));
		
		List<PremioCiespalDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
