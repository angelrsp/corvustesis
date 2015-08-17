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

import ec.edu.uce.notas.ejb.persistence.dao.ComponenteMenuDAO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;

public class ComponenteMenuDAOImpl extends AbstractFacadeImpl<ComponenteMenuDTO> implements ComponenteMenuDAO{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ComponenteMenuDAOImpl.class);
	
	public ComponenteMenuDAOImpl() {
		super();
	}

	public ComponenteMenuDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ComponenteMenuDTO> getByAnd(ComponenteMenuDTO componenteDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<ComponenteMenuDTO> cq;
		Root<ComponenteMenuDTO> from;
		List<ComponenteMenuDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(ComponenteMenuDTO.class);
			
			from= cq.from(ComponenteMenuDTO.class);
			
			predicateList=new ArrayList<Predicate>();
			
			fields = componenteDTO.getClass().getDeclaredFields();

	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID"))
				{
				    getter = componenteDTO.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
				            fieldName.substring(1));
				    
				    value = getter.invoke(componenteDTO, new Object[0]);
				
				    if(value!=null)
				    {
				    	predicate=cb.equal(from.get(fieldName), value);
				    	predicateList.add(predicate);                	
				    }
				}
	        }
	
	        if(!predicateList.isEmpty())
	        	cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<ComponenteMenuDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			slf4jLogger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}

	
}
