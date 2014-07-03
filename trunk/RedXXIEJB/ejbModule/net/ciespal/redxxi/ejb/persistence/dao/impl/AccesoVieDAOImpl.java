package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.AccesoVieDAO;
import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class AccesoVieDAOImpl extends AbstractFacadeImpl<AccesoVieDTO> implements AccesoVieDAO{

	private static final Logger logger = LoggerFactory.getLogger(AccesoVieDAOImpl.class);
	
	public AccesoVieDAOImpl() {
		super();
	}

	public AccesoVieDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<AccesoVieDTO> getByAnd(AccesoVieDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<AccesoVieDTO> cq;
		Root<AccesoVieDTO> from;
		List<AccesoVieDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(AccesoVieDTO.class);
			
			from= cq.from(AccesoVieDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = objetoDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = objetoDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(objetoDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<AccesoVieDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}
	}

	@Override
	public List<AccesoVieDTO> getByAndPerfilIsNull(AccesoVieDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<AccesoVieDTO> cq;
		Root<AccesoVieDTO> from;
		List<AccesoVieDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(AccesoVieDTO.class);
			
			from= cq.from(AccesoVieDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = objetoDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = objetoDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(objetoDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
	
	    	predicate=cb.isNull(from.get("accPerfil"));
	    	predicateList.add(predicate);                	
	        
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<AccesoVieDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}
	}
	
	
	@Override
	public List<AccesoVieDTO> getByAndDistinctMenu(AccesoVieDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<AccesoVieDTO> cq;
		Root<AccesoVieDTO> from;
		List<AccesoVieDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(AccesoVieDTO.class);
			
			from= cq.from(AccesoVieDTO.class);
			
			cq.multiselect(from.get("cmeMenu")).distinct(true);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = objetoDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = objetoDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(objetoDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<AccesoVieDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}
}
