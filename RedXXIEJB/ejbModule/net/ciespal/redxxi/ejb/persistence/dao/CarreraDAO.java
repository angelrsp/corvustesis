package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

public interface CarreraDAO extends AbstractFacade<CarreraDTO> {


	List<CarreraDTO> getAll(CentroDTO centro, Object tipo)
			throws CorvustecException;

	List<CarreraDTO> getByType(Object type) throws CorvustecException;

	Integer getPosgradoCount() throws CorvustecException;

	Integer getPregradoCount() throws CorvustecException;

	Integer getPregradoCount(Object pais) throws CorvustecException;

	Integer getPosgradoCount(Object pais) throws CorvustecException;

	List<CarreraDTO> getAll(Object type, Object pais) throws CorvustecException;

	List<CentroDTO> distinctPais(Object type, Object pais)
			throws CorvustecException;

	List<CentroDTO> distinctPais(Object type) throws CorvustecException;

	List<CentroDTO> distinctUniversidad(Object type, Object pais)
			throws CorvustecException;

}
