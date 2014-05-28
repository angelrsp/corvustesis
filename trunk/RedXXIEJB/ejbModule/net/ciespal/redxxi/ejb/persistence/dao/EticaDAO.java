package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;

public interface EticaDAO extends AbstractFacade<EticaDTO>{

	List<EticaDTO> findAll(Object ciudad) throws CorvustecException;

	List<EticaDTO> getByAnd(EticaDTO objetoDTO) throws CorvustecException;

	int count(Object pais) throws CorvustecException;

}
