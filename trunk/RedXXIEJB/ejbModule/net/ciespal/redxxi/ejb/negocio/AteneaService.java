package net.ciespal.redxxi.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

import com.corvustec.commons.util.CorvustecException;

@Local
public interface AteneaService {

	CentroDTO createCentro(CentroDTO centro) throws CorvustecException;

	List<CentroDTO> obtenerCentroPadre() throws CorvustecException;

	List<CentroDTO> obtenerCentroHijo(CentroDTO centro)
			throws CorvustecException;

}
