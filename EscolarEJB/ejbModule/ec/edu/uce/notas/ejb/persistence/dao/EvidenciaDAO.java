package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.EvidenciaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoricoIndicadorDTO;

public interface EvidenciaDAO extends AbstractFacade<EvidenciaDTO>{

	List<EvidenciaDTO> getAll(HistoricoIndicadorDTO historicoIndicadorDTO)
			throws CorvustecException;

}
