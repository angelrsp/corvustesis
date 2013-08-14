package ec.edu.uce.inventario.inventario.servicio.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ec.edu.uce.inventario.entidades.InvClase;
import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.inventario.servicio.KardexService;

@Stateless(name = "kardexService")
public class KardexServiceBean implements KardexService{

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public void create(int claseCode,InvKardex kardek)
	{
		InvClase clase=entityManager.find(InvClase.class, claseCode);
		kardek.setInvClase(clase);
		entityManager.persist(kardek);
	}
	
	
}
