package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.EvidenciaDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;

public interface EvidenciaDAO extends AbstractFacade<EvidenciaDTO>{

	List<EvidenciaDTO> getAll(HistoricoIndicadorDTO historicoIndicadorDTO)
			throws IndicadoresException;

}
