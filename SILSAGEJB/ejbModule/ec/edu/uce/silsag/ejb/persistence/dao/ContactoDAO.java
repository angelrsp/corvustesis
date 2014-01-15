package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO>{

	List<ContactoDTO> getAll(EmpresaDTO empresa) throws SilsagException;



}
