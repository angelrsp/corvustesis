package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;

import com.corvustec.commons.util.CorvustecException;

public interface DoctorDAO extends AbstractFacade<DoctorDTO>{

	List<DoctorDTO> getAll(Object ubicacion) throws CorvustecException;

	List<DoctorDTO> getAll() throws CorvustecException;

	Integer getCount(Object pais) throws CorvustecException;

	List<DoctorDTO> getAll2(Object pais) throws CorvustecException;

	void remove2(DoctorDTO doctor);

	
}
