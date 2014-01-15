package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;

@Local
public interface CandidatoDAO extends AbstractFacade<CandidatoDTO>{

	List<CandidatoDTO> getAll() throws SilsagException;

	List<CandidatoDatoDTO> getData(CandidatoDTO can) throws SilsagException;

	List<CandidatoEstudioDTO> getCandidatoEstudio() throws SilsagException;

	List<CandidatoEstudioDTO> getCandidatoEstudio(CandidatoDTO candidatoDTO)
			throws SilsagException;


}
