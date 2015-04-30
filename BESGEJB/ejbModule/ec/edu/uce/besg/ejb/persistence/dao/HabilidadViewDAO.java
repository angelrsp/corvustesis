package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.view.HabilidadViewDTO;

public interface HabilidadViewDAO {

	List<HabilidadViewDTO> getByAnd(HabilidadViewDTO objeto)
			throws SecurityException;

}
