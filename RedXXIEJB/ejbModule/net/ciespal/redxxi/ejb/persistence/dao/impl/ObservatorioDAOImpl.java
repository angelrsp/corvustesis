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

import net.ciespal.redxxi.ejb.persistence.dao.ObservatorioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class ObservatorioDAOImpl extends AbstractFacadeImpl<ObservatorioDTO> implements ObservatorioDAO {

	private static final Logger logger = LoggerFactory.getLogger(ObservatorioDAOImpl.class);
	
	public ObservatorioDAOImpl() {
		super();
	}

	public ObservatorioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ObservatorioDTO> findAll(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ObservatorioDTO> cq=cb.createQuery(ObservatorioDTO.class);
		Root<ObservatorioDTO> from= cq.from(ObservatorioDTO.class);
		
		
		cq.where(cb.equal(from.get("obsCiudad"), ubicacion));
		
		List<ObservatorioDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override	
	public int count(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<ObservatorioDTO> cq;
		Root<ObservatorioDTO> from;
		List<ObservatorioDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(ObservatorioDTO.class);
			
			from= cq.from(ObservatorioDTO.class);
			
			cq.multiselect(cb.count(from.get("obsCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("obsPais"),pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<ObservatorioDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getObsCount();
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
	public List<ObservatorioDTO> getByAnd(ObservatorioDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<ObservatorioDTO> cq;
		Root<ObservatorioDTO> from;
		List<ObservatorioDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(ObservatorioDTO.class);
			
			from= cq.from(ObservatorioDTO.class);
			
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
			
			TypedQuery<ObservatorioDTO> tq=entityManager.createQuery(cq);
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
