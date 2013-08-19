package ec.edu.uce.inventario.inventario.servicio.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.entidades.InvClase;
import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.inventario.servicio.ArticuloService;
import ec.edu.uce.inventario.inventario.servicio.KardexService;

@Stateless(name = "kardexService")
public class KardexServiceBean implements KardexService{

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@EJB(name = "articuloService/local")
	private ArticuloService articuloService;
	
	@Override
	public void create(int claseCode,InvKardex kardex,InvArticulo articulo,Boolean incrementa)
	{
		InvClase clase=entityManager.find(InvClase.class, claseCode);
		Calendar cal=Calendar.getInstance();
		kardex.setInvClase(clase);
		kardex.setKarFecha(new Timestamp(cal.getTimeInMillis()));
		kardex.setInvArticulo(articulo);
		
		InvArticulo art=articuloService.readArticulo(articulo);
		if(incrementa)
			art.setArtPaquete(BigDecimal.valueOf(art.getArtPaquete().doubleValue()+kardex.getKarCantidad().doubleValue()));
		else
			art.setArtPaquete(BigDecimal.valueOf(art.getArtPaquete().doubleValue()-kardex.getKarCantidad().doubleValue()));
		
		kardex.setKarSaldo(art.getArtPaquete());
		
		entityManager.persist(kardex);
		entityManager.merge(art);
	}
	
	@Override
	public void create2(int claseCode,InvKardex kardex,InvArticulo articulo)
	{
		InvClase clase=entityManager.find(InvClase.class, claseCode);
		Calendar cal=Calendar.getInstance();
		kardex.setInvClase(clase);
		kardex.setKarFecha(new Timestamp(cal.getTimeInMillis()));
		kardex.setInvArticulo(articulo);
		kardex.setKarSaldo(articulo.getArtPaquete());
		
		entityManager.persist(kardex);
	}
	
	
}
