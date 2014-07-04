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
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.dao.ComponenteMenuVieDAO;
import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuVieDTO;

public class ComponenteMenuVieDAOImpl extends AbstractFacadeImpl<ComponenteMenuDTO> implements ComponenteMenuVieDAO{

	private static final Logger logger = LoggerFactory.getLogger(AccesoVieDAOImpl.class);
	
	public ComponenteMenuVieDAOImpl() {
		super();
	}

	public ComponenteMenuVieDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<ComponenteMenuVieDTO> getBySubquery(AccesoVieDTO objetoDTO,ComponenteMenuVieDTO componenteMenuDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<ComponenteMenuVieDTO> cq;
		Root<ComponenteMenuVieDTO> from;
		List<ComponenteMenuVieDTO> list;
		
		
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;

		
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(ComponenteMenuVieDTO.class);
			
			from=cq.from(ComponenteMenuVieDTO.class);

			predicateList=new ArrayList<Predicate>();
			
			fields = componenteMenuDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = componenteMenuDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(componenteMenuDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
			
			predicate=from.get("cmeCodigo").in(getSubquery(objetoDTO)).not();
			predicateList.add(predicate);
			
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
	        				
			TypedQuery<ComponenteMenuVieDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked" })
	private Subquery<AccesoVieDTO> getSubquery(AccesoVieDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<AccesoVieDTO> cq;
		
		Subquery<AccesoVieDTO> subquery;
		Root from ;

		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(AccesoVieDTO.class);
			
			subquery=cq.subquery(AccesoVieDTO.class);
			from = subquery.from(AccesoVieDTO.class);
			
			subquery.select(from.get("cmeCodigo"));
			
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
	        	subquery.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			return subquery;			
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}				
	}

	
	
}
