package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

public interface AbstractFacade<T> {
	
	T create(T entity);
	
	T edit(T entity);
	
	void remove(T entity);
	
	T find(Object id);

	List<T> findAll();
}
