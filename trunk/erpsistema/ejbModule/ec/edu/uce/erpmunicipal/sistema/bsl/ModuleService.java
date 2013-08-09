package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;


@Local
public interface ModuleService {

	List<SisModulo> readAll();

	

}
