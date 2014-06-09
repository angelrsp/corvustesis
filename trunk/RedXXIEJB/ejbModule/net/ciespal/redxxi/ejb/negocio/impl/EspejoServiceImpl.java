package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EntidadEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class EspejoServiceImpl implements EspejoService{

	private static final Logger logger = LoggerFactory.getLogger(EspejoServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public List<EspejoDTO> readEspejo(Object pais) throws CorvustecException
	{
		List<EspejoDTO> espejoList;
		EspejoDTO espejo;
		logger.info("readEspejo");
		try{
			espejoList=new ArrayList<EspejoDTO>();

			//Etica y Deontologia
			espejo=new EspejoDTO();
			espejo.setTipo(1);
			espejo.setDescripcion("Etica y Deontologia: ");
			espejo.setCount(factoryDAO.getEticaDAOImpl().count(pais));
			espejoList.add(espejo);

			//Grandes maestros del periodismo
			espejo=new EspejoDTO();
			espejo.setTipo(2);
			espejo.setDescripcion("Grandes Maestros del Periodismo: ");
			espejo.setCount(factoryDAO.getGranMaestroDAOImpl().count(pais));
			espejoList.add(espejo);

			//Maestros Ciespal
			espejo=new EspejoDTO();
			espejo.setTipo(3);
			espejo.setDescripcion("Grandes Maestros de la Comunicación: ");
			espejo.setCount(factoryDAO.getMaestroCiespalDAOImpl().count(pais));
			espejoList.add(espejo);

			//Premios periodisticos
			espejo=new EspejoDTO();
			espejo.setTipo(4);
			espejo.setDescripcion("Premios Periodísticos: ");
			espejo.setCount(factoryDAO.getPremioDAOImpl().count(pais));
			espejoList.add(espejo);

			//Codigo etica leyes y comunicacion
			espejo=new EspejoDTO();
			espejo.setTipo(5);
			espejo.setDescripcion("Códigos de Ética y Leyes de Comunicación: ");
			espejo.setCount(factoryDAO.getLeyDAOImpl().count(pais));
			espejoList.add(espejo);

		}
		catch(Exception e){
			logger.info("Error readEspejo {}",e.toString());
			throw new CorvustecException("Error al readEspejo "+e.toString());
		}
		return espejoList;
	}

	
	@Override
	public int readEspejoCount() throws CorvustecException
	{
		int total;
		try {
			total = factoryDAO.getEticaDAOImpl().count(null)+
			factoryDAO.getGranMaestroDAOImpl().count(null)+
			factoryDAO.getMaestroCiespalDAOImpl().count(null)+
			factoryDAO.getPremioDAOImpl().count(null)+
			factoryDAO.getLeyDAOImpl().count(null);
		}catch(Exception e)
		{
			logger.info("Error readEspejoCount {}",e.toString());
			throw new CorvustecException("Error al readEspejoCount " + e.toString());
		}
		return total;
	}

	@Override
	public List<PaisDTO> readPais(Object type) throws CorvustecException
	{
		List<PaisDTO> paisList=new ArrayList<PaisDTO>();
		PaisDTO pais;
		CatalogoDTO catalogo;

		catalogo=new CatalogoDTO();
		catalogo.setCatCodigo(13);
		
		if(type==null)
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				paisList.add(pais);
			}
		}
		//Etica
		else if(type.equals(1))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getEticaDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}
		//Gran Maestro
		else if(type.equals(2))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getGranMaestroDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}
		//Maestros ciespal (Maestros del periodismo)
		else if(type.equals(3))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getMaestroCiespalDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}
		//Premios Perdiodisticos
		else if(type.equals(4))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getPremioDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}
		//Leyes
		else if(type.equals(5))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getLeyDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}
		return paisList;
		
	}
	
	@Override
	public List<EspejoVisorDTO> visorList(EspejoDTO espejo) throws CorvustecException
	{
		List<EspejoVisorDTO> espejoVisorList=new ArrayList<EspejoVisorDTO>();
		EspejoVisorDTO espejoVisor;
		
		if(espejo.getTipo()==0)
		{
		}
		//Etica
		else if(espejo.getTipo()==1)
		{
			EticaDTO eti=new EticaDTO();
			eti.setEtiPais(espejo.getPais());
			List<EticaDTO> listEtica=new ArrayList<EticaDTO>();
			
			listEtica=factoryDAO.getEticaDAOImpl().getByAnd(eti);
			
			for(EticaDTO objeto:listEtica){
					
				espejoVisor=new EspejoVisorDTO();
				espejoVisor.setCodigo(objeto.getEtiCodigo());
				
				espejoVisor.setTitulo("Nombres y Apellidos: " +objeto.getEtiAutorNombre()+" "+objeto.getEtiAutorApellido());
				espejoVisor.setDescripcion1("Título de la Obra :"+objeto.getEtiTituloObra());
				espejoVisor.setTipo(espejo.getTipo());

				espejoVisorList.add(espejoVisor);
				
			}	
		}
		//Gran Maestro
		else if(espejo.getTipo()==2)
		{
			GranMaestroDTO gma=new GranMaestroDTO();
			gma.setGmaPais(espejo.getPais());
			List<GranMaestroDTO> listGma=new ArrayList<GranMaestroDTO>();
			
			listGma=factoryDAO.getGranMaestroDAOImpl().getByAnd(gma);
			
			for(GranMaestroDTO objeto:listGma){
					
				espejoVisor=new EspejoVisorDTO();
				espejoVisor.setCodigo(objeto.getGmaCodigo());
				
				espejoVisor.setTitulo("Nombres y Apellidos: " +objeto.getGmaNombres()+" "+objeto.getGmaApellidos());
				espejoVisor.setDescripcion1("Fecha de Nacimiento :"+objeto.getGmaFechaNacimiento());
				
				espejoVisor.setTipo(espejo.getTipo());

				espejoVisorList.add(espejoVisor);
				
			}	
		}
		//Gran Periodismo
		else if(espejo.getTipo()==3)
		{
			MaestroCiespalDTO mci=new MaestroCiespalDTO();
			mci.setMciPais(espejo.getPais());
			List<MaestroCiespalDTO> listMci=new ArrayList<MaestroCiespalDTO>();
			
			listMci=factoryDAO.getMaestroCiespalDAOImpl().getByAnd(mci);
			
			for(MaestroCiespalDTO objeto:listMci){
					
				espejoVisor=new EspejoVisorDTO();
				espejoVisor.setCodigo(objeto.getMciCodigo());
				
				espejoVisor.setTitulo("Nombres y Apellidos: " +objeto.getMciNombre()+" "+objeto.getMciApellido());
				espejoVisor.setDescripcion1("Fecha de Nacimiento :"+objeto.getMciFechaNacimiento());
				
				espejoVisor.setTipo(espejo.getTipo());

				espejoVisorList.add(espejoVisor);
				
			}	
		}
		//Premio
		else if(espejo.getTipo()==4)
		{
			PremioDTO pre=new PremioDTO();
			pre.setPrePais(espejo.getPais());
			List<PremioDTO> listPre=new ArrayList<PremioDTO>();
			
			listPre=factoryDAO.getPremioDAOImpl().getByAnd(pre);
			
			for(PremioDTO objeto:listPre){
					
				espejoVisor=new EspejoVisorDTO();
				espejoVisor.setCodigo(objeto.getPreCodigo());
				
				espejoVisor.setTitulo("Nombre del Premio: " +objeto.getPreTitulo());
				espejoVisor.setDescripcion1("Institucion Otorga :"+objeto.getPreInstitucion());
				
				espejoVisor.setTipo(espejo.getTipo());

				espejoVisorList.add(espejoVisor);
				
			}	
		}
		//Leyes
		else if(espejo.getTipo()==5)
		{
			LeyDTO ley=new LeyDTO();
			ley.setLeyPais(espejo.getPais());
			List<LeyDTO> listPre=new ArrayList<LeyDTO>();
			
			listPre=factoryDAO.getLeyDAOImpl().getByAnd(ley);
			
			for(LeyDTO objeto:listPre){
					
				espejoVisor=new EspejoVisorDTO();
				espejoVisor.setCodigo(objeto.getLeyCodigo());
				
				espejoVisor.setTitulo("Título: " +objeto.getLeytitulo());
				espejoVisor.setDescripcion1("Año de Emisión :"+objeto.getLeyAnio());
				espejoVisor.setDescripcion2("Institución :"+objeto.getLeyEntidadEmisora());
				
				espejoVisor.setTipo(espejo.getTipo());

				espejoVisorList.add(espejoVisor);
				
			}	
		}

		return espejoVisorList;
	}

	
	
	/*Etica*/
	@Override
	public EticaDTO createOrUpdateEtica(EticaDTO etica) throws CorvustecException
	{
		logger.info("createOrUpdateEtica");
		try{
			if(etica.getEtiCodigo()!=null)
				return factoryDAO.getEticaDAOImpl().edit(etica);
			else			
			{
				etica.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getEticaDAOImpl().create(etica);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateRed {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateRed");
		}
	}

	@Override
	public List<EticaDTO> readEtica(Object ciudad) throws CorvustecException
	{
		logger.info("readEtica");
		try{
			return factoryDAO.getEticaDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readEtica {}",e.toString());
			throw new CorvustecException("Error al readEtica");
		}
	}

	@Override
	public void deleteEtica(EticaDTO etica) throws CorvustecException
	{
		logger.info("deleteEtica");
		List<NoticiaEspejoDTO> listNoticia;
		try{
			listNoticia=factoryDAO.getNoticiaEspejoDAOImpl().findAll(etica);
			if(listNoticia!=null)
			{
				for(NoticiaEspejoDTO noti:listNoticia)
					factoryDAO.getNoticiaEspejoDAOImpl().remove(noti);
			}
			factoryDAO.getEticaDAOImpl().remove(etica);
		}
		catch(Exception e){
			logger.info("Error deleteEtica {}",e.toString());
			throw new CorvustecException("Error al deleteEtica " + e.toString());
		}
	}

	
	
	/*Maestro Periodismo*/
	@Override
	public GranMaestroDTO createOrUpdateMaestroPeriodismo(GranMaestroDTO granMaestro) throws CorvustecException
	{
		logger.info("createOrUpdateMaestroPeriodismo");
		try{
			if(granMaestro.getGmaCodigo()!=null)
				return factoryDAO.getGranMaestroDAOImpl().edit(granMaestro);
			else			
			{
				granMaestro.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getGranMaestroDAOImpl().create(granMaestro);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateMaestroPeriodismo {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroPeriodismo");
		}
	}

	@Override
	public List<GranMaestroDTO> readMaestroPeriodismo(Object ciudad) throws CorvustecException
	{
		logger.info("readMaestroPeriodismo");
		try{
			return factoryDAO.getGranMaestroDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readMaestroPeriodismo {}",e.toString());
			throw new CorvustecException("Error al readMaestroPeriodismo");
		}
	}

	@Override
	public void deleteMaestroPeriodismo(GranMaestroDTO granMaestro) throws CorvustecException
	{
		logger.info("deleteMaestroPeriodismo");
		List<NoticiaEspejoDTO> listNoti;
		List<ObraEspejoDTO> listObra;
		try{
			listNoti= factoryDAO.getNoticiaEspejoDAOImpl().findAll(granMaestro);
			if(listNoti!=null)
			{
				for(NoticiaEspejoDTO not:listNoti)
					factoryDAO.getNoticiaEspejoDAOImpl().remove(not);
			}
			listObra= factoryDAO.getObraEspejoDAOImpl().findAll(granMaestro, 1);
			if(listObra!=null)
			{
				for(ObraEspejoDTO obr:listObra)
					factoryDAO.getObraEspejoDAOImpl().remove(obr);
			}
			listObra= factoryDAO.getObraEspejoDAOImpl().findAll(granMaestro, 2);
			if(listObra!=null)
			{
				for(ObraEspejoDTO obr:listObra)
					factoryDAO.getObraEspejoDAOImpl().remove(obr);
			}			
			factoryDAO.getGranMaestroDAOImpl().remove(granMaestro);
		}
		catch(Exception e)
		{
			logger.info("Error readMaestroPeriodismo {}",e.toString());
			throw new CorvustecException("Error al readMaestroPeriodismo");
		}
	}

	
	@Override
	public GranMaestroDTO getRandomGranMaesto() throws CorvustecException
	{
		logger.info("getRandomGranMaesto");
		int ran;
		try{
			List<GranMaestroDTO> list=factoryDAO.getGranMaestroDAOImpl().getByAnd(new GranMaestroDTO());
			if(!list.isEmpty())
			{
				ran = (int) (Math.random () * list.size());
				return list.get(ran);
			}
			else
				return new GranMaestroDTO();
		}
		catch(Exception e){
			logger.info("Error readDoctor {}",e.toString());
			throw new CorvustecException("Error al readDoctor");
		}		
	}
	
	/*Maestro Ciespal*/
	@Override
	public MaestroCiespalDTO createOrUpdateMaestroCiespal(MaestroCiespalDTO maestro) throws CorvustecException
	{
		logger.info("createOrUpdateMaestroCiespal");
		try{
			if(maestro.getMciCodigo()!=null)
				return factoryDAO.getMaestroCiespalDAOImpl().edit(maestro);
			else			
			{
				maestro.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getMaestroCiespalDAOImpl().create(maestro);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateMaestroCiespal {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroCiespal");
		}
	}

	@Override
	public void deleteMaestroCiespal(MaestroCiespalDTO maestro) throws CorvustecException
	{
		logger.info("deleteMaestroCiespal");
		List<NoticiaEspejoDTO> listNoti;
		List<ObraEspejoDTO> listObra;
		try{
			listNoti= factoryDAO.getNoticiaEspejoDAOImpl().findAll(maestro);
			if(listNoti!=null)
			{
				for(NoticiaEspejoDTO not:listNoti)
					factoryDAO.getNoticiaEspejoDAOImpl().remove(not);
			}
			listObra= factoryDAO.getObraEspejoDAOImpl().findAll(maestro, 1);
			if(listObra!=null)
			{
				for(ObraEspejoDTO obr:listObra)
					factoryDAO.getObraEspejoDAOImpl().remove(obr);
			}
			factoryDAO.getMaestroCiespalDAOImpl().remove(maestro);
		}
		catch(Exception e)
		{
			logger.info("Error deleteMaestroCiespal {}",e.toString());
			throw new CorvustecException("Error al deleteMaestroCiespal "+e.toString());
		}
	}

	
	@Override
	public List<MaestroCiespalDTO> readMaestroCiespal(Object ciudad) throws CorvustecException
	{
		logger.info("readMaestroCiespal");
		try{
			return factoryDAO.getMaestroCiespalDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readMaestroCiespal {}",e.toString());
			throw new CorvustecException("Error al readMaestroCiespal");
		}
	}

	@Override
	public MaestroCiespalDTO getRandomMaestoCiespal() throws CorvustecException
	{
		logger.info("getRandomMaestoCiespal");
		int ran;
		try{
			List<MaestroCiespalDTO> list=factoryDAO.getMaestroCiespalDAOImpl().getByAnd(new MaestroCiespalDTO());
			if(!list.isEmpty())
			{
				ran = (int) (Math.random () * list.size());
				return list.get(ran);
			}
			else
				return new MaestroCiespalDTO();
		}
		catch(Exception e){
			logger.info("Error getRandomMaestoCiespal {}",e.toString());
			throw new CorvustecException("Error al getRandomMaestoCiespal "+e.toString());
		}		
	}
	
	/*Premio Periodistico*/
	@Override
	public PremioDTO createOrUpdatePremio(PremioDTO premio) throws CorvustecException
	{
		logger.info("createOrUpdatePremio");
		try{
			if(premio.getPreCodigo()!=null)
				return factoryDAO.getPremioDAOImpl().edit(premio);
			else			
			{
				premio.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getPremioDAOImpl().create(premio);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdatePremio {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroCiespal");
		}
	}

	@Override
	public void deletePremio(PremioDTO premio) throws CorvustecException
	{
		logger.info("deletePremio");
		List<NoticiaEspejoDTO> listNoticia;
		try{
			listNoticia= factoryDAO.getNoticiaEspejoDAOImpl().findAll(premio);
			if(listNoticia!=null)
			{
				for(NoticiaEspejoDTO not:listNoticia)
					factoryDAO.getNoticiaEspejoDAOImpl().remove(not);
			}
			factoryDAO.getPremioDAOImpl().remove(premio);
		}
		catch(Exception e){
			logger.info("Error createOrUpdatePremio {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroCiespal");
		}
	}

	
	@Override
	public List<PremioDTO> readPremio(Object ciudad) throws CorvustecException
	{
		logger.info("readPremio");
		try{
			return factoryDAO.getPremioDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readPremio {}",e.toString());
			throw new CorvustecException("Error al readPremio");
		}
	}
	
	
	/*Premio Ciespal*/
	@Override
	public PremioCiespalDTO createOrUpdatepremioCiespal(PremioCiespalDTO premioCiespal) throws CorvustecException
	{
		logger.info("createOrUpdatepremioCiespal");
		try{
			if(premioCiespal.getPciCodigo()!=null)
				return factoryDAO.getPremioCiespalDAOImpl().edit(premioCiespal);
			else			
			{
				premioCiespal.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getPremioCiespalDAOImpl().create(premioCiespal);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdatepremioCiespal {}",e.toString());
			throw new CorvustecException("Error al createOrUpdatepremioCiespal");
		}
	}

	@Override
	public List<PremioCiespalDTO> readPremioCiespal(Object ciudad) throws CorvustecException
	{
		logger.info("readPremioCiespal");
		try{
			return factoryDAO.getPremioCiespalDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readPremio {}",e.toString());
			throw new CorvustecException("Error al readPremio");
		}
	}

	@Override
	public void deletePremioCiespal(PremioCiespalDTO premioCiespal) throws CorvustecException
	{
		logger.info("deletePremioCiespal");
		List<NoticiaEspejoDTO> listNoticia;
		try{
			listNoticia= factoryDAO.getNoticiaEspejoDAOImpl().findAll(premioCiespal);
			if(listNoticia!=null)
			{
				for(NoticiaEspejoDTO not:listNoticia)
					factoryDAO.getNoticiaEspejoDAOImpl().remove(not);
			}
			factoryDAO.getPremioCiespalDAOImpl().remove(premioCiespal);
		}
		catch(Exception e){
			logger.info("Error deletePremioCiespal {}",e.toString());
			throw new CorvustecException("Error al deletePremioCiespal "+e.toString());
		}
	}

	
	/*LeyCodigo */
	@Override
	public LeyDTO createOrUpdateley(LeyDTO leyDTO) throws CorvustecException
	{
		logger.info("createOrUpdateley");
		try{
			if(leyDTO.getLeyCodigo()!=null)
				return factoryDAO.getLeyDAOImpl().edit(leyDTO);
			else			
			{
				leyDTO.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getLeyDAOImpl().create(leyDTO);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateley {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateley");
		}
	}

	@Override
	public List<LeyDTO> readLey(Object ciudad) throws CorvustecException
	{
		logger.info("readLey");
		try{
			return factoryDAO.getLeyDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readLey {}",e.toString());
			throw new CorvustecException("Error al readLey");
		}
	}
	
	/*Noticia*/
	@Override
	public NoticiaEspejoDTO createOrUpdateNoticia(NoticiaEspejoDTO noticia) throws CorvustecException
	{
		logger.info("createOrUpdateNoticia");
		try{
			if(noticia.getNotCodigo()!=null)
				return factoryDAO.getNoticiaEspejoDAOImpl().edit(noticia);
			else			
				return factoryDAO.getNoticiaEspejoDAOImpl().create(noticia);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateNoticia {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateNoticia");
		}		
	}
	
	@Override
	public List<NoticiaEspejoDTO> readNoticia(NoticiaEspejoDTO noticia) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(noticia);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(EticaDTO etica) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(etica);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(GranMaestroDTO maestro) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(maestro);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(MaestroCiespalDTO maestro) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(maestro);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(PremioDTO premio) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(premio);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(PremioCiespalDTO premio) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(premio);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(LeyDTO ley) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(ley);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public void deleteNoticia(NoticiaEspejoDTO noti) throws CorvustecException
	{
		logger.info("deleteNoticia");
		try{
			factoryDAO.getNoticiaEspejoDAOImpl().remove(noti);
		}
		catch(Exception e)
		{
			logger.info("Error deleteNoticia {}",e.toString());
			throw new CorvustecException("Error al deleteNoticia "+e.toString());
		}		
	}
	
	/*Obra*/
	@Override
	public ObraEspejoDTO createOrUpdateObra(ObraEspejoDTO obra) throws CorvustecException
	{
		logger.info("createOrUpdateObra");
		try{
			if(obra.getObrCodigo()!=null)
				return factoryDAO.getObraEspejoDAOImpl().edit(obra);
			else			
				return factoryDAO.getObraEspejoDAOImpl().create(obra);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateObra {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateObra");
		}		
	}
	
	@Override
	public List<ObraEspejoDTO> readObra(GranMaestroDTO maestro, Object type) throws CorvustecException
	{
		logger.info("readObra");
		try{
			return factoryDAO.getObraEspejoDAOImpl().findAll(maestro, type);
		}
		catch(Exception e)
		{
			logger.info("Error readObra {}",e.toString());
			throw new CorvustecException("Error al readObra");
		}
	}

	@Override
	public List<ObraEspejoDTO> readObra(MaestroCiespalDTO maestro, Object type) throws CorvustecException
	{
		logger.info("readObra");
		try{
			return factoryDAO.getObraEspejoDAOImpl().findAll(maestro, type);
		}
		catch(Exception e)
		{
			logger.info("Error readObra {}",e.toString());
			throw new CorvustecException("Error al readObra");
		}
	}

	@Override
	public void deleteObra(ObraEspejoDTO obra) throws CorvustecException
	{
		logger.info("deleteObra");
		try{
			factoryDAO.getObraEspejoDAOImpl().remove(obra);
		}
		catch(Exception e){
			logger.info("Error deleteObra {}",e.toString());
			throw new CorvustecException("Error al deleteObra "+e.toString());
		}		
	}

}
