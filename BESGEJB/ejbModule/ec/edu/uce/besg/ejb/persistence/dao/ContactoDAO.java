package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ContactoViewDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO> {

	List<ContactoViewDTO> getByAnd(ContactoViewDTO objeto)
			throws SecurityException;

}
