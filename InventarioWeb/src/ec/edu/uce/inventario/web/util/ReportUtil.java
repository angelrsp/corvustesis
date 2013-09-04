package ec.edu.uce.inventario.web.util;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class ReportUtil {

	public static void generarReporte(JasperPrint jp, String nombreReporte) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		OutputStream outputStream = null;

		try {
			JRExporter jRExporter = null;
			HttpServletResponse httpServletResponse = (HttpServletResponse) facesContext
					.getExternalContext().getResponse();
			httpServletResponse.setContentType("application/vnd.ms-excel");
			outputStream = httpServletResponse.getOutputStream();

			jRExporter = new JRXlsExporter();
			jRExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
			jRExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outputStream);
			jRExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
			jRExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
			jRExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
			jRExporter.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER,Boolean.FALSE);
			jRExporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED,Boolean.TRUE);
			jRExporter.setParameter(JRXlsExporterParameter.IS_IMAGE_BORDER_FIX_ENABLED,Boolean.FALSE);
			jRExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			jRExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			httpServletResponse.setHeader("Content-disposition","attachment; filename="+ nombreReporte);

			if (jRExporter != null) {
				jRExporter.exportReport();
			}

		
			facesContext.responseComplete();

		} catch (Exception e) {

		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JasperPrint jasperPrint(FacesContext facesContext,List listaObjeto, String nombreArchivo) {

		JasperPrint jp = null;
		try {
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
					listaObjeto);
			String reportePath = facesContext.getExternalContext().getRealPath("/jasper/" + nombreArchivo + ".jrxml");
			JasperReport jr = JasperCompileManager.compileReport(reportePath);
			jp = JasperFillManager.fillReport(jr, new HashMap(),beanCollectionDataSource);
			// String pdfPath =
			// facesContext.getExternalContext().getRealPath("/jasper/reportes/"+nombreArchivo+".pdf");
			// JasperExportManager.exportReportToPdfFile(jp, pdfPath);
		} catch (Exception e) {

		}
		return jp;
	}

}
