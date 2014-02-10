package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;

@Local
public interface PostulacionDAO extends AbstractFacade<PostulacionDTO>{

	List<PostulacionDTO> getAll(EmpresaDTO empresa) throws SilsagException;

	List<PostulacionDTO> getAll(CandidatoDTO candidatoDTO)
			throws SilsagException;

	List<PostulacionDTO> getAll() throws SilsagException;

	List<PostulacionDTO> getAll(Boolean estado) throws SilsagException;

	

}
