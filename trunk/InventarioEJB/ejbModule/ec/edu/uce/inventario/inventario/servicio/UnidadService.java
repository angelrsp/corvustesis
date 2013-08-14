package ec.edu.uce.inventario.inventario.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.InvUnidad;

@Local
public interface UnidadService {

	void create(InvUnidad unidad);

	void update(InvUnidad unidad);

	List<InvUnidad> readAll();

	Boolean delete(InvUnidad unidad);

}
