package ec.edu.uce.indicadores.ejb.persistence.dao;

import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PermisoIndicadorDTO;

public interface PermisoIndicadorDAO extends AbstractFacade<PermisoIndicadorDTO>{

	void remove2(PerfilDTO perfil);

	void remove3(Object perfil);

	Boolean existe(IndicadorDTO indicador, PerfilDTO perfil);

}
