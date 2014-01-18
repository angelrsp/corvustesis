package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsag.ejb.persistence.entities.RespuestaDTO;

public interface RespuestaDAO extends AbstractFacade<RespuestaDTO> {

	List<RespuestaDTO> getByType(int type);

	List<RespuestaDTO> getAll();

}
