package ec.edu.uce.inventario.sistema.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;

import ec.edu.uce.inventario.sistema.servicio.CrudService;

@Stateless(name="crudService")
public class CrudServiceBean implements CrudService{

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

	 @Override
	    public void create(Object object) {
	        try {
	            entityManager.persist(object);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void update(Object object) {
	        try {
	            entityManager.merge(object);
	        }
	        catch (PersistenceException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	        catch (Exception e) {
	            e.getMessage();
	        }
	    }

	    @Override
	    public void delete(Object object) {
	        try {
	            entityManager.remove(object);
	        } catch (PersistenceException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @SuppressWarnings("unchecked")
		@Override
	    public List<Object> find(String name)
	    {
	    	return entityManager.createQuery("from "+name).getResultList();
	    }
}
