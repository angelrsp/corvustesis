package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import net.ciespal.redxxi.ejb.persistence.dao.AbstractFacade;


public abstract class AbstractFacadeImpl<T> implements AbstractFacade<T>{

	
//	@PersistenceContext(unitName = "silsaePU")
	protected EntityManager entityManager;

	private Class<T> entityClass;
	
	public AbstractFacadeImpl(){}

	@SuppressWarnings("unchecked")
	public AbstractFacadeImpl(EntityManager entityManager) {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.entityManager = entityManager;
	}
	
//	protected EntityManager getEntityManager(){
//		return this.entityManager;
//	}

	public T create(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	public T edit(T entity) {
		entityManager.merge(entity);
		return entity;
	}

	public void remove(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	public T find(Object id) {
		return entityManager.find(entityClass, id);
	}

	public List<T> findAll() {
		
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq=cb.createQuery(entityClass);
		cq.from(entityClass);
		
		List<T> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
//	public List<T> getByAnd(T entity) throws CorvustecException
//	{
//		CriteriaBuilder cb;
//		CriteriaQuery<T> cq;
//		Root<T> from;
//		List<T> list;
//		Predicate predicate;
//		List<Predicate> predicateList = null;
//		String fieldName;
//		Method getter;
//		Object value;
//		Field[] fields;
//		try{
//			cb=entityManager.getCriteriaBuilder();
//			cq=cb.createQuery(entityClass);
//			
//			from= cq.from(entityClass);
//			
//			predicateList=new ArrayList<Predicate>();
//			
//			fields = entityClass.getClass().getDeclaredFields();
//
//	        for(Field f : fields){
//	            fieldName = f.getName();
//				if(!fieldName.equals("serialVersionUID")&&!fieldName.equals("ANNOTATION")&&!fieldName.equals("ENUM"))
//				{
//				    getter = entityClass.getClass().getMethod("get" + String.valueOf(fieldName.charAt(0)).toUpperCase() +
//				            fieldName.substring(1));
//				    
//				    value = getter.invoke(entityClass, new Object[0]);
//				
//				    if(value!=null)
//				    {
//				    	predicate=cb.equal(from.get(fieldName), value);
//				    	predicateList.add(predicate);                	
//				    }
//				}
//	        }
//			
//			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
//			
//			TypedQuery<T> tq=entityManager.createQuery(cq);
//			list=tq.getResultList();
//			
//			return list;
//			
//		}catch(Exception e){
//			//logger.info(e.toString());
//			throw new CorvustecException(e);
//		}finally{
//			predicate=null;
//			predicateList=null;
//		}		
//	}

	
	
//
	
//	public List<T> findRange(int[] range) {
//		javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
//				.getCriteriaBuilder().createQuery();
//		cq.select(cq.from(entityClass));
//		javax.persistence.Query q = getEntityManager().createQuery(cq);
//		q.setMaxResults(range[1] - range[0]);
//		q.setFirstResult(range[0]);
//		return q.getResultList();
//	}
//
//	public int count() {
//		javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
//				.getCriteriaBuilder().createQuery();
//		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
//		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
//		javax.persistence.Query q = getEntityManager().createQuery(cq);
//		return ((Long) q.getSingleResult()).intValue();
//	}

}
