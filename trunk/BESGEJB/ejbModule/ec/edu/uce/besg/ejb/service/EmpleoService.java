package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.AvisoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;

@Local
public interface EmpleoService {

	AvisoDTO createOrUpdateAviso(AvisoDTO avisoDTO) throws CorvustecException;

	List<AvisoViewDTO> readAviso(AvisoViewDTO avisoViewDTO)
			throws CorvustecException;

	AvisoDTO findAviso(Object object) throws CorvustecException;

	
}
