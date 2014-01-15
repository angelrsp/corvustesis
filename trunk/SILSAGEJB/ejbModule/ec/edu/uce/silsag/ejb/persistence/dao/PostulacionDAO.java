package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionListDTO;

@Local
public interface PostulacionDAO extends AbstractFacade<PostulacionDTO>{

	List<PostulacionListDTO> getAll(EmpresaDTO empresa) throws SilsagException;

}
