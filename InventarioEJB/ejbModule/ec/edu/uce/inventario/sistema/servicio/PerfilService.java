package ec.edu.uce.inventario.sistema.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.SisModulo;
import ec.edu.uce.inventario.entidades.SisOpcion;
import ec.edu.uce.inventario.entidades.SisPerfil;

@Local
public interface PerfilService {

	List<SisOpcion> readMenu(int perfilCode, int moduleCode);

	List<SisModulo> readModule(int perfilCode);

	boolean isFather(int perfilCode, int fatherCode);

	List<SisOpcion> readChildren(int perfilCode, int fatherCode);

	List<SisPerfil> readAll();

	boolean existsName(String name);


}
