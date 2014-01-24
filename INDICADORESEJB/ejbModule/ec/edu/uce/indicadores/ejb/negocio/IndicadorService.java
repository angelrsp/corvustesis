package ec.edu.uce.indicadores.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoListDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.EvidenciaDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RegistroDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalListDTO;

@Local
public interface IndicadorService {

	List<RepresentanteLegalListDTO> obtenerRepresentantes()
			throws IndicadoresException;

	void agregarRepresentanteLegal(RepresentanteLegalDTO representanteLegalDTO)
			throws IndicadoresException;

	List<ContactoListDTO> obtenerContactos(
			RepresentanteLegalDTO representanteLegalDTO)
			throws IndicadoresException;

	void agregarContacto(ContactoDTO contactoDTO) throws IndicadoresException;

	List<IesDTO> obtenerIes() throws IndicadoresException;

	void agregarIes(IesDTO iesDTO) throws IndicadoresException;

	List<ModeloDTO> obtenerModelo() throws IndicadoresException;

	void agregarIndicador(IndicadorDTO indicadorDTO)
			throws IndicadoresException;

	List<IndicadorDTO> obtenerRaizIndicador(IndicadorDTO indicadorDTO)
			throws IndicadoresException;

	List<IndicadorDTO> obtenerHijosIndicador(IndicadorDTO indicadorDTO)
			throws IndicadoresException;

	List<IndicadorDTO> obtenerIndicador() throws IndicadoresException;

	void agregarValor(HistoricoIndicadorDTO historicoIndicadorDTO)
			throws IndicadoresException;

	List<HistoricoIndicadorDTO> obtenerValores(IndicadorDTO indicadorDTO)
			throws IndicadoresException;

	void agregarEvidencia(EvidenciaDTO evidenciaDTO)
			throws IndicadoresException;

	List<EvidenciaDTO> obtenerEvidencias(
			HistoricoIndicadorDTO historicoIndicadorDTO)
			throws IndicadoresException;

	void agregarRegistro(RegistroDTO registroDTO) throws IndicadoresException;

	List<RegistroDTO> obtenerRegistro(
			RepresentanteLegalDTO representanteLegalDTO, IesDTO iesDTO)
			throws IndicadoresException;

	List<RegistroDTO> obtenerRegistro(IesDTO iesDTO)
			throws IndicadoresException;

	ModeloDTO agregarModelo(ModeloDTO modeloDTO) throws IndicadoresException;


}
