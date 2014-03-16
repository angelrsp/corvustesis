package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

public interface ContactoDAO extends AbstractFacade<ContactoDTO>{

	List<ContactoListDTO> getAll(EntidadDTO entidad) throws CorvustecException;

	List<ContactoListDTO> getAll(CarreraDTO carrera) throws CorvustecException;

	List<ContactoListDTO> getAll(OrganizacionDTO organizacion)
			throws CorvustecException;

	List<ContactoDTO> getAll2(EntidadDTO entidad) throws CorvustecException;

	List<ContactoListDTO> getAll(DoctorDTO doctor) throws CorvustecException;

	void remove2(ContactoDTO contacto) throws CorvustecException;

	
}
