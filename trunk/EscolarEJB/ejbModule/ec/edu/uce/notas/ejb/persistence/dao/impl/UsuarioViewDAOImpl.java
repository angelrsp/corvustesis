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

import ec.edu.uce.notas.ejb.persistence.dao.UsuarioViewDAO;
import ec.edu.uce.notas.ejb.persistence.entity.view.UsuarioViewDTO;

public class UsuarioViewDAOImpl extends AbstractFacadeImpl<UsuarioViewDTO> implements UsuarioViewDAO{

	private static final Logger logger = LoggerFactory.getLogger(UsuarioViewDAOImpl.class);
	
	public UsuarioViewDAOImpl() {
		super();
	}
	public UsuarioViewDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<UsuarioViewDTO> getByAnd(UsuarioViewDTO objeto) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<UsuarioViewDTO> cq;
		Root<UsuarioViewDTO> from;
		List<UsuarioViewDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		String fieldName;
		Method getter;
		Object value;
		Field[] fields;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(UsuarioViewDTO.class);
			from= cq.from(UsuarioViewDTO.class);
			predicateList=new ArrayList<Predicate>();
			fields = objeto.getClass().getDeclaredFields();
	        for(Field f : fields){
	            fieldName = f.getName();
				if(!fieldName.equals("serialVersionUID") && !fieldName.equals("fechaActual"))
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
			TypedQuery<UsuarioViewDTO> tq=entityManager.createQuery(cq);
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
