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

import net.ciespal.redxxi.ejb.persistence.dao.ComponenteDAO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class ComponenteDAOImpl extends AbstractFacadeImpl<ComponenteDTO> implements ComponenteDAO{

	private static final Logger logger = LoggerFactory.getLogger(ComponenteDAOImpl.class);
	
	public ComponenteDAOImpl() {
		super();
	}

	public ComponenteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ComponenteDTO> getByAnd(ComponenteDTO componenteDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<ComponenteDTO> cq;
		Root<ComponenteDTO> from;
		List<ComponenteDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(ComponenteDTO.class);
			
			from= cq.from(ComponenteDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = componenteDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = componenteDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(componenteDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<ComponenteDTO> tq=entityManager.createQuery(cq);
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
