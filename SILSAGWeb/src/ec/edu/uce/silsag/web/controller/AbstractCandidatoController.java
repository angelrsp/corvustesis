package ec.edu.uce.silsag.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ResultadoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

public class AbstractCandidatoController {

	private static final Logger logger = LoggerFactory.getLogger(AbstractCandidatoController.class);
	
	@EJB
	private CandidatosService candidatosService;

	private static AbstractCandidatoController instance;
	
	UsuarioDTO user;
	CandidatoDTO can;

	public static AbstractCandidatoController getInstance()
	{
		if(instance==null)
			instance=new AbstractCandidatoController();
		return instance;
	}
	
	
	public AbstractCandidatoController() {
		try {
			user=new UsuarioDTO();
			can=new CandidatoDTO();
			user = (UsuarioDTO) JsfUtil.getObject("UsuarioDTO");
			can = user.getBemCandidatos().get(0);
			List<ResultadoDTO> resultadoList=new ArrayList<ResultadoDTO>();
			logger.info(can.getCanCodigo().toString());
			if(can!=null)
			{
				 resultadoList= candidatosService
						.obtenerResutado(can);
				if (resultadoList == null) {
					JsfUtil.redirect("/SILSAGWeb/pages/candidato/encuesta.jsf");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e.toString());
		} catch (SilsagException e) {
			// TODO Auto-generated catch block
			logger.info(e.toString());
		}
	}

}
