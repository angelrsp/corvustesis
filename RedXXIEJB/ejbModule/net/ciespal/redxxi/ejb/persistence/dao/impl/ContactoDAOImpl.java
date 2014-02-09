package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.ContactoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;

public class ContactoDAOImpl extends AbstractFacadeImpl<ContactoDTO> implements ContactoDAO {

	public ContactoDAOImpl() {
		super();
	}

	public ContactoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

//	@Override
//	public List<ContactoDTO> getAll(EntidadDTO entidad) throws CorvustecException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<ContactoDTO> cq=cb.createQuery(ContactoDTO.class);
//		Root<ContactoDTO> from = cq.from(ContactoDTO.class);
//		
//		Path<EntidadDTO> join=from.join("ateEntidads").get("entCodigo");
//		
//		cq.where(cb.and(cb.equal(join, entidad.getEntCodigo())));
//		
//		List<ContactoDTO> list=entityManager.createQuery(cq).getResultList();
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}
	
	@Override
	public List<ContactoListDTO> getAll(EntidadDTO entidad)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoListDTO> cq=cb.createQuery(ContactoListDTO.class);
		Root<ContactoListDTO> from = cq.from(ContactoListDTO.class);
		
		cq.where(cb.equal(from.get("entCodigo"), entidad.getEntCodigo()));
		
		List<ContactoListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
