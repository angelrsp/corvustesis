package ec.edu.uce.inventario.sistema.servicio;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CrudService {

	void create(Object object);

	void update(Object object);

	void delete(Object object);

	List<Object> find(String name);

}
