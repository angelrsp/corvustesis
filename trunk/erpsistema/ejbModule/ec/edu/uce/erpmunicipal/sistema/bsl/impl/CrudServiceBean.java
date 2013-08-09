package ec.edu.uce.erpmunicipal.sistema.bsl.impl;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;

import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;

@Stateless(name="crudService")
public class CrudServiceBean implements CrudService {

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
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
	
	@Override
	public Object find(Object obj, int code)
	{
		return entityManager.find(obj.getClass(), code);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> find(String name)
	{
		return entityManager.createQuery("from "+name).getResultList();
	}

	
}
