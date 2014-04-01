package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;

public interface NoticiaEspejoDAO extends AbstractFacade<NoticiaEspejoDTO>{

	List<NoticiaEspejoDTO> findAll(NoticiaEspejoDTO noticia)
			throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(EticaDTO etica) throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(GranMaestroDTO mestro)
			throws CorvustecException;

}
