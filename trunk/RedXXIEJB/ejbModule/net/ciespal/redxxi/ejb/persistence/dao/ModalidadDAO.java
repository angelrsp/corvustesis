package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;

public interface ModalidadDAO extends AbstractFacade<ModalidadDTO>{

	List<ModalidadDTO> getAll(CarreraDTO carrera);

}
