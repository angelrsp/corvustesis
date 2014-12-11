package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.entity.ContactoListDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO> {

	List<ContactoListDTO> getByAnd(ContactoListDTO objeto)
			throws SecurityException;

}
