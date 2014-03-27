package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.VeeduriaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

import com.corvustec.commons.util.CorvustecException;

public class VeeduriaDAOImpl extends AbstractFacadeImpl<VeeduriaDTO> implements VeeduriaDAO {

	public VeeduriaDAOImpl() {
		super();
	}

	public VeeduriaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<VeeduriaDTO> findAll(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<VeeduriaDTO> cq=cb.createQuery(VeeduriaDTO.class);
		Root<VeeduriaDTO> from= cq.from(VeeduriaDTO.class);
		
		cq.where(cb.equal(from.get("veeCiudad"), ubicacion));
		
		List<VeeduriaDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
