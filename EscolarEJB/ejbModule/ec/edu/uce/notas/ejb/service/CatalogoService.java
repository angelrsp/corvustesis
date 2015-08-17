package ec.edu.uce.notas.ejb.service;

import java.util.List;

import javax.ejb.Local;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.CatalogoDTO;

@Local
public interface CatalogoService {

	List<CatalogoDTO> readRegion() throws CorvustecException;

	List<CatalogoDTO> readAreaTrabajo() throws CorvustecException;

	List<CatalogoDTO> readEstadoCivil() throws CorvustecException;

	List<CatalogoDTO> readIdentificationType() throws CorvustecException;

	List<CatalogoDTO> readSex() throws CorvustecException;

	List<CatalogoDTO> readProvincia(Integer paisCode) throws CorvustecException;

	List<CatalogoDTO> readCiudad(Integer provinciaCode)
			throws CorvustecException;

	List<CatalogoDTO> readCatalogo(Integer code) throws CorvustecException;

	CatalogoDTO createOrUpdate(CatalogoDTO catalogoDTO)
			throws CorvustecException;

	CatalogoDTO readCatalogoById(int id) throws CorvustecException;

}
