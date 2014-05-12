package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;

public interface ObservatorioDAO extends AbstractFacade<ObservatorioDTO> {

	List<ObservatorioDTO> findAll(Object ubicacion) throws CorvustecException;

	int count(Object pais) throws CorvustecException;

}
