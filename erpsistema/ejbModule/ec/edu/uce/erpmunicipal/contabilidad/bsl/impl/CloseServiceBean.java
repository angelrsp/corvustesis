package ec.edu.uce.erpmunicipal.contabilidad.bsl.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import ec.edu.uce.erpmunicipal.contabilidad.bsl.CloseService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;

@Stateless(name = "closeServiceBean")
public class CloseServiceBean implements CloseService{

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	
	@Override
	public List<ConPeriodo> readAll(int year) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConPeriodo> cq = cb.createQuery(ConPeriodo.class);
		Root<ConPeriodo> from = cq.from(ConPeriodo.class);
		
		
		cq.where(cb.equal(from.get("perAnio"), year));
		
		List<ConPeriodo> list=entityManager.createQuery(cq).getResultList();
		return list;		
	}
}
