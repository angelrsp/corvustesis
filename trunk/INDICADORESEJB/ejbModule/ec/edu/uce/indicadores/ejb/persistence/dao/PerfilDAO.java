package ec.edu.uce.indicadores.ejb.persistence.dao;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public interface PerfilDAO extends AbstractFacade<PerfilDTO>{

	void remove2(PerfilDTO perfil) throws IndicadoresException;

	
}
