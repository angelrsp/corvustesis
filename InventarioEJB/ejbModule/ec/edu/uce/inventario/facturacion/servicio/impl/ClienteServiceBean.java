package ec.edu.uce.inventario.facturacion.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ec.edu.uce.inventario.entidades.FacCliente;
import ec.uce.edu.inventario.facturacion.servicio.ClienteService;

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
	 
}
