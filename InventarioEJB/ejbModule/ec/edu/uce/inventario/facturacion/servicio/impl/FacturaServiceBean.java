package ec.edu.uce.inventario.facturacion.servicio.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ec.edu.uce.inventario.entidades.FacCliente;
import ec.edu.uce.inventario.entidades.FacDetalleVenta;
import ec.edu.uce.inventario.entidades.FacVenta;
import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.facturacion.servicio.FacturaService;
import ec.edu.uce.inventario.inventario.servicio.KardexService;

@Stateless(name = "facturaService")
public class FacturaServiceBean implements FacturaService{

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@EJB(name = "kardexService/local")
	private KardexService kardexService;
	
	@Override
	public void create(FacVenta venta,List<FacDetalleVenta> detalles,FacCliente cliente)
	{
		venta.setFacCliente(cliente);
		
		entityManager.persist(venta);
		entityManager.flush();
		entityManager.refresh(venta);
		InvKardex kardex;
		Calendar cal=Calendar.getInstance();
		for(FacDetalleVenta detalle:detalles)
		{
			detalle.setFacVenta(venta);
			entityManager.persist(detalle);
			kardex=new InvKardex();
			kardex.setKarCantidad(detalle.getDveCantidad());
			kardex.setKarValorUnitario(detalle.getDvePrecio());
			kardex.setKarValorTotal(detalle.getDveTotal());
			kardex.setKarFecha(new Timestamp(cal.getTimeInMillis()));
			kardexService.create(2, kardex, detalle.getInvArticulo(), false);
		}
	}
}
