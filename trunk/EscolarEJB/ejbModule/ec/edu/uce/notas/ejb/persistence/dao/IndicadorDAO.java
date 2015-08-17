package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.notas.ejb.persistence.entity.IndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ModeloDTO;

public interface IndicadorDAO extends AbstractFacade<IndicadorDTO>{

	List<IndicadorDTO> getRoot(IndicadorDTO indicadorDTO);

	List<IndicadorDTO> getChildren(IndicadorDTO indicadorDTO);

	List<IndicadorDTO> getAll();

	List<IndicadorDTO> getAll(ModeloDTO modeloDTO);

	void remove2(IndicadorDTO indicador);

}
