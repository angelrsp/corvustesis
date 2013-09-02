package ec.edu.uce.inventario.inventario.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.entidades.InvUnidad;

@Local
public interface ArticuloService {

	void create(InvArticulo art, int unidad) throws Exception;

	List<InvUnidad> readUnidades();

	List<InvArticulo> readAll();

	Boolean delete(InvArticulo art);

	void updateEstado(InvArticulo art);
	
	void update(InvArticulo art, int unidad);

	List<InvArticulo> dynamicSearch(String par);

	InvArticulo readArticulo(InvArticulo articulo);

	void actualizarPrecios(Double porcentaje);
}
