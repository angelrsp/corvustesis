package ec.edu.uce.erpmunicipal.sistema.bsl.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.erpmunicipal.sistema.bsl.OptionService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;

@Stateless(name = "optionService")
public class OptionServiceBean implements OptionService {

	@PersistenceContext(name = "systemPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public OptionServiceBean() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisPantalla> readAll() {
		List<SisPantalla> objects;

		try {
			Query query = entityManager
					.createQuery("from SisPantalla a order by a.panOrden");
			objects = query.getResultList();
		} catch (Exception e) {
			objects = null;
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisPantalla> readByModule(int moduleCode) {
		List<SisPantalla> objects;

		try {
			Query query = entityManager
					.createQuery("from SisPantalla a where a.sisModulo.modCodigo=:moduleCode order by a.panOrden");
			query.setParameter("moduleCode", moduleCode);
			objects = query.getResultList();
		} catch (Exception e) {
			objects = null;
		}
		return objects;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SisPantalla> readIsPather(int moduleCode) {
		List<SisPantalla> objects;
		try {
			Query query = entityManager
					.createQuery("from SisPantalla a where a.sisModulo.modCodigo=:moduleCode and a.panUrl='Nudo' order by a.panOrden");
			query.setParameter("moduleCode", moduleCode);
			objects = query.getResultList();
		} catch (Exception e) {
			objects = null;
		}
		return objects;
	}

}
