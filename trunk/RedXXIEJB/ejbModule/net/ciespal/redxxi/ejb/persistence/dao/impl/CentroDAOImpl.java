package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.dao.CentroDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

public class CentroDAOImpl extends AbstractFacadeImpl<CentroDTO> implements CentroDAO{

	public CentroDAOImpl() {
		super();
	}

	public CentroDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<CentroDTO> findAllPather() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.isNull(from.join("ateCentro",JoinType.LEFT)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<CentroDTO> findAllPather(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.and(cb.isNull(from.join("ateCentro",JoinType.LEFT)),cb.equal(from.get("cenCiudad"), ubicacion)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<CentroDTO> findAllPatherByCountry(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.and(cb.isNull(from.join("ateCentro",JoinType.LEFT)),cb.equal(from.get("cenPais"), ubicacion)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@Override
	public List<CentroDTO> findAllPatherByProvince(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.and(cb.isNull(from.join("ateCentro",JoinType.LEFT)),cb.equal(from.get("cenProvincia"), ubicacion)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@Override
	public List<CentroDTO> findAllPatherByCity(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.and(cb.isNull(from.join("ateCentro",JoinType.LEFT)),cb.equal(from.get("cenCiudad"), ubicacion)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@Override
	public List<CentroDTO> findAllChild(CentroDTO centro) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.equal(from.get("ateCentro"),centro.getCenCodigo()));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<CentroDTO> findByType(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.equal(from.get("cenTipo"),type));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return new ArrayList<CentroDTO>();
		else
			return list;
	}

}
