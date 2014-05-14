package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.DoctorVieDTO;

import com.corvustec.commons.util.CorvustecException;

public interface DoctorVieDAO extends AbstractFacade<DoctorVieDTO> {

	List<DoctorVieDTO> get(DoctorVieDTO doctorVieDTO) throws CorvustecException;

}
