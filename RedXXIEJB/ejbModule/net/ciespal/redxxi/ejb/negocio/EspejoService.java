package net.ciespal.redxxi.ejb.negocio;

import java.util.List;

import javax.ejb.Local;




import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

import com.corvustec.commons.util.CorvustecException;

@Local
public interface EspejoService {

	EticaDTO createOrUpdateEtica(EticaDTO etica) throws CorvustecException;

	List<EticaDTO> readEtica(Object ciudad) throws CorvustecException;

	GranMaestroDTO createOrUpdateMaestroPeriodismo(GranMaestroDTO granMaestro)
			throws CorvustecException;

	List<GranMaestroDTO> readMaestroPeriodismo(Object ciudad)
			throws CorvustecException;

	MaestroCiespalDTO createOrUpdateMaestroCiespal(MaestroCiespalDTO maestro)
			throws CorvustecException;

	List<MaestroCiespalDTO> readMaestroCiespal(Object ciudad)
			throws CorvustecException;

	PremioDTO createOrUpdatePremio(PremioDTO premio) throws CorvustecException;

	List<PremioDTO> readPremio(Object ciudad) throws CorvustecException;

	PremioCiespalDTO createOrUpdatepremioCiespal(PremioCiespalDTO premioCiespal)
			throws CorvustecException;

	List<PremioCiespalDTO> readPremioCiespal(Object ciudad)
			throws CorvustecException;

	LeyDTO createOrUpdateley(LeyDTO leyDTO) throws CorvustecException;

	List<LeyDTO> readLey(Object ciudad) throws CorvustecException;

	NoticiaEspejoDTO createOrUpdateNoticia(NoticiaEspejoDTO noticia) throws CorvustecException;

	

}
