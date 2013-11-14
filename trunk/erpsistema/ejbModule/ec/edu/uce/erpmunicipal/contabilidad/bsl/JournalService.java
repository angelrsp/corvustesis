package ec.edu.uce.erpmunicipal.contabilidad.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimiento;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimientoDetalle;
import ec.edu.uce.erpmunicipal.util.orm.SessionObject;

@Local
public interface JournalService {

	int create(SessionObject sessionObject, int claseCode,
			int tipoMovimientoCode, ConMovimiento movimiento,
			List<ConMovimientoDetalle> details);

	AccoutingService getAccoutingService();

	List<ConMovimiento> readAllMovimiento();

	List<ConMovimientoDetalle> readAllMovimientoDetalle(int movCode);
	

}
