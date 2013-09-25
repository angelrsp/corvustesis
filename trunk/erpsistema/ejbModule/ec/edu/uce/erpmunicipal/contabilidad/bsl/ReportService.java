package ec.edu.uce.erpmunicipal.contabilidad.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.contabilidad.orm.RepBalanceComprobacion;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepDiarioGeneralIntegrado;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepMayorGeneral;

@Local
public interface ReportService {

	List<RepDiarioGeneralIntegrado> readDiarioGeneralIntegrado();

	List<RepMayorGeneral> readMayorGeneral();

	List<RepBalanceComprobacion> readBalanceComprobacion();

}
