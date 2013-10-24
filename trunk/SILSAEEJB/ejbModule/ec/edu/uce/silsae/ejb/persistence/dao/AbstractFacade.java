package ec.edu.uce.silsae.ejb.persistence.dao;

public interface AbstractFacade<T> {
	
	T create(T entity);
	
	T edit(T entity);
	
	void remove(T entity);
	
	T find(Object id);

}
