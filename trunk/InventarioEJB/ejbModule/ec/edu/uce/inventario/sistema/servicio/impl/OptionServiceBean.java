package ec.edu.uce.inventario.sistema.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.inventario.entidades.SisOpcion;
import ec.edu.uce.inventario.sistema.servicio.OptionService;

@Stateless(name = "optionService")
public class OptionServiceBean implements OptionService {

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	 public OptionServiceBean() {
	    }

	    @SuppressWarnings("unchecked")
	    @Override
	    public List<SisOpcion> readAll() {
	        List<SisOpcion> objects;

	        try {
	            Query query = entityManager
	                    .createQuery("from SisOpcion a order by a.opcOrden");
	            objects = query.getResultList();
	        } catch (Exception e) {
	            objects = null;
	        }
	        return objects;
	    }

	    @SuppressWarnings("unchecked")
	    @Override
	    public List<SisOpcion> readByModule(int moduleCode) {
	        List<SisOpcion> objects;

	        try {
	            Query query = entityManager
	                    .createQuery("from SisOpcion a where a.sisModulo.modCodigo=:moduleCode order by a.opcOrden");
	            query.setParameter("moduleCode", moduleCode);
	            objects = query.getResultList();
	        } catch (Exception e) {
	            objects = null;
	        }
	        return objects;
	    }
	   
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<SisOpcion> readIsPather(int moduleCode) {
	        List<SisOpcion> objects;
	        try {
	            Query query = entityManager
	                    .createQuery("from SisOpcion a where a.sisModulo.modCodigo=:moduleCode and a.opcUrl='Nudo' order by a.opcOrden");
	            query.setParameter("moduleCode", moduleCode);
	            objects = query.getResultList();
	        } catch (Exception e) {
	            objects = null;
	        }
	        return objects;
	    }
}
