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

import ec.edu.uce.notas.ejb.persistence.dao.UsuarioPerfilDAO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioPerfilDTO;

public class UsuarioPerfilDAOImpl extends AbstractFacadeImpl<UsuarioPerfilDTO> implements UsuarioPerfilDAO {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(UsuarioDAOImpl.class);

	public UsuarioPerfilDAOImpl() {
		super();
	}
	
	public UsuarioPerfilDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<UsuarioPerfilDTO> getByAnd(UsuarioPerfilDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<UsuarioPerfilDTO> cq;
		Root<UsuarioPerfilDTO> from;
		List<UsuarioPerfilDTO> list;
		Predicate predicate;
		TypedQuery<UsuarioPerfilDTO> typedQuery;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(UsuarioPerfilDTO.class);
			
			from= cq.from(UsuarioPerfilDTO.class);
			
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
	public List<UsuarioPerfilDTO> getBySubquery(UsuarioPerfilDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<UsuarioPerfilDTO> cq;
		//Root<UsuarioPerfilDTO> from;
		List<UsuarioPerfilDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		TypedQuery<UsuarioPerfilDTO> typedQuery;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(UsuarioPerfilDTO.class);
			
			cq.from(UsuarioPerfilDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
	        predicate=cb.not(cb.exists(getSubquery(objetoDTO)));
	        predicateList.add(predicate);
	        
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
		}		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Subquery<UsuarioPerfilDTO> getSubquery(UsuarioPerfilDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<UsuarioPerfilDTO> cq;
		
		Subquery<UsuarioPerfilDTO> subquery;
		Root from ;

		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(UsuarioPerfilDTO.class);
			
			subquery=cq.subquery(UsuarioPerfilDTO.class);
			from = subquery.from(UsuarioPerfilDTO.class);
			
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
            cb=null;
            cq=null;
            from=null;
            fieldName=null;
            getter=null;
            value=null;
            fields=null;
		}				
	}
}
