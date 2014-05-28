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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ciespal.redxxi.ejb.persistence.dao.DefensorVieDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorVieDTO;

import com.corvustec.commons.util.CorvustecException;

public class DefensorVieDAOImpl extends AbstractFacadeImpl<DefensorVieDTO> implements DefensorVieDAO{

	private static final Logger logger = LoggerFactory.getLogger(DefensorVieDAOImpl.class);
	
	public DefensorVieDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<DefensorVieDTO> getByAnd(DefensorVieDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<DefensorVieDTO> cq;
		Root<DefensorVieDTO> from;
		List<DefensorVieDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(DefensorVieDTO.class);
			
			from= cq.from(DefensorVieDTO.class);
			
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
			
			TypedQuery<DefensorVieDTO> tq=entityManager.createQuery(cq);
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
