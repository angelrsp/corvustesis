package net.ciespal.redxxi.ejb.negocio;

import javax.ejb.Local;

import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

import com.corvustec.commons.util.CorvustecException;

@Local
public interface AteneaService {

	CentroDTO centroCreate(CentroDTO centro) throws CorvustecException;

}
