package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;

public interface HistoricoIndicadorDAO extends AbstractFacade<HistoricoIndicadorDTO>{

	List<HistoricoIndicadorDTO> getAll(IndicadorDTO indicadorDTO)
			throws IndicadoresException;

	void remove2(HistoricoIndicadorDTO historicoIndicadorDTO);

}
