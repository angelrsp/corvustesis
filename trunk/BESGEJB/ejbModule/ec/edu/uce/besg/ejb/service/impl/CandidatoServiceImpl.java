package ec.edu.uce.besg.ejb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.EncryptionUtility;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.HabilidadDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.HistorialPasswordDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.HabilidadViewDTO;
import ec.edu.uce.besg.ejb.service.CandidatoService;
import ec.edu.uce.besg.ejb.vo.CandidatoVO;

@Stateless
public class CandidatoServiceImpl implements CandidatoService {
	

	private static final Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	
	@Override
	public CandidatoDTO registrarCandidato(CandidatoVO candidatoVO)throws CorvustecException {
		UsuarioDTO usuarioDTO;
		HistorialPasswordDTO historialPasswordDTO;
		try{
			if(candidatoVO.getCandidatoDTO().getCanCodigo()!=null)
				return factoryDAO.getCandidatoDAOImpl().update(candidatoVO.getCandidatoDTO());
			else
			{
				historialPasswordDTO=new HistorialPasswordDTO();
				candidatoVO.getUsuarioDTO().setUsuPassword(EncryptionUtility.getInstance().encriptar(candidatoVO.getUsuarioDTO().getUsuPassword()));
				candidatoVO.getUsuarioDTO().setUsuMail(candidatoVO.getUsuarioDTO().getUsuLogin());
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().create(candidatoVO.getUsuarioDTO());
				
				historialPasswordDTO.setSegUsuario(usuarioDTO);
				historialPasswordDTO.setHpaFecha(new Timestamp(new Date().getTime()));
				historialPasswordDTO.setHpaPassword(EncryptionUtility.getInstance().encriptar(candidatoVO.getUsuarioDTO().getUsuPassword()));
				
				factoryDAO.getHistorialPasswordDAOImpl().create(historialPasswordDTO);
				
				candidatoVO.getCandidatoDTO().setSegUsuario(usuarioDTO);
				candidatoVO.getUsuarioDTO().setUsuMail(candidatoVO.getUsuarioDTO().getUsuLogin());
				
				return factoryDAO.getCandidatoDAOImpl().create(candidatoVO.getCandidatoDTO());
			}
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			usuarioDTO=null;
			historialPasswordDTO=null;
		}
	}
	
	@Override
	public CandidatoDTO updateCandidato(CandidatoDTO candidatoDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getCandidatoDAOImpl().update(candidatoDTO);	
		} catch (Exception e) {
			logger.info("Error al updateCandidato {}", e.toString());
			throw new CorvustecException("Error al updateCandidato");
		}
		finally{
			candidatoDTO=null;
		}		
	}

	@Override
	public CandidatoDTO readCandidato(CandidatoDTO candidatoDTO) throws CorvustecException
	{
		List<CandidatoDTO> candidatoList;
		try {
			candidatoList= factoryDAO.getCandidatoDAOImpl().getByAnd(candidatoDTO);
			if(candidatoList.isEmpty())
				return new CandidatoDTO();
			else
				return candidatoList.get(0);	
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			candidatoList=null;
			candidatoDTO=null;
		}		
	}
	
	@Override
	public HabilidadDTO createOrUpdateHabilidad(HabilidadDTO habilidadDTO) throws CorvustecException
	{
		try {
			if(habilidadDTO.getHabCodigo()!=null)
				return factoryDAO.getHabilidadDAOImpl().update(habilidadDTO);
			else
				return factoryDAO.getHabilidadDAOImpl().create(habilidadDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			habilidadDTO=null;
		}			
	}

	@Override
	public void removeHabilidad(HabilidadDTO habilidadDTO) throws CorvustecException
	{
		try {
			factoryDAO.getHabilidadDAOImpl().remove(habilidadDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			habilidadDTO=null;
		}			
	}

	
	@Override
	public List<HabilidadViewDTO> readHabilidadView(HabilidadViewDTO habilidadViewDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getHabilidadViewDAOImpl().getByAnd(habilidadViewDTO);
		} catch (Exception e) {
			logger.info("Error al registrar Candidato {}", e.toString());
			throw new CorvustecException("Error al registrar Candidato");
		}
		finally{
			habilidadViewDTO=null;
		}
			
	}
	
}
