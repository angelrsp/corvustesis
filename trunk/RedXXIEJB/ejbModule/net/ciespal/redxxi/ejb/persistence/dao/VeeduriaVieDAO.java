package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaVieDTO;

public interface VeeduriaVieDAO extends AbstractFacade<VeeduriaVieDTO>{

	List<VeeduriaVieDTO> getByAnd(VeeduriaVieDTO objetoDTO)
			throws CorvustecException;

	
}
