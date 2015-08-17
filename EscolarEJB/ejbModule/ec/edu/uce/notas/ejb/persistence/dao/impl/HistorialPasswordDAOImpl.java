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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.dao.HistorialPasswordDAO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoryPasswordDTO;

public class HistorialPasswordDAOImpl extends AbstractFacadeImpl<HistoryPasswordDTO> implements HistorialPasswordDAO{

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	
	public HistorialPasswordDAOImpl() {
		super();
	}

	public HistorialPasswordDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<HistoryPasswordDTO> getByAnd(HistoryPasswordDTO objeto) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<HistoryPasswordDTO> cq;
		Root<HistoryPasswordDTO> from;
		List<HistoryPasswordDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(HistoryPasswordDTO.class);
			from= cq.from(HistoryPasswordDTO.class);
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
			TypedQuery<HistoryPasswordDTO> tq=entityManager.createQuery(cq);
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
