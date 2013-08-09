package ec.edu.uce.erpmunicipal.contabilidad.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConTipoCuenta;

@Local
public interface AccoutingService {

	List<ConTipoCuenta> readAccountingType();

	List<ConCuenta> readAccountings();

	Boolean isfather(int fatherCode);

	List<ConCuenta> readChildren(int fatherCode);

	List<ConCuenta> readFirstAccountings();

	List<ConCuenta> dynamicSearch(String par);

	ConCuenta search(String code);

}
