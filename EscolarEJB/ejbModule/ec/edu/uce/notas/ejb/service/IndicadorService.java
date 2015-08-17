package ec.edu.uce.notas.ejb.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.EvidenciaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoricoIndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.IndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ModeloDTO;

@Local
public interface IndicadorService {

	void createOrUpdateIndicador(IndicadorDTO indicadorDTO)
			throws CorvustecException;

	void deleteIndicador(IndicadorDTO indicador) throws CorvustecException;

	List<ModeloDTO> obtenerModelo() throws CorvustecException;

	ModeloDTO obtenerModelo(Object id) throws CorvustecException;

	List<IndicadorDTO> obtenerIndicador() throws CorvustecException;

	IndicadorDTO obtenerIndicador(Object id) throws CorvustecException;

	List<IndicadorDTO> obtenerRaizIndicador(IndicadorDTO indicadorDTO)
			throws CorvustecException;

	List<IndicadorDTO> obtenerHijosIndicador(IndicadorDTO indicadorDTO)
			throws CorvustecException;

	IndicadorDTO agregarValor(HistoricoIndicadorDTO historicoIndicadorDTO)
			throws CorvustecException;

	List<HistoricoIndicadorDTO> obtenerValores(IndicadorDTO indicadorDTO)
			throws CorvustecException;

	void actualizarValores(IndicadorDTO indicadorDTO) throws CorvustecException;

	BigDecimal sumarIdeal(IndicadorDTO indicadorDTO);

	void agregarEvidencia(EvidenciaDTO evidenciaDTO) throws CorvustecException;

	ModeloDTO createOrUpdateModelo(ModeloDTO modeloDTO)
			throws CorvustecException;

	void deleteModelo(ModeloDTO modeloDTO) throws CorvustecException;

	List<IndicadorDTO> obtenerIndicador(ModeloDTO modelo)
			throws CorvustecException;

	void deleteHistoricoIndicador(HistoricoIndicadorDTO his)
			throws CorvustecException;

	List<EvidenciaDTO> obtenerEvidencias(
			HistoricoIndicadorDTO historicoIndicadorDTO)
			throws CorvustecException;



}
