package ec.edu.uce.inventario.facturacion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.FacCliente;
import ec.edu.uce.inventario.entidades.FacDetalleVenta;
import ec.edu.uce.inventario.entidades.FacVenta;

@Local
public interface FacturaService {

	void create(FacVenta venta, List<FacDetalleVenta> detalles,
			FacCliente cliente);

}
