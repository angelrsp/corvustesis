package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;

@Local
public interface OptionService {

	List<SisPantalla> readAll();

	List<SisPantalla> readByModule(int moduleCode);

	List<SisPantalla> readIsPather(int moduleCode);

}
