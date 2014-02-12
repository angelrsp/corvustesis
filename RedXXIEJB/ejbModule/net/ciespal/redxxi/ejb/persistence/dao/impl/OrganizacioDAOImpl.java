package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.OrganizacioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

public class OrganizacioDAOImpl extends AbstractFacadeImpl<OrganizacionDTO> implements OrganizacioDAO {

	public OrganizacioDAOImpl() {
		super();
	}

	public OrganizacioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<OrganizacionDTO> getAll(Object ubicacion)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<OrganizacionDTO> cq=cb.createQuery(OrganizacionDTO.class);
		Root<OrganizacionDTO> from = cq.from(OrganizacionDTO.class);
				
		cq.where(cb.equal(from.get("orgUbicacion"), ubicacion));
		
		List<OrganizacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
