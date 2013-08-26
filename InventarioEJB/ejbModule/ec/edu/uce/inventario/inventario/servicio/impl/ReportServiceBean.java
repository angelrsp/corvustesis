package ec.edu.uce.inventario.inventario.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.inventario.entidades.InvClase;
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

	
	@Override
	public List<InvKardex> reportIngreso() {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<InvKardex> cq=cb.createQuery(InvKardex.class);
		Root<InvKardex> from = cq.from(InvKardex.class);
		Path<InvClase> join=from.join("invClase").get("claCodigo");
		
		cq.where(cb.equal(join.get("claCodigo"),1));
		
		//entityManager.createQuery(cq).setMaxResults(1000).getResultList();
		List<InvKardex> list= entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@Override
	public List<InvKardex> reportEgreso() {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<InvKardex> cq=cb.createQuery(InvKardex.class);
		Root<InvKardex> from = cq.from(InvKardex.class);
		
		cq.where(cb.equal(from.get("invClase.claCodigo"),2));
		
		//entityManager.createQuery(cq).setMaxResults(1000).getResultList();
		List<InvKardex> list= entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
}
