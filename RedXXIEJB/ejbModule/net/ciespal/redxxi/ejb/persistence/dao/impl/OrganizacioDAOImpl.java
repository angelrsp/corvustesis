package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.OrganizacioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

import com.corvustec.commons.util.CorvustecException;

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
				
		cq.where(cb.equal(from.get("orgCiudad"), ubicacion));
		
		List<OrganizacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<OrganizacionDTO> getAll()
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<OrganizacionDTO> cq=cb.createQuery(OrganizacionDTO.class);
		cq.from(OrganizacionDTO.class);
				
		List<OrganizacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<OrganizacionDTO>();
		else
			return list;
	}
	
	@Override
	public Integer getCount()
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<OrganizacionDTO> cq=cb.createQuery(OrganizacionDTO.class);
		Root<OrganizacionDTO> from= cq.from(OrganizacionDTO.class);
				
		cq.multiselect(cb.count(from.get("orgCodigo")));
		
		List<OrganizacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getOrgCount();
		else
			return 0;
	}

	@Override
	public Integer getCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<OrganizacionDTO> cq=cb.createQuery(OrganizacionDTO.class);
		Root<OrganizacionDTO> from= cq.from(OrganizacionDTO.class);
				
		cq.multiselect(cb.count(from.get("orgCodigo")));
		
		cq.where(cb.equal(from.get("orgPais"), pais));
		
		List<OrganizacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getOrgCount();
		else
			return 0;
	}

	
	@Override
	public List<OrganizacionDTO> getAll2(Object pais)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<OrganizacionDTO> cq=cb.createQuery(OrganizacionDTO.class);
		Root<OrganizacionDTO> from= cq.from(OrganizacionDTO.class);
				
		cq.where(cb.equal(from.get("orgPais"), pais));
		
		List<OrganizacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<OrganizacionDTO>();
		else
			return list;
	}
	
	
	@Override
	public void remove2(OrganizacionDTO organizacion) throws CorvustecException
	{
		Query query;
		query=entityManager.createQuery("delete from OrganizacionDTO org where org.orgCodigo=:codigo");
		query.setParameter("codigo", organizacion.getOrgCodigo());
		query.executeUpdate();
	}

}
