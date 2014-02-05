package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.ContactoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;

import com.corvustec.commons.util.CorvustecException;

public class ContactoDAOImpl extends AbstractFacadeImpl<ContactoDTO> implements ContactoDAO {

	public ContactoDAOImpl() {
		super();
	}

	public ContactoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	@Override
	public List<ContactoDTO> getAll(EntidadDTO entidad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoDTO> cq=cb.createQuery(ContactoDTO.class);
		Root<ContactoDTO> from = cq.from(ContactoDTO.class);
		
		Path<EntidadDTO> join=from.join("ateEntidads").get("entCodigo");
		
		cq.where(cb.and(cb.equal(join, entidad.getEntCodigo())));
		
		List<ContactoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
