package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;

import com.corvustec.commons.util.CorvustecException;

public interface ObraEspejoDAO extends AbstractFacade<ObraEspejoDTO> {

	List<ObraEspejoDTO> findAll(GranMaestroDTO mestro, Object type)
			throws CorvustecException;

	List<ObraEspejoDTO> findAll(MaestroCiespalDTO mestro, Object type)
			throws CorvustecException;


}
