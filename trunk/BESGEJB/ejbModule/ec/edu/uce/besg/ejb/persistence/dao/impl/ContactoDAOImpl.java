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

import ec.edu.uce.besg.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.besg.ejb.persistence.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ContactoViewDTO;

public class ContactoDAOImpl extends AbstractFacadeImpl<ContactoDTO> implements ContactoDAO{

	public ContactoDAOImpl() {
		super();
	}

	public ContactoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<ContactoViewDTO> getByAnd(ContactoViewDTO objeto) throws SecurityException
	{
		CriteriaBuilder cb;
		CriteriaQuery<ContactoViewDTO> cq;
		Root<ContactoViewDTO> from;
		List<ContactoViewDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(ContactoViewDTO.class);
			from= cq.from(ContactoViewDTO.class);
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
			TypedQuery<ContactoViewDTO> tq=entityManager.createQuery(cq);
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
