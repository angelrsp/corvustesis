package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRole;


@Local
public interface RolService {

	List<SisPantalla> readMenu(int rolCode, int moduleCode);
	List<SisModulo> readModule(int rolCode);
	boolean isFather(int rolCode, int fatherCode);
	List<SisPantalla> readChildren(int rolCode, int fatherCode);
	List<SisRole> readAll(int rolCode);
	boolean existsName(String name);

}
