package ec.edu.uce.erpmunicipal.contabilidad.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;

@Local
public interface CloseService {

	List<ConPeriodo> readAll(int year);

}
