package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;

@Local
public interface ServicioCatalogo {

	List<CatalogoDTO> readSector() throws CorvustecException;

	List<CatalogoDTO> readPais() throws CorvustecException;

	List<CatalogoDTO> readCargo() throws CorvustecException;

}
