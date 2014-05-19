package net.ciespal.redxxi.ejb.persistence.dao;



public interface AbstractFacade<T> {
	
	T create(T entity);
	
	T edit(T entity);
	
	void remove(T entity);
	
	T find(Object id);

	//List<T> getByAnd(T entity) throws CorvustecException;
}
