package net.ciespal.redxxi.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.EntidadArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

import com.corvustec.commons.util.CorvustecException;

@Local
public interface ArgosService {

	RedDTO createOrUpdateRed(RedDTO red) throws CorvustecException;
	List<RedDTO> readRed() throws CorvustecException;
	ObservatorioDTO createOrUpdateObservatorio(ObservatorioDTO observatorio)
			throws CorvustecException;
	List<ObservatorioDTO> readObservatorio(Object ciudad)
			throws CorvustecException;
	VeeduriaDTO createOrUpdateVeeduria(VeeduriaDTO veeduria)
			throws CorvustecException;
	List<VeeduriaDTO> readVeeduria(Object ciudad) throws CorvustecException;
	ContactoArgosDTO createOrUpdateContacto(ContactoArgosDTO contacto) throws CorvustecException;
	List<ContactoArgosListDTO> readContacto(EntidadArgosDTO entidad) throws CorvustecException;
	ContactoArgosDTO readContacto(Object id) throws CorvustecException;
	void deleteObservatorio(ObservatorioDTO observatorio)
			throws CorvustecException;
	void deleteContacto(ContactoArgosListDTO contactoList)
			throws CorvustecException;
	void deleteVeeduria(VeeduriaDTO veeduria) throws CorvustecException;

}
