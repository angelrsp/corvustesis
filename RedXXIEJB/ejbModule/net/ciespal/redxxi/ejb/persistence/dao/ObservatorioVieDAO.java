package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioVieDTO;

public interface ObservatorioVieDAO extends AbstractFacade<ObservatorioVieDTO> {

	List<ObservatorioVieDTO> getByAnd(ObservatorioVieDTO objetoDTO)
			throws CorvustecException;

	
}
