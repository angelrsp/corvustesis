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

import net.ciespal.redxxi.ejb.persistence.dao.LeyDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class LeyDAOImpl extends AbstractFacadeImpl<LeyDTO> implements LeyDAO {

	private static final Logger logger = LoggerFactory.getLogger(LeyDAOImpl.class);
	
	public LeyDAOImpl() {
		super();
		
	}

	public LeyDAOImpl(EntityManager entityManager) {
		super(entityManager);
	
	}

	
	@Override
	public List<LeyDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<LeyDTO> cq=cb.createQuery(LeyDTO.class);
		Root<LeyDTO> from= cq.from(LeyDTO.class);
		
		cq.where(cb.equal(from.get("leyCiudad"), ciudad));
		
		List<LeyDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<LeyDTO> getByAnd(LeyDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<LeyDTO> cq;
		Root<LeyDTO> from;
		List<LeyDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(LeyDTO.class);
			
			from= cq.from(LeyDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = objetoDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID")&&!fieldName.equals("leyCount"))
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
			
			TypedQuery<LeyDTO> tq=entityManager.createQuery(cq);
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
		CriteriaQuery<LeyDTO> cq;
		Root<LeyDTO> from;
		List<LeyDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(LeyDTO.class);
			
			from= cq.from(LeyDTO.class);
			
			cq.multiselect(cb.count(from.get("leyCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("leyPais"),pais);
				predicateList.add(predicate);
			}
			if(predicateList.size()>0)
				cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<LeyDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getLeyCount();
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
