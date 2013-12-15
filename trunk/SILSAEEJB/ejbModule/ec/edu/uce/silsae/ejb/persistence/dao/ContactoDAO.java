package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO>{

	List<ContactoDTO> getAll(EmpresaDTO empresa) throws SilsaeException;



}
