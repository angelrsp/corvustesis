package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO>{

	List<ContactoDTO> getAll(EntidadDTO entidad) throws CorvustecException;

	
}
