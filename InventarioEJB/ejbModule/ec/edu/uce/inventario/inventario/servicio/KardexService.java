package ec.edu.uce.inventario.inventario.servicio;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.entidades.InvKardex;

@Local
public interface KardexService {

	void create(int claseCode, InvKardex kardex, InvArticulo articulo);

}
