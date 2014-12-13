package ec.edu.uce.besg.ejb.persistence.dao.impl;

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

import ec.edu.uce.besg.ejb.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.entity.CandidatoListDTO;
import ec.edu.uce.besg.ejb.persistence.dao.CandidatoDAO;

public class CandidatoDAOImpl extends AbstractFacadeImpl<CandidatoDTO> implements CandidatoDAO {

	public CandidatoDAOImpl() {
		super();
	}

	public CandidatoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<CandidatoListDTO> getByAnd(CandidatoListDTO objeto) throws SecurityException
	{
		CriteriaBuilder cb;
		CriteriaQuery<CandidatoListDTO> cq;
		Root<CandidatoListDTO> from;
		List<CandidatoListDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(CandidatoListDTO.class);
			from= cq.from(CandidatoListDTO.class);
			predicateList=new ArrayList<Predicate>();
			fields = objeto.getClass().getDeclaredFields();
	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = objeto.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    value = getter.invoke(objeto, new Object[0]);
				    if(value!=null && value!="")
				    {
				    		predicate=cb.equal(from.get(fieldName), value);
				    		predicateList.add(predicate);
				    }
				}
	        }
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			TypedQuery<CandidatoListDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			return list;
		}catch(Exception e){
			//logger.info(e.toString());
			throw new SecurityException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}
	
	@Override
	public Boolean getByIdentificacion(CandidatoDTO candidatoDTO) {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CandidatoDTO> cq=cb.createQuery(CandidatoDTO.class);
		Root<CandidatoDTO> from= cq.from(CandidatoDTO.class);
		
		cq.where(cb.equal(from.get("canIdentificacion"), candidatoDTO.getCanIdentificacion()));
		
		List<CandidatoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return false;
		else
			return true;	
	}
	
	@Override
	public List<CandidatoDTO> getByAndDTO(CandidatoDTO objeto) throws SecurityException
	{
		CriteriaBuilder cb;
		CriteriaQuery<CandidatoDTO> cq;
		Root<CandidatoDTO> from;
		List<CandidatoDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(CandidatoDTO.class);
			from= cq.from(CandidatoDTO.class);
			predicateList=new ArrayList<Predicate>();
			fields = objeto.getClass().getDeclaredFields();
	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = objeto.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    value = getter.invoke(objeto, new Object[0]);
				    if(value!=null && value!="")
				    {
				    		predicate=cb.equal(from.get(fieldName), value);
				    		predicateList.add(predicate);
				    }
				}
	        }
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			TypedQuery<CandidatoDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			return list;
		}catch(Exception e){
			//logger.info(e.toString());
			throw new SecurityException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}
	
}
