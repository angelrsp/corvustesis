package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.EntidadArgosDTO;

public interface ContactoArgosDAO extends AbstractFacade<ContactoArgosDTO>{

	List<ContactoArgosListDTO> getAll(EntidadArgosDTO entidad)
			throws CorvustecException;

}
