package ec.edu.uce.erpmunicipal.contabilidad.bsl;

import java.util.List;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimientoDetalle;

public interface JournalService {

	void create(List<ConMovimientoDetalle> details);

}
