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

import net.ciespal.redxxi.ejb.persistence.dao.PremioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class PremioDAOImpl extends AbstractFacadeImpl<PremioDTO> implements PremioDAO {

	private static final Logger logger = LoggerFactory.getLogger(PremioDAOImpl.class);
	
	public PremioDAOImpl() {
		super();
		
	}

	public PremioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}
	
	@Override
	public List<PremioDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PremioDTO> cq=cb.createQuery(PremioDTO.class);
		Root<PremioDTO> from= cq.from(PremioDTO.class);
		
		cq.where(cb.equal(from.get("preCiudad"), ciudad));
		
		List<PremioDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public List<PremioDTO> getByAnd(PremioDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<PremioDTO> cq;
		Root<PremioDTO> from;
		List<PremioDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(PremioDTO.class);
			
			from= cq.from(PremioDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = objetoDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID")&&!fieldName.equals("preCount"))
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
			
			TypedQuery<PremioDTO> tq=entityManager.createQuery(cq);
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
	public int count(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<PremioDTO> cq;
		Root<PremioDTO> from;
		List<PremioDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(PremioDTO.class);
			
			from= cq.from(PremioDTO.class);
			
			cq.multiselect(cb.count(from.get("preCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("prePais"),pais);
				predicateList.add(predicate);
			}
			if(predicateList.size()>0)
				cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<PremioDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getPreCount();
			else
				return 0;
			
		}catch(Exception e){
			logger.info("count"+ e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}
	}


}
