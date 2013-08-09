package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;

@Local
public interface RolOptionService {

	List<SisPantalla> readOptions(int rolCode, int moduleCode);

	List<SisModulo> readModules();

	Boolean isFather(int fatherCode);

	List<SisPantalla> readChildren(int rolCode, int moduleCode, int father);

	Boolean update(Integer option, Integer role, Boolean insert);

}
