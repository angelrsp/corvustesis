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

import ec.edu.uce.besg.ejb.persistence.dao.CandidatoPostulacionViewDAO;
import ec.edu.uce.besg.ejb.persistence.entity.view.CandidatoPostulacionViewDTO;

public class CandidatoPostulacionViewDAOImpl extends AbstractFacadeImpl<CandidatoPostulacionViewDTO> implements CandidatoPostulacionViewDAO{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(CandidatoPostulacionViewDAOImpl.class);
	
	public CandidatoPostulacionViewDAOImpl() {
		super();
	}

	public CandidatoPostulacionViewDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<CandidatoPostulacionViewDTO> getByAnd(CandidatoPostulacionViewDTO objetoDTO) throws SecurityException
	{
		CriteriaBuilder cb;
		CriteriaQuery<CandidatoPostulacionViewDTO> cq;
		Root<CandidatoPostulacionViewDTO> from;
		List<CandidatoPostulacionViewDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		TypedQuery<CandidatoPostulacionViewDTO> typedQuery;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(CandidatoPostulacionViewDTO.class);
			from= cq.from(CandidatoPostulacionViewDTO.class);
			predicateList=new ArrayList<Predicate>();
			fields = objetoDTO.getClass().getDeclaredFields();
	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = objetoDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    value = getter.invoke(objetoDTO, new Object[0]);
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
