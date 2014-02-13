package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public interface OpcionDAO extends AbstractFacade<OpcionDTO>{

	List<OpcionDTO> getAll(PerfilDTO perfil);

	
}
