package ec.edu.uce.erpmunicipal.presupuesto.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.AccoutingService;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PrePrograma;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreProgramaCuenta;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreReforma;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreReformaDetalle;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreTipoProgramaCuenta;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreVerificacion;

@Local
public interface PresupuestoService {

	AccoutingService getAccoutingService();

	List<PrePrograma> readPrograms();

	PreTipoProgramaCuenta findByIdProgramCuenta(int code);

	void initialRegister(int programCode, List<PreProgramaCuenta> proCuenta);

	List<PreVerificacion> readVerification();

	void reform(PreReforma reform, List<PreReformaDetalle> detail);

}
