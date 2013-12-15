package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

@Local
public interface EmpresaDAO extends AbstractFacade<EmpresaDTO>{

	List<EmpresaDTO> getAll() throws SilsaeException;

	
}
