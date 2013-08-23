package ec.edu.uce.inventario.inventario.servicio.impl;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.inventario.servicio.ReportService;

@Stateless(name = "reportService")
public class ReportServiceBean implements ReportService{

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public List<InvKardex> reportKardex() {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<InvKardex> cq=cb.createQuery(InvKardex.class);
		cq.select(cq.from(InvKardex.class));
		//entityManager.createQuery(cq).setMaxResults(1000).getResultList();
		List<InvKardex> list= entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
