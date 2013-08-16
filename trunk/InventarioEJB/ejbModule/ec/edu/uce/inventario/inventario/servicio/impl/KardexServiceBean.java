package ec.edu.uce.inventario.inventario.servicio.impl;

import java.sql.Timestamp;
import java.util.Calendar;

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

	@Override
	public void create(int claseCode,InvKardex kardex)
	{
		InvClase clase=entityManager.find(InvClase.class, claseCode);
		Calendar cal=Calendar.getInstance();
		kardex.setInvClase(clase);
		kardex.setKarFecha(new Timestamp(cal.getTimeInMillis()));
		entityManager.persist(kardex);
	}
	
	
}
