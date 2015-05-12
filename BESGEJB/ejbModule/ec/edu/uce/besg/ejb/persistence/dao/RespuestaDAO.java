package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.RespuestaDTO;

public interface RespuestaDAO {

	List<RespuestaDTO> getByAnd(RespuestaDTO objetoDTO)
			throws SecurityException;

}
