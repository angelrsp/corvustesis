package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.entity.ContactoDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO> {

	List<ContactoDTO> getByAnd(ContactoDTO objeto) throws SecurityException;

}
