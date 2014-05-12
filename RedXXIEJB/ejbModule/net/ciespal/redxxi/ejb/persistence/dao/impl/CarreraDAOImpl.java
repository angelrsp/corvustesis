package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class CarreraDAOImpl extends AbstractFacadeImpl<CarreraDTO> implements CarreraDAO{

	private static final Logger logger = LoggerFactory.getLogger(CarreraDAOImpl.class);
	
	public CarreraDAOImpl() {
		super();
	}

	public CarreraDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<CarreraDTO> getAll(CentroDTO centro,Object tipo) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		Path<CentroDTO> join1=from.join("ateCentro");
		
		cq.where(cb.and(cb.equal(join1.get("cenCodigo"), centro.getCenCodigo()),cb.equal(from.get("carTipo"), tipo)));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@Override
	public List<CarreraDTO> getByType(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		cq.where(cb.equal(from.get("carTipo"), type));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CarreraDTO>();
		else
			return list;
	}
	

	@Override
	public Integer getPregradoCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<CarreraDTO> cq;
		Root<CarreraDTO> from;
		List<CarreraDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(CarreraDTO.class);
		
			from= cq.from(CarreraDTO.class);
			Path<CentroDTO> join1=from.join("ateCentro");
			
			cq.multiselect(cb.count(from.get("carCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			
			predicate=cb.equal(from.get("carTipo"), 6);
			predicateList.add(predicate);
			
			if(pais!=null)
			{
				predicate=cb.equal(join1.get("cenPais"), pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<CarreraDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getCarCount();
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
	public Integer getPosgradoCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<CarreraDTO> cq;
		Root<CarreraDTO> from;
		List<CarreraDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(CarreraDTO.class);
		
			from= cq.from(CarreraDTO.class);
			Path<CentroDTO> join1=from.join("ateCentro");
			
			cq.multiselect(cb.count(from.get("carCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			
			predicate=cb.equal(from.get("carTipo"), 7);
			predicateList.add(predicate);
			
			if(pais!=null)
			{
				predicate=cb.equal(join1.get("cenPais"), pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<CarreraDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getCarCount();
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
	public List<CarreraDTO> getAll(Object type,Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		Path<CentroDTO> join1=from.join("ateCentro");
		
		cq.where(cb.and(cb.equal(join1.get("cenPais"), pais),cb.equal(from.get("carTipo"), type)));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CarreraDTO>();
		else
			return list;
	}
	
	@Override
	public List<CentroDTO> distinctPais(Object type,Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from = cq.from(CentroDTO.class);
		
		Path<CarreraDTO> join1= from.join("ateCarreras");
		
		cq.multiselect(from.get("cenPais")).distinct(true);
		
		cq.where(cb.and(cb.equal(from.get("cenPais"), pais),cb.equal(join1.get("carTipo"), type)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CentroDTO>();
		else
			return list;
	}
	
	@Override
	public List<CentroDTO> distinctPais(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from = cq.from(CentroDTO.class);
		
		Path<CarreraDTO> join1= from.join("ateCarreras");
		
		cq.multiselect(from.get("cenPais")).distinct(true);
		
		cq.where(cb.equal(join1.get("carTipo"), type));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CentroDTO>();
		else
			return list;
	}
	
	@Override
	public List<CentroDTO> distinctUniversidad(Object type,Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from = cq.from(CentroDTO.class);
		
		Path<CarreraDTO> join1= from.join("ateCarreras");
		
		cq.multiselect(from.get("cenCodigo")).distinct(true);
		
		cq.where(cb.and(cb.equal(join1.get("carTipo"), type),cb.equal(from.get("cenPais"), pais)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CentroDTO>();
		else
			return list;
	}

	@Override
	public void remove2(CarreraDTO carrera) throws CorvustecException
	{
		Query query;
		query=entityManager.createQuery("delete from CarreraDTO car where car.carCodigo=:codigo");
		query.setParameter("codigo", carrera.getCarCodigo());
		query.executeUpdate();
	}
}
