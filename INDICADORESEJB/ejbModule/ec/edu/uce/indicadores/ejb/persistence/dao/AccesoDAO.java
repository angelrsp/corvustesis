package ec.edu.uce.indicadores.ejb.persistence.dao;

import ec.edu.uce.indicadores.ejb.persistence.entities.AccesoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public interface AccesoDAO extends AbstractFacade<AccesoDTO>{

	void remove(PerfilDTO perfil);


}
