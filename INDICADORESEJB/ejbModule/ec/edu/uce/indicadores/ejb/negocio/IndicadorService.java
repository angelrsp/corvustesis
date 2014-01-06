package ec.edu.uce.indicadores.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;

@Local
public interface IndicadorService {

	List<RepresentanteLegalDTO> obtenerRepresentantes()
			throws IndicadoresException;

	void agregarRepresentanteLegal(RepresentanteLegalDTO representanteLegalDTO)
			throws IndicadoresException;

	List<ContactoDTO> obtenerContactos(
			RepresentanteLegalDTO representanteLegalDTO)
			throws IndicadoresException;

	void agregarContacto(ContactoDTO contactoDTO) throws IndicadoresException;

	List<IesDTO> obtenerIes() throws IndicadoresException;

	void agregarIes(IesDTO iesDTO) throws IndicadoresException;

	List<ModeloDTO> obtenerModelo() throws IndicadoresException;

}
