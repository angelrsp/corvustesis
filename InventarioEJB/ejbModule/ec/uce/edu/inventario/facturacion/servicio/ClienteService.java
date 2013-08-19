package ec.uce.edu.inventario.facturacion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.FacCliente;

@Local
public interface ClienteService {

	void create(FacCliente cliente);

	List<FacCliente> readAll();

	void update(FacCliente cliente);

	List<FacCliente> dynamicSearch(String text);

	
}
