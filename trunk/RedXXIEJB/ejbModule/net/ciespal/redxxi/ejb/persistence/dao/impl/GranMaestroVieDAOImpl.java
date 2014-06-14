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

import net.ciespal.redxxi.ejb.persistence.dao.GranMaestroVieDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroVieDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class GranMaestroVieDAOImpl extends AbstractFacadeImpl<GranMaestroVieDTO> implements GranMaestroVieDAO{

	private static final Logger logger = LoggerFactory.getLogger(GranMaestroVieDAOImpl.class);

	public GranMaestroVieDAOImpl() {
		super();
	}

	public GranMaestroVieDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<GranMaestroVieDTO> getByAnd(GranMaestroVieDTO objetoDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<GranMaestroVieDTO> cq;
		Root<GranMaestroVieDTO> from;
		List<GranMaestroVieDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(GranMaestroVieDTO.class);
			
			from= cq.from(GranMaestroVieDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = objetoDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID")&&!fieldName.equals("etiCount"))
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
			
			TypedQuery<GranMaestroVieDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			logger.info("getByAnd "+e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}
}
