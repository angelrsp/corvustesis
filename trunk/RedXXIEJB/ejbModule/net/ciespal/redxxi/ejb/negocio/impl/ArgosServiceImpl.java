package net.ciespal.redxxi.ejb.negocio.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.EntidadArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.OpinionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioPerfilDTO;
import net.ciespal.redxxi.ejb.persistence.vo.DefensorVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;
import com.corvustec.commons.util.EncryptionUtil;

@Stateless
public class ArgosServiceImpl implements ArgosService{

	private static final Logger logger = LoggerFactory.getLogger(ArgosServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	/*Argos*/
	@Override
	public List<ArgosDTO> readArgos(Object pais) throws CorvustecException
	{
		List<ArgosDTO> argosList;
		ArgosDTO argos;
		logger.info("readArgos");
		try{
			argosList=new ArrayList<ArgosDTO>();

			//Observatorios
			argos=new ArgosDTO();
			argos.setTipo(1);
			argos.setDescripcion("Observatorios: ");
			argos.setCount(factoryDAO.getObservatorioDAOImpl().count(pais));
			argosList.add(argos);

			//Veedurias
			argos=new ArgosDTO();
			argos.setTipo(2);
			argos.setDescripcion("Veedurías: ");
			argos.setCount(factoryDAO.getVeeduriaDAOImpl().count(pais));
			argosList.add(argos);			

			//Defensores de Audiencia
			argos=new ArgosDTO();
			argos.setTipo(3);
			argos.setDescripcion("Defensores de Audiencia: ");
			argos.setCount(factoryDAO.getOpinionDAOImpl().count(pais));
			argosList.add(argos);			

		}
		catch(Exception e){
			logger.info("Error readArgos {}",e.toString());
			throw new CorvustecException("Error al readArgos "+e.toString());
		}
		return argosList;
	}

	
	@Override
	public Integer countArgos() throws CorvustecException
	{
		logger.info("countArgos");
		Integer count;
		try{
			count=factoryDAO.getObservatorioDAOImpl().count(null)+factoryDAO.getVeeduriaDAOImpl().count(null)+factoryDAO.getOpinionDAOImpl().count(null);			
		}
		catch(Exception e){
			logger.info("Error countArgos {}",e.toString());
			throw new CorvustecException("Error al countArgos "+e.toString());
		}
		return count;
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
		//Observatorios
		else if(type.equals(1))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getObservatorioDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//Veedurias
		else if(type.equals(2))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getVeeduriaDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}			
		}//Defensores
		else if(type.equals(3))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getOpinionDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}			
		}
		return paisList;
	}
	
	@Override
	public List<ArgosVisorDTO> visorList(ArgosDTO argos) throws CorvustecException
	{
		List<ArgosVisorDTO> argosVisorList=new ArrayList<ArgosVisorDTO>();
		ArgosVisorDTO argosVisor;

		
		if(argos.getTipo()==0)
		{
		}
		//Observatorio
		else if(argos.getTipo()==1)
		{
			ObservatorioDTO obs=new ObservatorioDTO();
			obs.setObsPais(argos.getPais());
			List<ObservatorioDTO> listObservatorio=new ArrayList<ObservatorioDTO>();
			
			listObservatorio=factoryDAO.getObservatorioDAOImpl().getByAnd(obs);
			
			for(ObservatorioDTO objeto:listObservatorio){
					
				argosVisor=new ArgosVisorDTO();
				argosVisor.setCodigo(objeto.getObsCodigo());
				
				argosVisor.setTitulo("Observatorio: " +objeto.getObsNombre());
				argosVisor.setDescripcion1("Datos Institucionales :"+objeto.getObsDatosInstitucionales());
				argosVisor.setTipo(argos.getTipo());

				argosVisorList.add(argosVisor);
				
			}
			
		}//Veeduria
		else if(argos.getTipo()==2)
		{
			VeeduriaDTO vee=new VeeduriaDTO();
			vee.setVeePais(argos.getPais());
			List<VeeduriaDTO> list=new ArrayList<VeeduriaDTO>();
			
			list=factoryDAO.getVeeduriaDAOImpl().getByAnd(vee);
			
			for(VeeduriaDTO objeto:list){
					
				argosVisor=new ArgosVisorDTO();
				argosVisor.setCodigo(objeto.getVeeCodigo());
				
				argosVisor.setTitulo("Veeduria: " +objeto.getVeeNombre());
				argosVisor.setDescripcion1("Datos Institucionales :"+objeto.getVeeDatoInstitucional());
				argosVisor.setTipo(argos.getTipo());

				argosVisorList.add(argosVisor);
				
			}			
		}//Defensores de Audiencia
		else if(argos.getTipo()==3)
		{
			DefensorVieDTO def=new DefensorVieDTO();
			def.setOpiPais(argos.getPais());
			List<DefensorVieDTO> list=new ArrayList<DefensorVieDTO>();
			
			list=factoryDAO.getDefensorVieDAOImpl().getByAnd(def);
			
			for(DefensorVieDTO objeto:list){
					
				argosVisor=new ArgosVisorDTO();
				argosVisor.setCodigo(objeto.getOpiCodigo());
				
				argosVisor.setTitulo("Nombres y Apellidos: " +objeto.getUsuNombres()+" "+objeto.getUsuApellidos());
				if(objeto.getOpiFechaReferencia().toString().length()>10)
					argosVisor.setDescripcion1("Fecha :"+objeto.getOpiFechaReferencia().toString().substring(0, 10));
				argosVisor.setDescripcion2("Medio de Comunicación :"+objeto.getOpiMedio());
				argosVisor.setDescripcion3("Tema de referencia :"+objeto.getOpiTemaReferencia());
				argosVisor.setTipo(argos.getTipo());

				argosVisorList.add(argosVisor);
			}			
		}
		return argosVisorList;
	}

	@Override
	public String argosItem(ArgosVisorDTO argos) throws CorvustecException
	{
		StringBuilder sb;
		try{
			sb=new StringBuilder();
			sb.append("<table>");
			
			if(argos.getTipo()==1)
			{
				ObservatorioVieDTO obs=new ObservatorioVieDTO();
				obs.setObsCodigo(argos.getCodigo());
				obs= factoryDAO.getObservatorioVieDAOImpl().getByAnd(obs).get(0);
				
				sb.append("<tr>");
					sb.append("<td>");sb.append("Pais: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getCatPais());sb.append("</td>");
				sb.append("</tr>");
				
				sb.append("<tr>");
					sb.append("<td>");sb.append("Estado/Provincia: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getCatProvincia());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Ciudad: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getCatCiudad());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Nombre del Observatorio: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getObsNombre());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Organización(es) patrocinadora(s): ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getObsInstitucionPatrocinadora());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Año de Fundación: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getObsAnioFundacion());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Misión: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getObsMision());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Líneas Temáticas: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getObsLineaTematica());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Actividades Principales: ");sb.append("</td>");
					sb.append("<td>");sb.append(obs.getObsActividadesPrincipales());sb.append("</td>");
				sb.append("</tr>");
				
				ObservatorioDTO o=factoryDAO.getObservatorioDAOImpl().find(obs.getObsCodigo());
				List<ContactoArgosListDTO> listContacto=factoryDAO.getContactoArgosDAOImpl().getAll(o.getArgEntidad());
				
				if(listContacto!=null)
				{
					sb.append("<tr>");
						sb.append("<td colspan='2'>");sb.append("Contactos: ");sb.append("</td>");
					sb.append("</tr>");
					for(ContactoArgosListDTO con:listContacto)
					{
						sb.append("<tr>");
							sb.append("<td>");sb.append(con.getCatTipo());sb.append("</td>");
							sb.append("<td>");sb.append(con.getConDescripcion());sb.append("</td>");
						sb.append("</tr>");						
					}
				}
			}
			else if(argos.getTipo()==2)
			{
				VeeduriaVieDTO vee=new VeeduriaVieDTO();
				vee.setVeeCodigo(argos.getCodigo());
				vee= factoryDAO.getVeeduriaVieDAOImpl().getByAnd(vee).get(0);
				
				sb.append("<tr>");
					sb.append("<td>");sb.append("Pais: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getCatPais());sb.append("</td>");
				sb.append("</tr>");
				
				sb.append("<tr>");
					sb.append("<td>");sb.append("Estado/Provincia: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getCatProvincia());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Ciudad: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getCatCiudad());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Nombre de la Veeduría: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getVeeNombre());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Organización(es) patrocinadora(s): ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getVeeInstitucionPatrocinadora());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Año de Fundación: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getVeeAnioFundacion());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Misión: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getVeeMision());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Líneas Temáticas: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getVeeLineaTematica());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Actividades Principales: ");sb.append("</td>");
					sb.append("<td>");sb.append(vee.getVeeActividadPrinciapl());sb.append("</td>");
				sb.append("</tr>");
				
				VeeduriaDTO v=factoryDAO.getVeeduriaDAOImpl().find(vee.getVeeCodigo());
				List<ContactoArgosListDTO> listContacto=factoryDAO.getContactoArgosDAOImpl().getAll(v.getArgEntidad());
				
				if(listContacto!=null)
				{
					sb.append("<tr>");
						sb.append("<td colspan='2'>");sb.append("Contactos: ");sb.append("</td>");
					sb.append("</tr>");
					for(ContactoArgosListDTO con:listContacto)
					{
						sb.append("<tr>");
							sb.append("<td>");sb.append(con.getCatTipo());sb.append("</td>");
							sb.append("<td>");sb.append(con.getConDescripcion());sb.append("</td>");
						sb.append("</tr>");						
					}
				}				
			}
			else if(argos.getTipo()==3)
			{
				DefensorVieDTO def=new DefensorVieDTO();
				def.setOpiCodigo(argos.getCodigo());
				def= factoryDAO.getDefensorVieDAOImpl().getByAnd(def).get(0);
				
				sb.append("<tr>");
					sb.append("<td>");sb.append("Pais: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getCatPais());sb.append("</td>");
				sb.append("</tr>");
				
				sb.append("<tr>");
					sb.append("<td>");sb.append("Estado/Provincia: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getCatProvincia());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Ciudad: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getCatCiudad());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Nombres: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getUsuNombres());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Apellidos: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getUsuApellidos());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Medio de Comunicación: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getOpiMedio());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Tema de Referencia: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getOpiTemaReferencia());sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
					sb.append("<td>");sb.append("Opinión: ");sb.append("</td>");
					sb.append("<td>");sb.append(def.getOpiComentario());sb.append("</td>");
				sb.append("</tr>");

			}
			sb.append("</table>");
		}
		catch(Exception e){
			logger.info("Error argosResult {}",e.toString());
			throw new CorvustecException("Error argosResult "+e.toString());
		}
		return sb.toString();
	}
		
	/*Red*/
	@Override
	public RedDTO createOrUpdateRed(RedDTO red) throws CorvustecException
	{
		logger.info("createOrUpdateRed");
		try{
			if(red.getRedCodigo()!=null)
				return factoryDAO.getRedDAOImpl().edit(red);
			else			
				return factoryDAO.getRedDAOImpl().create(red);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateRed {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateRed");
		}
	}
	
	@Override
	public List<RedDTO> readRed() throws CorvustecException
	{
		logger.info("readRed");
		try{
			return factoryDAO.getRedDAOImpl().getAll();
		}
		catch(Exception e)
		{
			logger.info("Error readRed {}",e.toString());
			throw new CorvustecException("Error al readRed");
		}
	}

	/*Observatorio*/
	@Override
	public ObservatorioDTO createOrUpdateObservatorio(ObservatorioDTO observatorio) throws CorvustecException
	{
		logger.info("createOrUpdateObservatorio");
		try{
			if(observatorio.getObsCodigo()!=null)
				return factoryDAO.getObservatorioDAOImpl().edit(observatorio);
			else			
			{
				observatorio.setArgEntidad(new EntidadArgosDTO());
				return factoryDAO.getObservatorioDAOImpl().create(observatorio);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateObservatorio {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateObservatorio");
		}
	}
	
	@Override
	public List<ObservatorioDTO> readObservatorio(Object ciudad) throws CorvustecException
	{
		logger.info("readObservatorio");
		try{
			return factoryDAO.getObservatorioDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readObservatorio {}",e.toString());
			throw new CorvustecException("Error al readObservatorio");
		}
	}
	
	@Override
	public void deleteObservatorio(ObservatorioDTO observatorio) throws CorvustecException
	{
		logger.info("deleteObservatorio");
		try{
			List<ContactoArgosListDTO> contactoList=factoryDAO.getContactoArgosDAOImpl().getAll(observatorio.getArgEntidad());
			if(contactoList!=null)
			{
				for(ContactoArgosListDTO con:contactoList)
					factoryDAO.getContactoArgosDAOImpl().remove(factoryDAO.getContactoArgosDAOImpl().find(con.getConCodigo()));		
			}
			factoryDAO.getObservatorioDAOImpl().remove(observatorio);
		}
		catch(Exception e)
		{
			logger.info("Error readObservatorio {}",e.toString());
			throw new CorvustecException("Error al readObservatorio");
		}
		
	}
	
	
	/*Veeduria*/
	@Override
	public VeeduriaDTO createOrUpdateVeeduria(VeeduriaDTO veeduria) throws CorvustecException
	{
		logger.info("createOrUpdateVeeduria");
		try{
			if(veeduria.getVeeCodigo()!=null)
				return factoryDAO.getVeeduriaDAOImpl().edit(veeduria);
			else			
			{
				veeduria.setArgEntidad(new EntidadArgosDTO());
				return factoryDAO.getVeeduriaDAOImpl().create(veeduria);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateVeeduria {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateVeeduria");
		}
	}
	
	@Override
	public List<VeeduriaDTO> readVeeduria(Object ciudad) throws CorvustecException
	{
		logger.info("readVeeduria");
		try{
			return factoryDAO.getVeeduriaDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readObservatorio {}",e.toString());
			throw new CorvustecException("Error al readObservatorio");
		}
	}

	
	@Override
	public void deleteVeeduria(VeeduriaDTO veeduria) throws CorvustecException
	{
		logger.info("deleteVeeduria");
		try{
			List<ContactoArgosListDTO> contactoList=factoryDAO.getContactoArgosDAOImpl().getAll(veeduria.getArgEntidad());
			if(contactoList!=null)
			{
				for(ContactoArgosListDTO con:contactoList)
					factoryDAO.getContactoArgosDAOImpl().remove(factoryDAO.getContactoArgosDAOImpl().find(con.getConCodigo()));		
			}
			factoryDAO.getVeeduriaDAOImpl().remove(veeduria);
		}
		catch(Exception e)
		{
			logger.info("Error readObservatorio {}",e.toString());
			throw new CorvustecException("Error al readObservatorio");
		}
		
	}

	
	/*Contacto*/
	@Override
	public ContactoArgosDTO createOrUpdateContacto(ContactoArgosDTO contacto) throws CorvustecException
	{
		logger.info("createOrUpdateContacto");
		try{
			if(contacto.getConCodigo()!=null)
				return factoryDAO.getContactoArgosDAOImpl().edit(contacto);
			else			
				return factoryDAO.getContactoArgosDAOImpl().create(contacto);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateContacto {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateContacto");
		}
	}
	
	@Override
	public List<ContactoArgosListDTO> readContacto(EntidadArgosDTO entidad) throws CorvustecException
	{
		logger.info("createOrUpdateContacto");
		try{
			return factoryDAO.getContactoArgosDAOImpl().getAll(entidad);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateContacto {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateContacto");
		}		
	}
	
	@Override
	public ContactoArgosDTO readContacto(Object id) throws CorvustecException
	{
		logger.info("createOrUpdateContacto");
		try{
			return factoryDAO.getContactoArgosDAOImpl().find(id);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateContacto {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateContacto");
		}		
		
	}
	
	@Override
	public void deleteContacto(ContactoArgosListDTO contactoList) throws CorvustecException
	{
		logger.info("createOrUpdateContacto");
		try{
			 factoryDAO.getContactoArgosDAOImpl().remove(factoryDAO.getContactoArgosDAOImpl().find(contactoList.getConCodigo()));
		}
		catch(Exception e){
			logger.info("Error createOrUpdateContacto {}",e.toString());
			throw new CorvustecException("Error al deleteContacto");
		}				
	}
	
	@Override
	public UsuarioDTO defensorCreateOrUpdate(DefensorVO defensor) throws CorvustecException
	{
		logger.info("defensorCreateOrUpdate");
		UsuarioDTO login;
		UsuarioPerfilDTO usrPerfil;
		PerfilDTO perfil;
		try{
			login=new UsuarioDTO();
			perfil=new PerfilDTO();
			//Perfil de Defensor
			perfil.setPerCodigo(-1);
			usrPerfil=new UsuarioPerfilDTO();
			usrPerfil.setSegUsuario(defensor.getUser());
			usrPerfil.setSegPerfil(perfil);
			login.setUsuLogin(defensor.getUser().getUsuLogin());
			if(factoryDAO.getUsuarioDAOImpl().getByAnd(login).size()>0)
				throw new CorvustecException("El correo electrónico ya esta registrado");
			defensor.getUser().setUsuClave(EncryptionUtil.getInstancia().encriptar(defensor.getUser().getUsuClave()));
			UsuarioDTO usr=factoryDAO.getUsuarioDAOImpl().create(defensor.getUser());
			defensor.getDefensor().setDefUsuario(usr.getUsuCodigo());
			factoryDAO.getDefensorDAOImpl().create(defensor.getDefensor());
			factoryDAO.getUsuarioPerfilDAOImpl().create(usrPerfil);
			return usr;
		}
		catch(Exception e){
			logger.info("Error {}",e.toString());
			throw new CorvustecException("Error "+e.toString());
		}				
	}
	
	
	@Override
	public List<DefensorDTO> defensorRead(DefensorDTO defensor) throws CorvustecException
	{
		try{
			return factoryDAO.getDefensorDAOImpl().getByAnd(defensor);
		}catch(Exception e){
			logger.info("Error {}",e.toString());
			throw new CorvustecException("Error "+e.toString());
		}				

	}
	
	/*Opinion*/
	@Override
	public OpinionDTO opinionCreateOrUpdate(OpinionDTO opinionDTO) throws CorvustecException
	{
		logger.info("opinionCreateOrUpdate");
		try{
			opinionDTO.setOpiFecha(new Timestamp(new Date().getTime()));
			if(opinionDTO.getOpiCodigo()!=null)
				return factoryDAO.getOpinionDAOImpl().edit(opinionDTO);
			else
				return factoryDAO.getOpinionDAOImpl().create(opinionDTO);
		}
		catch(Exception e){
			logger.info("Error {}",e.toString());
			throw new CorvustecException("Error "+e.toString());
		}				
	}
	
}
