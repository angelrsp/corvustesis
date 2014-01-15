package ec.edu.uce.silsag.web.util;

import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportUtil {

	
	public static JasperPrint init(String urlJasper,Map<String, Object> parameters,Collection<?> collection) throws JRException
	{
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(collection);
		JasperPrint jasperPrint = JasperFillManager.fillReport(urlJasper, parameters,beanCollectionDataSource);
		return jasperPrint;
	}
	
}
