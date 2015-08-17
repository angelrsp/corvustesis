package ec.edu.uce.notas.ejb.persistence.dao;

public interface AbstractFacade<T> {
	
	T create(T entity);
	
	T update(T entity);
	
	void remove(T entity);
	
	T find(Object id);

}
