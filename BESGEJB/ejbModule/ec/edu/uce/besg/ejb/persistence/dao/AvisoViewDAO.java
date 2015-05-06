package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;

public interface AvisoViewDAO {

	List<AvisoViewDTO> getByAnd(AvisoViewDTO objeto) throws SecurityException;

}
