package ec.edu.uce.notas.ejb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.persistence.entity.EvidenciaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoricoIndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.IndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ModeloDTO;
import ec.edu.uce.notas.ejb.service.IndicadorService;


@Stateless
public class IndicadorServiceImpl implements IndicadorService {

	@EJB
	private FactoryDAO factoryDAO;
	
	//private static final Logger log = LoggerFactory.getLogger(IndicadorServiceImpl.class);

	
	@Override
	public void createOrUpdateIndicador(IndicadorDTO indicadorDTO) throws CorvustecException
	{
		try {
			if(indicadorDTO.getIndCodigo()!=null)
				factoryDAO.getIndicadorDAOImpl().update(indicadorDTO);
			else
				factoryDAO.getIndicadorDAOImpl().create(indicadorDTO);
		} catch (Exception e) {
			//log.error(e.toString());
			throw new CorvustecException(e);
		}
	}

	@Override
	public void deleteIndicador(IndicadorDTO indicador) throws CorvustecException
	{
		try {
			if(factoryDAO.getIndicadorDAOImpl().getChildren(indicador).isEmpty())
				factoryDAO.getIndicadorDAOImpl().remove2(indicador);
			else
				throw new CorvustecException("No se puede eliminar revise las dependencias del indicador seleccionado");
		} catch (Exception e) {
			throw new CorvustecException("No se puede eliminar revise las dependencias del indicador seleccionado");
		}
	}
	
	
	@Override
	public List<ModeloDTO> obtenerModelo() throws CorvustecException
	{
		try {
			return factoryDAO.getModeloDAOImpl().getAll();
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	@Override
	public ModeloDTO obtenerModelo(Object id) throws CorvustecException
	{
		try {
			return factoryDAO.getModeloDAOImpl().find(id);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	@Override
	public List<IndicadorDTO> obtenerIndicador() throws CorvustecException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getAll();
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	
	@Override
	public IndicadorDTO obtenerIndicador(Object id) throws CorvustecException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().find(id);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	@Override
	public List<IndicadorDTO> obtenerRaizIndicador(IndicadorDTO indicadorDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getRoot(indicadorDTO);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}

	@Override
	public List<IndicadorDTO> obtenerHijosIndicador(IndicadorDTO indicadorDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getChildren(indicadorDTO);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}

	
	@Override
	public IndicadorDTO agregarValor(HistoricoIndicadorDTO historicoIndicadorDTO) throws CorvustecException
	{
		IndicadorDTO ind;
		try {
			
			ind= factoryDAO.getIndicadorDAOImpl().find(historicoIndicadorDTO.getIndIndicador().getIndCodigo());
			if(ind.getIndValorInicial()==null)
				ind.setIndValorInicial(historicoIndicadorDTO.getHinValor());				
			ind.setIndValorActual(historicoIndicadorDTO.getHinValor());
			factoryDAO.getIndicadorDAOImpl().update(ind);
			factoryDAO.getHistoricoIndicadorDAOImpl().create(historicoIndicadorDTO);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
		return ind;
	}
	
	
	@Override
	public List<HistoricoIndicadorDTO> obtenerValores(IndicadorDTO indicadorDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getHistoricoIndicadorDAOImpl().getAll(indicadorDTO);
		}catch (Exception e) {
			throw new CorvustecException(e);
		}
		
	}
	
	@Override
	public void actualizarValores(IndicadorDTO indicadorDTO) throws CorvustecException
	{
		BigDecimal inicial = BigDecimal.ZERO,actual=BigDecimal.ZERO;

		inicial=valor(indicadorDTO).get(0);
		actual=valor(indicadorDTO).get(1);
		indicadorDTO.setIndValorInicial(inicial);
		indicadorDTO.setIndValorActual(actual);
		
		BigDecimal sumaIdeal=sumarIdeal(indicadorDTO);
		
		if(sumaIdeal.doubleValue()>indicadorDTO.getIndMinimo().doubleValue())
		{
			indicadorDTO.setIndMinimo(sumaIdeal);
		}
		factoryDAO.getIndicadorDAOImpl().update(indicadorDTO);
	}
	
	
	@Override
	public BigDecimal sumarIdeal(IndicadorDTO indicadorDTO)
	{
		BigDecimal ideal=BigDecimal.ZERO;
		if(!factoryDAO.getIndicadorDAOImpl().getChildren(indicadorDTO).isEmpty())
		{
			for(IndicadorDTO ind: factoryDAO.getIndicadorDAOImpl().getChildren(indicadorDTO))
			{
				ideal=BigDecimal.valueOf(sumarIdeal(ind).doubleValue()+ideal.doubleValue());
			}
		}
		else
		{
			ideal=indicadorDTO.getIndMinimo();
		}
		return ideal;
	}
	
	
	
	private List<BigDecimal> valor(IndicadorDTO ind) throws CorvustecException
	{
		List<HistoricoIndicadorDTO> hisListAux=null;
		hisListAux= factoryDAO.getHistoricoIndicadorDAOImpl().getAll(ind);
		List<BigDecimal> listVal=new ArrayList<BigDecimal>();
		List<BigDecimal> listValTemp=new ArrayList<BigDecimal>();
		
		listVal.add(0, BigDecimal.ZERO);
		listVal.add(1, BigDecimal.ZERO);
				
		int tam;
		//IndicadorDTO indTemp;
		BigDecimal inicial = BigDecimal.ZERO,actual=BigDecimal.ZERO;
		if(hisListAux!=null)
		{
			tam=hisListAux.size();
			listVal.set(0, BigDecimal.valueOf(listVal.get(0).doubleValue()+hisListAux.get(0).getHinValor().doubleValue()));
			listVal.set(1, BigDecimal.valueOf(listVal.get(1).doubleValue()+hisListAux.get(tam-1).getHinValor().doubleValue()));
		}
		else
		{
			for(IndicadorDTO indi: factoryDAO.getIndicadorDAOImpl().getChildren(ind))
			{
				listValTemp=valor(indi);
				listVal.set(0, BigDecimal.valueOf(inicial.doubleValue()+ listValTemp.get(0).doubleValue()));
				listVal.set(1,BigDecimal.valueOf(actual.doubleValue()+listValTemp.get(1).doubleValue()));
				
				inicial=listVal.get(0);
				actual=listVal.get(1);				
			}
			if(factoryDAO.getIndicadorDAOImpl().getChildren(ind).size()>0)
			{
				ind.setIndValorInicial(inicial);
				ind.setIndValorActual(actual);
				factoryDAO.getIndicadorDAOImpl().update(ind);
			}			
		}
		return listVal;
	}
	
	@Override
	public void agregarEvidencia(EvidenciaDTO evidenciaDTO) throws CorvustecException
	{
		try {
			factoryDAO.getEvidenciaDAOImpl().create(evidenciaDTO);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	
	@Override
	public List<EvidenciaDTO> obtenerEvidencias(HistoricoIndicadorDTO historicoIndicadorDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getEvidenciaDAOImpl().getAll(historicoIndicadorDTO);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	

	
	@Override
	public ModeloDTO createOrUpdateModelo(ModeloDTO modeloDTO) throws CorvustecException
	{
		try {
			if(modeloDTO.getModCodigo()!=null)
				return factoryDAO.getModeloDAOImpl().update(modeloDTO);
			else
				return factoryDAO.getModeloDAOImpl().create(modeloDTO);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	@Override
	public void deleteModelo(ModeloDTO modeloDTO) throws CorvustecException
	{
		try {
			if(obtenerIndicador(modeloDTO)==null)
				factoryDAO.getModeloDAOImpl().remove2(modeloDTO);
			else
				throw new CorvustecException("No se puede borrar existen dependencias");
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	@Override
	public List<IndicadorDTO> obtenerIndicador(ModeloDTO modelo) throws CorvustecException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getAll(modelo);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}

	}
	
	@Override
	public void deleteHistoricoIndicador(HistoricoIndicadorDTO his) throws CorvustecException
	{
		try {
			factoryDAO.getHistoricoIndicadorDAOImpl().remove2(his);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}		
	}
}
