package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.view.CuestionarioViewDTO;

public interface CuestionarioViewDAO {

	List<CuestionarioViewDTO> getByAnd(CuestionarioViewDTO objetoDTO)
			throws SecurityException;

}
