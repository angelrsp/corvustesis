package ec.edu.uce.inventario.sistema.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.SisModulo;
import ec.edu.uce.inventario.entidades.SisOpcion;

@Local
public interface PerfilOpcionService {

	List<SisOpcion> readChildren(int perfilCode, int moduleCode, int father);

	Boolean isFather(int fatherCode);

	List<SisOpcion> readOptions(int perfilCode, int moduleCode);

	List<SisModulo> readModules();

	Boolean update(Integer option, Integer perfil, Boolean insert);

}
