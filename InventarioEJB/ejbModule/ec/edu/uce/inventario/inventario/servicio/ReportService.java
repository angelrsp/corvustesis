package ec.edu.uce.inventario.inventario.servicio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.entidades.RepFactura;

@Local
public interface ReportService {

	List<InvKardex> reportKardex();

	List<InvKardex> reportIngreso();

	List<InvKardex> reportEgreso();

	List<RepFactura> reportFactura(Date desde, Date hasta);

}
