package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

@Local
public interface AvisoDAO extends AbstractFacade<AvisoDTO> {

	List<AvisoListDTO> getAll(EmpresaDTO empresa) throws SilsaeException;

	List<AvisoListDTO> getOfertas() throws SilsaeException;

}
