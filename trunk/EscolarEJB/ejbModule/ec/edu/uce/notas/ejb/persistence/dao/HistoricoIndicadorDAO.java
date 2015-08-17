package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.HistoricoIndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.IndicadorDTO;

public interface HistoricoIndicadorDAO extends AbstractFacade<HistoricoIndicadorDTO>{

	List<HistoricoIndicadorDTO> getAll(IndicadorDTO indicadorDTO)
			throws CorvustecException;

	void remove2(HistoricoIndicadorDTO historicoIndicadorDTO);

}
