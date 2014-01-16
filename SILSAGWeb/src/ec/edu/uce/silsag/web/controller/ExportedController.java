package ec.edu.uce.silsag.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "exportedController")
public class ExportedController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatosService candidatosService;
	
//	private List<CandidatoEstudioDTO> candidatoEstudio;

	private UsuarioDTO user;
	private CandidatoDTO candidato;
	
	public ExportedController() {
//		candidatoEstudio=new ArrayList<CandidatoEstudioDTO>();
		user=new UsuarioDTO();
		candidato=new CandidatoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void exportHojaPDF()
	{
		JasperPrint jasperPrint;
		try {
			FacesContext facesContext= FacesContext.getCurrentInstance();
//			candidatoEstudio=candidatosService.obtenerCandidatoEstudio(candidato);
//			jasperPrint = ReportUtil.init("C:\\_javaee\\SILSAEWeb\\WebContent\\report\\candidato.jasper", new HashMap(),candidatoEstudio);
							
			//jasperPrint = ReportUtil.init("/home/fernando/_javaee/SILSAEWeb/WebContent/report/candidato.jasper", new HashMap(),candidatoEstudio);
			HttpServletResponse httpServletResponse=(HttpServletResponse)facesContext.getExternalContext().getResponse();
		    httpServletResponse.addHeader("Content-disposition", "attachment; filename=curriculum.pdf");
		    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
//		    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
		    facesContext.responseComplete();
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
}
