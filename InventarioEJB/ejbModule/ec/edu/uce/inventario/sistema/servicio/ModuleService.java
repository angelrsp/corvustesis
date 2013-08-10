package ec.edu.uce.inventario.sistema.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.SisModulo;

@Local
public interface ModuleService {

	List<SisModulo> readAll();

}
