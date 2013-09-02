package ec.edu.uce.inventario.inventario.servicio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.entidades.RepFactura;

@Local
public interface ReportService {

	List<RepFactura> reportFactura(Date desde, Date hasta);

	List<InvKardex> reportKardex(Date desde, Date hasta);

	List<InvKardex> reportIngreso(Date desde, Date hasta);

	List<InvKardex> reportEgreso(Date desde, Date hasta);

}
