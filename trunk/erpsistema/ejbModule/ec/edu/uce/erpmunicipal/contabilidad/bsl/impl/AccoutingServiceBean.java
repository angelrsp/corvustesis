package ec.edu.uce.erpmunicipal.contabilidad.bsl.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jboss.logging.Logger;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.AccoutingService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConTipoCuenta;

@Stateless(name = "accoutingService")
public class AccoutingServiceBean implements AccoutingService {

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ConTipoCuenta> readAccountingType() {
		List<ConTipoCuenta> objects;
		try {
			Query query = entityManager.createQuery("from ConTipoCuenta");
			objects = query.getResultList();
		} catch (Exception e) {
			objects = null;
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConCuenta> readFirstAccountings() {
		List<ConCuenta> objects;
		try {
			Query query = entityManager
					.createQuery("from ConCuenta cue where cue.cueCodigoPadre=0 order by cue.cueCodigo");
			objects = query.getResultList();
		} catch (Exception e) {
			objects = null;
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConCuenta> readAccountings() {
		List<ConCuenta> objects;
		try {
			Query query = entityManager
					.createQuery("from ConCuenta cue where cue.cueCodigoPadre!=0");
			objects = query.getResultList();
		} catch (Exception e) {
			objects = null;
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConCuenta> readChildren(int fatherCode) {
		List<ConCuenta> objects;
		try {
			Query query = entityManager
					.createQuery("from ConCuenta cue where cue.cueCodigoPadre=:fatherCode order by cue.cueSubcuenta");
			query.setParameter("fatherCode", fatherCode);
			objects = query.getResultList();
		} catch (Exception e) {
			objects = null;
		}
		return objects;
	}

	@Override
	public Boolean isfather(int fatherCode) {
		Query query = entityManager.createQuery("select cue "
				+ "from ConCuenta cue "
				+ "where cue.cueCodigoPadre=:fatherCode");
		query.setParameter("fatherCode", fatherCode);
		if (query.getResultList().size() > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<ConCuenta> dynamicSearch(String par) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConCuenta> q = cb.createQuery(ConCuenta.class);
		Root<ConCuenta> c = q.from(ConCuenta.class);
		q.select(c);

		Logger.getLogger(this.getClass()).info(par);

		Predicate lik1 = cb.like(
				cb.lower(c.get("cueDescripcion").as(String.class)),
				"%" + par.toLowerCase() + "%");
		
		Predicate lik2 = cb.like(c.get("cueNumero").as(String.class), "%" + par
				+ "%");

		q.where(cb.or(lik1, lik2), cb.and(cb.equal(c
				.get("cuePermiteMovimiento").as(Boolean.class), true)));

		return entityManager.createQuery(q).getResultList();
	}

	@Override
	public ConCuenta search(String code) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConCuenta> q = cb.createQuery(ConCuenta.class);
		Root<ConCuenta> c = q.from(ConCuenta.class);
		
		q.select(c);

		Logger.getLogger(this.getClass()).info(code);
		
		q.where(cb.and(cb.equal(c.get("cueNumero"), code),cb.equal(c.get("cuePermiteMovimiento").as(Boolean.class), true)));
		
		List<ConCuenta> list=entityManager.createQuery(q).getResultList();
		
		if(!list.isEmpty())
			return list.get(0);
		else
			return new ConCuenta();
	}

}
