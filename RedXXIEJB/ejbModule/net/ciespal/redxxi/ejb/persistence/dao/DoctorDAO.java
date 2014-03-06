package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;

public interface DoctorDAO extends AbstractFacade<DoctorDTO>{

	List<DoctorDTO> getAll(Object ubicacion) throws CorvustecException;

	List<DoctorDTO> getAll() throws CorvustecException;

	Integer getCount() throws CorvustecException;

	Integer getCount(Object pais) throws CorvustecException;

	
}
