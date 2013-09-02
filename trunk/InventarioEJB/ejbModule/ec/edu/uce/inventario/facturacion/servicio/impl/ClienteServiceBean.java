package ec.edu.uce.inventario.facturacion.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.uce.inventario.entidades.FacCliente;
import ec.edu.uce.inventario.facturacion.servicio.ClienteService;

@Stateless(name = "clienteService")
public class ClienteServiceBean implements ClienteService{

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	@Override
	public void create(FacCliente cliente)
	{
		entityManager.persist(cliente);
	}

	@Override
	public void update(FacCliente cliente)
	{
		entityManager.merge(cliente);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FacCliente> readAll()
	{
		return entityManager.createQuery("from FacCliente").getResultList();
		
	} 
	
	@Override
	public List<FacCliente> dynamicSearch(String text)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<FacCliente> cq=cb.createQuery(FacCliente.class);
		Root<FacCliente> from=cq.from(FacCliente.class);
		
		cq.select(from);
		
		Predicate like1=cb.like(cb.lower(from.get("cliApellidos").as(String.class)), "%"+text.toLowerCase()+"%");
		Predicate like2=cb.like(cb.lower(from.get("cliNombres").as(String.class)), "%"+text.toLowerCase()+"%");
		Predicate like3=cb.like(cb.lower(from.get("cliIdentificacion").as(String.class)), "%"+text.toLowerCase()+"%");
		
		cq.where(cb.or(like1,like2,like3));
		
		TypedQuery<FacCliente> typed=entityManager.createQuery(cq);
		typed.setMaxResults(100);
		return typed.getResultList();
	}
	 
}
