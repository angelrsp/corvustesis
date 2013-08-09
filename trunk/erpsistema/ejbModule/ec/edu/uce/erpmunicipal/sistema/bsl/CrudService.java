package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;


@Local
public interface CrudService {
	void create(Object object);
	void update(Object object);
	void delete(Object object);
	Object find(Object obj, int code);
	List<Object> find(String name);
}
