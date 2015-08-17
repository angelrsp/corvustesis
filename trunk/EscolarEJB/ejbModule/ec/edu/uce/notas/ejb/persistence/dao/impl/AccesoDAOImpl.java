package ec.edu.uce.notas.ejb.persistence.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.dao.AccesoDAO;
import ec.edu.uce.notas.ejb.persistence.entity.AccesoDTO;

public class AccesoDAOImpl extends AbstractFacadeImpl<AccesoDTO> implements AccesoDAO{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AccesoDAOImpl.class);
	
	public AccesoDAOImpl() {
		super();
	}

	public AccesoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<AccesoDTO> getByAnd(AccesoDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<AccesoDTO> cq;
		Root<AccesoDTO> from;
		List<AccesoDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		TypedQuery<AccesoDTO> typedQuery;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(AccesoDTO.class);
			
			from= cq.from(AccesoDTO.class);
			
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
			
			typedQuery=entityManager.createQuery(cq);
			list=typedQuery.getResultList();
			
			return list;
			
		}catch(Exception e){
			slf4jLogger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
            predicate=null;
            predicateList=null;
            cb=null;
            cq=null;
            typedQuery=null;
            from=null;
            fieldName=null;
            getter=null;
            value=null;
            fields=null;
        }		
	}

	@Override
	public List<AccesoDTO> getByAndDistinctMenu(AccesoDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<AccesoDTO> cq;
		Root<AccesoDTO> from;
		List<AccesoDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		TypedQuery<AccesoDTO> typedQuery;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(AccesoDTO.class);
			
			from= cq.from(AccesoDTO.class);
			
			cq.multiselect(from.get("segComponenteMenu").get("segMenu")).distinct(true);
			
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
			
	        typedQuery=entityManager.createQuery(cq);
			list=typedQuery.getResultList();
			
			return list;
			
		}catch(Exception e){
			slf4jLogger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
            predicate=null;
            predicateList=null;
            cb=null;
            cq=null;
            typedQuery=null;
            from=null;
            fieldName=null;
            getter=null;
            value=null;
            fields=null;
		}		
	}
	
	@Override
	public void remove2(AccesoDTO acceso)
	{
		if(acceso.getAccCodigo()!=null)
		{
			Query query;
			query=entityManager.createQuery("delete from ContactoDTO con where con.conCodigo=:codigo");
			query.setParameter("codigo", acceso.getAccCodigo());
			query.executeUpdate();
		}
	}
}
