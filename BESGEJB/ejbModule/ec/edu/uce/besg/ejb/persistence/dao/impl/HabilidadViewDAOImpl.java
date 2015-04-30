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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.ejb.persistence.dao.HabilidadViewDAO;
import ec.edu.uce.besg.ejb.persistence.entity.view.HabilidadViewDTO;

public class HabilidadViewDAOImpl extends AbstractFacadeImpl<HabilidadViewDTO> implements HabilidadViewDAO{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(HabilidadViewDAOImpl.class);

	public HabilidadViewDAOImpl() {
		super();
	}


	public HabilidadViewDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<HabilidadViewDTO> getByAnd(HabilidadViewDTO objeto) throws SecurityException
	{
		CriteriaBuilder cb;
		CriteriaQuery<HabilidadViewDTO> cq;
		Root<HabilidadViewDTO> from;
		List<HabilidadViewDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		TypedQuery<HabilidadViewDTO> typedQuery;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(HabilidadViewDTO.class);
			from= cq.from(HabilidadViewDTO.class);
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
			typedQuery=entityManager.createQuery(cq);
			list=typedQuery.getResultList();
			return list;
		}catch(Exception e){
			slf4jLogger.info(e.toString());
			throw new SecurityException(e);
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

	
}
