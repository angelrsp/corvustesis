package ec.edu.uce.inventario.inventario.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.InvKardex;

@Local
public interface ReportService {

	List<InvKardex> reportKardex();

	List<InvKardex> reportIngreso();

	List<InvKardex> reportEgreso();

}
