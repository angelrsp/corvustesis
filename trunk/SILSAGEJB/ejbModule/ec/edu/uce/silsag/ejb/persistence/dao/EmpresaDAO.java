package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;

@Local
public interface EmpresaDAO extends AbstractFacade<EmpresaDTO>{

	List<EmpresaDTO> getAll() throws SilsagException;

	
}
