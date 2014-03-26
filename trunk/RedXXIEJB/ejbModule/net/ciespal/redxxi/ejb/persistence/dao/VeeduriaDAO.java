package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

public interface VeeduriaDAO extends AbstractFacade<VeeduriaDTO>{

	List<VeeduriaDTO> findAll(Object ubicacion) throws CorvustecException;

}
