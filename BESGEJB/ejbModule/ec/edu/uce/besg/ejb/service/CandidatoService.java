package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.HabilidadViewDTO;
import ec.edu.uce.besg.ejb.vo.CandidatoVO;

@Local
public interface CandidatoService {

	CandidatoDTO registrarCandidato(CandidatoVO candidatoVO)
			throws CorvustecException;

	HabilidadDTO createOrUpdateHabilidad(HabilidadDTO habilidadDTO)
			throws CorvustecException;

	CandidatoDTO readCandidato(CandidatoDTO candidatoDTO)
			throws CorvustecException;

	CandidatoDTO updateCandidato(CandidatoDTO candidatoDTO)
			throws CorvustecException;

	List<HabilidadViewDTO> readHabilidadView(HabilidadViewDTO habilidadViewDTO)
			throws CorvustecException;


}
