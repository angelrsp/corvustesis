package ec.edu.uce.silsae.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.CandidatosService;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsae.web.util.JsfUtil;
import ec.edu.uce.silsae.web.util.ReportUtil;

@ViewScoped
@ManagedBean(name = "exportedController")
public class ExportedController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatosService candidatosService;
	
	private List<CandidatoDatoDTO> candidatoDato;

	private UsuarioDTO user;
	private CandidatoDTO candidato;
	
	public ExportedController() {
		candidatoDato=new ArrayList<CandidatoDatoDTO>();
		user=new UsuarioDTO();
		candidato=new CandidatoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
	}
	
	public void exportHojaPDF()
	{
		JasperPrint jasperPrint;
		try {
			FacesContext facesContext= FacesContext.getCurrentInstance();
			candidatoDato=candidatosService.obtenerCandidatoDato(candidato);
			jasperPrint = ReportUtil.init("C:\\_javaee\\SILSAEWeb\\WebContent\\report\\candidato.jasper", candidatoDato);
			HttpServletResponse httpServletResponse=(HttpServletResponse)facesContext.getExternalContext().getResponse();
		    httpServletResponse.addHeader("Content-disposition", "attachment; filename=curriculum.pdf");
		    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
		    facesContext.responseComplete();
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		} catch (JRException e) {
			JsfUtil.addErrorMessage(e.getMessage());		
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
}
