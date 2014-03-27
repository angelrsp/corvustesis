package net.ciespal.redxxi.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;

import com.corvustec.commons.util.CorvustecException;

@Local
public interface EspejoService {

	EticaDTO createOrUpdateEtica(EticaDTO etica) throws CorvustecException;

	List<EticaDTO> readEtica(Object ciudad) throws CorvustecException;

	GranMaestroDTO createOrUpdateMaestroPeriodismo(GranMaestroDTO granMaestro)
			throws CorvustecException;

	List<GranMaestroDTO> readMaestroPeriodismo(Object ciudad)
			throws CorvustecException;

}
