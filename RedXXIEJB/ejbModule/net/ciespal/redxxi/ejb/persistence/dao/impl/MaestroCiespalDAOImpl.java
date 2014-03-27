package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.MaestroCiespalDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;

import com.corvustec.commons.util.CorvustecException;

public class MaestroCiespalDAOImpl extends AbstractFacadeImpl<MaestroCiespalDTO> implements MaestroCiespalDAO {

	public MaestroCiespalDAOImpl() {
		super();
	}

	public MaestroCiespalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<MaestroCiespalDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<MaestroCiespalDTO> cq=cb.createQuery(MaestroCiespalDTO.class);
		Root<MaestroCiespalDTO> from= cq.from(MaestroCiespalDTO.class);
		
		cq.where(cb.equal(from.get("mciCiudad"), ciudad));
		
		List<MaestroCiespalDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
