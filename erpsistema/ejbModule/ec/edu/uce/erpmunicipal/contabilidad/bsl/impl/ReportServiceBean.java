package ec.edu.uce.erpmunicipal.contabilidad.bsl.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.ReportService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepBalanceComprobacion;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepDiarioGeneralIntegrado;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepMayorGeneral;

@Stateless(name = "reportService")
public class ReportServiceBean implements ReportService {

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public List<RepDiarioGeneralIntegrado> readDiarioGeneralIntegrado() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RepDiarioGeneralIntegrado> cq = cb.createQuery(RepDiarioGeneralIntegrado.class);
		//Root<RepDiarioGeneralIntegrado> from = cq.from(RepDiarioGeneralIntegrado.class);

		cq.select(cq.from(RepDiarioGeneralIntegrado.class));

		List<RepDiarioGeneralIntegrado> list = entityManager.createQuery(cq).getResultList();

		if (list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public List<RepMayorGeneral> readMayorGeneral() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RepMayorGeneral> cq = cb.createQuery(RepMayorGeneral.class);
		//Root<RepDiarioGeneralIntegrado> from = cq.from(RepDiarioGeneralIntegrado.class);

		cq.select(cq.from(RepMayorGeneral.class));

		List<RepMayorGeneral> list = entityManager.createQuery(cq).getResultList();

		if (list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<RepBalanceComprobacion> readBalanceComprobacion() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RepBalanceComprobacion> cq = cb.createQuery(RepBalanceComprobacion.class);
		//Root<RepDiarioGeneralIntegrado> from = cq.from(RepDiarioGeneralIntegrado.class);

		cq.select(cq.from(RepBalanceComprobacion.class));

		List<RepBalanceComprobacion> list = entityManager.createQuery(cq).getResultList();

		if (list.isEmpty())
			return null;
		else
			return list;
	}
	
	
}
