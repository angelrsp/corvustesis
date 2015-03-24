package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.ReferenciaDTO;

public interface ReferenciaDAO extends AbstractFacade<ReferenciaDTO>{

	List<ReferenciaDTO> getByAnd(ReferenciaDTO objeto) throws SecurityException;

}
