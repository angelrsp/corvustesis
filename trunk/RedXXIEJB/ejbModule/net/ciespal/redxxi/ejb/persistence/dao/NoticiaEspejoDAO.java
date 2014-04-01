package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

public interface NoticiaEspejoDAO extends AbstractFacade<NoticiaEspejoDTO>{

	List<NoticiaEspejoDTO> findAll(NoticiaEspejoDTO noticia)
			throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(EticaDTO etica) throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(GranMaestroDTO mestro)
			throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(MaestroCiespalDTO mestro)
			throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(PremioDTO premio) throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(PremioCiespalDTO premio)
			throws CorvustecException;

	List<NoticiaEspejoDTO> findAll(LeyDTO ley) throws CorvustecException;

}
