package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.ContactoArgosDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.EntidadArgosDTO;

import com.corvustec.commons.util.CorvustecException;

public class ContactoArgosDAOImpl extends AbstractFacadeImpl<ContactoArgosDTO> implements ContactoArgosDAO {

	public ContactoArgosDAOImpl() {
		super();
	}

	public ContactoArgosDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ContactoArgosListDTO> getAll(EntidadArgosDTO entidad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoArgosListDTO> cq=cb.createQuery(ContactoArgosListDTO.class);
		Root<ContactoArgosListDTO> from = cq.from(ContactoArgosListDTO.class);
		
		cq.where(cb.equal(from.get("entCodigo"), entidad.getEntCodigo()));
		
		List<ContactoArgosListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
