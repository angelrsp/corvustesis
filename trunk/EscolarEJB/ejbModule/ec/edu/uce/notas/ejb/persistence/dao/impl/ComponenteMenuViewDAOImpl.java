package ec.edu.uce.notas.ejb.persistence.dao.impl;

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

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.dao.ComponenteMenuViewDAO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.ComponenteMenuViewDTO;

public class ComponenteMenuViewDAOImpl extends AbstractFacadeImpl<ComponenteMenuDTO> implements ComponenteMenuViewDAO{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ComponenteMenuViewDAOImpl.class);
	
	public ComponenteMenuViewDAOImpl() {
		super();
	}

	public ComponenteMenuViewDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<ComponenteMenuViewDTO> getBySubquery(AccesoViewDTO objetoDTO,ComponenteMenuViewDTO componenteMenuDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<ComponenteMenuViewDTO> cq;
		Root<ComponenteMenuViewDTO> from;
		List<ComponenteMenuViewDTO> list;
		
		
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;

		
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(ComponenteMenuViewDTO.class);
			
			from=cq.from(ComponenteMenuViewDTO.class);

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
	        				
			TypedQuery<ComponenteMenuViewDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			slf4jLogger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked" })
	private Subquery<AccesoViewDTO> getSubquery(AccesoViewDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<AccesoViewDTO> cq;
		
		Subquery<AccesoViewDTO> subquery;
		Root from ;

		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(AccesoViewDTO.class);
			
			subquery=cq.subquery(AccesoViewDTO.class);
			from = subquery.from(AccesoViewDTO.class);
			
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
			slf4jLogger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}				
	}

	
	
}
