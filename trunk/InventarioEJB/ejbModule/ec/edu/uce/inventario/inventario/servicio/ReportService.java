package ec.edu.uce.inventario.inventario.servicio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.FacDetalleVenta;
import ec.edu.uce.inventario.entidades.InvKardex;

@Local
public interface ReportService {

	List<InvKardex> reportKardex();

	List<InvKardex> reportIngreso();

	List<InvKardex> reportEgreso();

	List<FacDetalleVenta> reportFactura1(Date desde, Date hasta);

}
