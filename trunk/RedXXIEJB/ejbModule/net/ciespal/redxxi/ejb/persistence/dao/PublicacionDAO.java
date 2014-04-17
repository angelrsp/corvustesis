package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;

public interface PublicacionDAO extends AbstractFacade<PublicacionDTO>{

	List<PublicacionDTO> getAll(CarreraDTO carrera) throws CorvustecException;

	void remove2(PublicacionDTO pub);

	List<PublicacionDTO> getAll(Object ubicacion) throws CorvustecException;

	List<PublicacionDTO> getAll() throws CorvustecException;

	List<PublicacionDTO> getByType(Object type) throws CorvustecException;

	Integer getCountByType(Object type) throws CorvustecException;

	Integer getCountByType(Object type, Object pais) throws CorvustecException;

	List<PublicacionDTO> getAllNoEntity(Object ubicacion)
			throws CorvustecException;

	List<PublicacionDTO> getAll(DoctorDTO doctor);

	List<PublicacionDTO> getByType(Object type, Object pais)
			throws CorvustecException;

}
