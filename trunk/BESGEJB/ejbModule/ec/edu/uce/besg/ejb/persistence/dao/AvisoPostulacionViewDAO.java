package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoPostulacionViewDTO;

public interface AvisoPostulacionViewDAO extends AbstractFacade<AvisoPostulacionViewDTO> {

	List<AvisoPostulacionViewDTO> getByAnd(AvisoPostulacionViewDTO objeto)
			throws SecurityException;

	List<AvisoPostulacionViewDTO> getByAndToday(AvisoPostulacionViewDTO objeto)
			throws SecurityException;

	
}
