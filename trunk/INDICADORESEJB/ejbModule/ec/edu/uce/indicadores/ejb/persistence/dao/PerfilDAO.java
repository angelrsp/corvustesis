package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public interface PerfilDAO extends AbstractFacade<PerfilDTO>{

	void remove2(PerfilDTO perfil) throws IndicadoresException;

	List<PerfilDTO> getByName(PerfilDTO perfil) throws IndicadoresException;

	
}
