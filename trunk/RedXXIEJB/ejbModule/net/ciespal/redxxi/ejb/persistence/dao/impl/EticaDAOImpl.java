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

import net.ciespal.redxxi.ejb.persistence.dao.EticaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;

import com.corvustec.commons.util.CorvustecException;

public class EticaDAOImpl extends AbstractFacadeImpl<EticaDTO> implements EticaDAO{

	private static final Logger logger = LoggerFactory.getLogger(EticaDAOImpl.class);
	
	public EticaDAOImpl() {
		super();
	}

	public EticaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<EticaDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EticaDTO> cq=cb.createQuery(EticaDTO.class);
		Root<EticaDTO> from= cq.from(EticaDTO.class);
		
		cq.where(cb.equal(from.get("etiCiudad"), ciudad));
		
		List<EticaDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override	
	public int count(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<EticaDTO> cq;
		Root<EticaDTO> from;
		List<EticaDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(EticaDTO.class);
			
			from= cq.from(EticaDTO.class);
			
			cq.multiselect(cb.count(from.get("etiCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("etiPais"),pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<EticaDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getEtiCount();
			else
				return 0;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}
	}
	
	
	@Override
	public List<EticaDTO> getByAnd(EticaDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<EticaDTO> cq;
		Root<EticaDTO> from;
		List<EticaDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(EticaDTO.class);
			
			from= cq.from(EticaDTO.class);
			
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
			
			TypedQuery<EticaDTO> tq=entityManager.createQuery(cq);
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
