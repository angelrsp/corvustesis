package ec.edu.uce.inventario.sistema.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.SisOpcion;

@Local
public interface OptionService {

	List<SisOpcion> readAll();

	List<SisOpcion> readByModule(int moduleCode);

	List<SisOpcion> readIsPather(int moduleCode);

}
