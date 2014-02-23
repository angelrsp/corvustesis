package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;

public interface IndicadorDAO extends AbstractFacade<IndicadorDTO>{

	List<IndicadorDTO> getRoot(IndicadorDTO indicadorDTO);

	List<IndicadorDTO> getChildren(IndicadorDTO indicadorDTO);

	List<IndicadorDTO> getAll();

	List<IndicadorDTO> getAll(ModeloDTO modeloDTO);

}
