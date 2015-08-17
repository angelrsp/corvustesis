package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;

public interface PerfilDAO extends AbstractFacade<PerfilDTO> {

	List<PerfilDTO> getByAnd(PerfilDTO perfilDTO) throws CorvustecException;

}
