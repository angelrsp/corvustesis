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

import net.ciespal.redxxi.ejb.persistence.dao.MaestroCiespalDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class MaestroCiespalDAOImpl extends AbstractFacadeImpl<MaestroCiespalDTO> implements MaestroCiespalDAO {

	private static final Logger logger = LoggerFactory.getLogger(MaestroCiespalDAOImpl.class);
	
	public MaestroCiespalDAOImpl() {
		super();
	}

	public MaestroCiespalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<MaestroCiespalDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<MaestroCiespalDTO> cq=cb.createQuery(MaestroCiespalDTO.class);
		Root<MaestroCiespalDTO> from= cq.from(MaestroCiespalDTO.class);
		
		cq.where(cb.equal(from.get("mciCiudad"), ciudad));
		
		List<MaestroCiespalDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public List<MaestroCiespalDTO> getByAnd(MaestroCiespalDTO maestroCiespalDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<MaestroCiespalDTO> cq;
		Root<MaestroCiespalDTO> from;
		List<MaestroCiespalDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(MaestroCiespalDTO.class);
			
			from= cq.from(MaestroCiespalDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = maestroCiespalDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID")&&!fieldName.equals("mciCount"))
				{
				    getter = maestroCiespalDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(maestroCiespalDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<MaestroCiespalDTO> tq=entityManager.createQuery(cq);
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
		CriteriaQuery<MaestroCiespalDTO> cq;
		Root<MaestroCiespalDTO> from;
		List<MaestroCiespalDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(MaestroCiespalDTO.class);
			
			from= cq.from(MaestroCiespalDTO.class);
			
			cq.multiselect(cb.count(from.get("mciCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("mciPais"),pais);
				predicateList.add(predicate);
			}
			if(predicateList.size()>0)
				cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<MaestroCiespalDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getMciCount();
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
