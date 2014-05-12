package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.CentroDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.FacultadListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.UniversidadListDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class CentroDAOImpl extends AbstractFacadeImpl<CentroDTO> implements CentroDAO{

	private static final Logger logger = LoggerFactory.getLogger(CentroDAOImpl.class);
	
	
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
			return new ArrayList<CentroDTO>();
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

	@Override
	public List<UniversidadListDTO> getUniversidad() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<UniversidadListDTO> cq=cb.createQuery(UniversidadListDTO.class);
		Root<UniversidadListDTO> from= cq.from(UniversidadListDTO.class);
		
		cq.where(cb.equal(from.get("cenTipo"),2));
		
		List<UniversidadListDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return new ArrayList<UniversidadListDTO>();
		else
			return list;
	}
	
	@Override
	public List<CentroDTO> getCentro(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.equal(from.get("cenTipo"),type));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return list;
		else
			return new ArrayList<CentroDTO>();
	}

		
	@Override
	public Integer getUniversidadCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<CentroDTO> cq;
		Root<CentroDTO> from;
		List<CentroDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(CentroDTO.class);
			
			from= cq.from(CentroDTO.class);
			
			cq.multiselect(cb.count(from.get("cenCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			
			predicate= cb.equal(from.get("cenTipo"),2);
			predicateList.add(predicate);
			
			if(pais!=null)
			{
				predicate=cb.equal(from.get("cenPais"),pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<CentroDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getCenCount();
			else
				return 0;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}
	
	@Override
	public List<FacultadListDTO> getFacultad() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<FacultadListDTO> cq=cb.createQuery(FacultadListDTO.class);
		Root<FacultadListDTO> from= cq.from(FacultadListDTO.class);
		
		cq.where(cb.equal(from.get("cenTipo"),3));
		
		List<FacultadListDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return new ArrayList<FacultadListDTO>();
		else
			return list;
	}

	
	@Override
	public List<FacultadListDTO> getUniversidad(Object code) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<FacultadListDTO> cq=cb.createQuery(FacultadListDTO.class);
		Root<FacultadListDTO> from= cq.from(FacultadListDTO.class);
		
		cq.where(cb.equal(from.get("cenCodigo"),code));
		
		List<FacultadListDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return new ArrayList<FacultadListDTO>();
		else
			return list;
	}

		
	@Override
	public Integer getFacultadCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<CentroDTO> cq;
		Root<CentroDTO> from;
		List<CentroDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(CentroDTO.class);
			
			from= cq.from(CentroDTO.class);
			
			cq.multiselect(cb.count(from.get("cenCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			
			predicate= cb.equal(from.get("cenTipo"),3);
			predicateList.add(predicate);
			
			if(pais!=null)
			{
				predicate=cb.equal(from.get("cenPais"),pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<CentroDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getCenCount();
			else
				return 0;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}
	
	
	@Override
	public List<CentroDTO> getCentro(Object type,Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.where(cb.and(cb.equal(from.get("cenTipo"),type),cb.equal(from.get("cenPais"), pais)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return list;
		else
			return new ArrayList<CentroDTO>();
	}
	
	
	@Override
	public List<CentroDTO> distinctPais(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from= cq.from(CentroDTO.class);
		
		cq.multiselect(from.get("cenPais")).distinct(true);
		
		cq.where(cb.equal(from.get("cenTipo"),type));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return list;
		else
			return new ArrayList<CentroDTO>();
	}
		
}
