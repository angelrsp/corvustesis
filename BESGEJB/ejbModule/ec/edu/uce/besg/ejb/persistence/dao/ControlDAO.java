package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.ControlDTO;

public interface ControlDAO extends AbstractFacade<ControlDTO>{

	List<ControlDTO> getByAnd(ControlDTO objetoDTO) throws CorvustecException;

}
