package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.ModalidadVieDTO;

import com.corvustec.commons.util.CorvustecException;

public interface ModalidadVieDAO extends AbstractFacade<ModalidadVieDTO>{

	List<ModalidadVieDTO> getByAnd(ModalidadVieDTO objetoDTO)
			throws CorvustecException;

	
}
