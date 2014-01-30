package ec.edu.uce.silsag.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;
import ec.edu.uce.silsag.web.util.ReportUtil;

@ViewScoped
@ManagedBean(name = "exportedController")
public class ExportedController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatosService candidatosService;
	
	private List<CandidatoListDTO> candidatoList;
	
	private CandidatoListDTO candidatoListDTO;

	private UsuarioDTO user;
	private CandidatoDTO candidato;
	
	public ExportedController() {
		user=new UsuarioDTO();
		candidato=new CandidatoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
		candidatoList=new ArrayList<CandidatoListDTO>();
		candidatoListDTO=new CandidatoListDTO();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void exportHojaPDF()
	{
		JasperPrint jasperPrint;
		try {
			FacesContext facesContext= FacesContext.getCurrentInstance();
			
			candidatoListDTO=candidatosService.obtenerCandidato(candidato);
			
			candidatoListDTO.setCanEstudios(candidatosService.obtenerEstudio(candidato));
			candidatoListDTO.setCanExperiencia(candidatosService.obtenerExperiencia(candidato));
			candidatoListDTO.setCanCurso(candidatosService.obtenerCurso(candidato));
			candidatoListDTO.setCanAdicional(candidatosService.obtenerAdicional(candidato));
			candidatoListDTO.setCanReferencia(candidatosService.obtenerReferencia(candidato));
			
			if(candidato.getCanFoto()!=null)
			{
				InputStream myInputStream = new ByteArrayInputStream(candidato.getCanFoto());
				candidatoListDTO.setCanFotoStream(myInputStream);
			}
			
			candidatoList.add(candidatoListDTO);
//			candidatoEstudio=candidatosService.obtenerCandidatoEstudio(candidato);
			jasperPrint = ReportUtil.init("C:\\_javaee\\SILSAGWeb\\web\\report\\candidato.jasper", new HashMap(),candidatoList);
							
			//jasperPrint = ReportUtil.init("/home/fernando/_javaee/SILSAEWeb/WebContent/report/candidato.jasper", new HashMap(),candidatoEstudio);
			HttpServletResponse httpServletResponse=(HttpServletResponse)facesContext.getExternalContext().getResponse();
		    httpServletResponse.addHeader("Content-disposition", "attachment; filename=curriculum.pdf");
		    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
		    facesContext.responseComplete();
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		} catch (JRException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
}
