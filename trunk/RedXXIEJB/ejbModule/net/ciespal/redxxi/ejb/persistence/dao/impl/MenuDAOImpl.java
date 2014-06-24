package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.MenuDAO;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class MenuDAOImpl extends AbstractFacadeImpl<MenuDTO> implements MenuDAO{

	private static final Logger logger = LoggerFactory.getLogger(MenuDAOImpl.class);
	
	public MenuDAOImpl() {
		super();
	}

	public MenuDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<MenuDTO> getByAnd(MenuDTO menuDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<MenuDTO> cq;
		Root<MenuDTO> from;
		List<MenuDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(MenuDTO.class);
			
			from= cq.from(MenuDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = menuDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = menuDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(menuDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
	    	predicate=cb.greaterThan(from.get("menCodigo").as(Integer.class), 0);
	    	predicateList.add(predicate);                					    
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<MenuDTO> tq=entityManager.createQuery(cq);
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
	public List<MenuDTO> getRoot() throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<MenuDTO> cq;
		Root<MenuDTO> from;
		List<MenuDTO> list;
		
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(MenuDTO.class);
			
			from= cq.from(MenuDTO.class);

	        cq.where(cb.isNull(from.join("segMenu",JoinType.LEFT)));		
			
			TypedQuery<MenuDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
		}		
	}

}
