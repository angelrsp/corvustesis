package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;

@Local
public interface SelectOptionService {

	List<ConPeriodo> readYear();



}
