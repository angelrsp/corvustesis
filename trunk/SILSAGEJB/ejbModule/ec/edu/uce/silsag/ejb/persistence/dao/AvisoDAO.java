package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;

@Local
public interface AvisoDAO extends AbstractFacade<AvisoDTO> {

	List<AvisoListDTO> getAll(EmpresaDTO empresa) throws SilsagException;

	List<AvisoListDTO> getOfertas() throws SilsagException;

}
