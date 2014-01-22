package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.dto.util.EstudioReportDTO;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.AnioEstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;

@Local
public interface CandidatoDAO extends AbstractFacade<CandidatoDTO>{

	List<CandidatoDTO> getAll() throws SilsagException;

	Boolean getByIdentificacion(CandidatoDTO candidatoDTO);

	List<CandidatoEstudioDTO> getCandidatoEstudio() throws SilsagException;

	List<CandidatoEstudioDTO> getCandidatoEstudio(int nivelEstudio, int genero)
			throws SilsagException;

	List<AnioEstudioDTO> getYearEstudio() throws SilsagException;

	List<EstudioReportDTO> getNivel() throws SilsagException;

	List<EstudioReportDTO> getNivel(int anio) throws SilsagException;


}
