package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;

public interface ModalidadDAO extends AbstractFacade<ModalidadDTO>{

	List<ModalidadDTO> getAll(CarreraDTO carrera);

	void remove2(ModalidadDTO moda) throws CorvustecException;

}
