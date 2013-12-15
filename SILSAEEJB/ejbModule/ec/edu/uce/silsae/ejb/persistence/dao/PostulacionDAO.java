package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionListDTO;

@Local
public interface PostulacionDAO extends AbstractFacade<PostulacionDTO>{

	List<PostulacionListDTO> getAll(EmpresaDTO empresa) throws SilsaeException;

}
