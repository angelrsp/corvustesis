package ec.edu.uce.indicadores.ejb.persistence.dao;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioPerfilDTO;

public interface UsuarioPerfilDAO extends AbstractFacade<UsuarioPerfilDTO> {

	void remove2(UsuarioPerfilDTO userPerf) throws IndicadoresException;

}
