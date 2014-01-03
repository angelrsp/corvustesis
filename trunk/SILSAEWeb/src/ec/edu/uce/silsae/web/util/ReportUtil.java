package ec.edu.uce.silsae.web.util;

import java.util.Collection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportUtil {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JasperPrint init(String urlJasper,Collection<?> collection) throws JRException
	{
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(collection);
		JasperPrint jasperPrint = JasperFillManager.fillReport(urlJasper, new HashMap(),beanCollectionDataSource);
		return jasperPrint;
	}
	
}
