/**
 * 
 */
package com.corvustec.facee.files.commons.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.exception.ProcessFileException;
import com.corvustec.facee.files.xml.factura.FacturaDTO;
import com.corvustec.facee.files.xml.guiaRemision.GuiaRemisionDTO;
import com.corvustec.facee.files.xml.notaCredito.NotaCreditoDTO;
import com.corvustec.facee.files.xml.notaDebito.NotaDebitoDTO;

/**
 * Clase con los m&eacute;todos para generar los archivos xml de los comprobantes electr&oacute;nicos
 * @author wilmerPC
 *
 */
public final class ComprobantesXmlUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(ComprobantesXmlUtil.class);
	
	public static File generarXmlFactura(FacturaDTO facturaDTO, String pathGenerateFile)
			throws ProcessFileException {
		
		File xmlFactura = null;
		
		try {
			JAXBContext jc = JAXBContext.newInstance(FacturaDTO.class);
			xmlFactura = generarXml(jc, facturaDTO, pathGenerateFile);
		} catch (JAXBException e) {
			logger.info("Error al generarXmlFactura {}", e.toString());
			throw new ProcessFileException(e);
		} catch (Exception e) {
			logger.info("Error al generarXmlFactura {}", e.toString());
			throw new ProcessFileException(e);
		}
		
		return xmlFactura;
	}
	
	public static File generarXmlNotaCredito(NotaCreditoDTO creditoDTO, String pathGenerateFile)
			throws ProcessFileException {
		
		File xmlNotaCredito = null;
		
		try {
			JAXBContext jc = JAXBContext.newInstance(NotaCreditoDTO.class);
			xmlNotaCredito = generarXml(jc, creditoDTO, pathGenerateFile);
		} catch (JAXBException e) {
			logger.info("Error al generarXmlNotaCredito {}", e.toString());
			throw new ProcessFileException(e);
		} catch (Exception e) {
			logger.info("Error al generarXmlNotaCredito {}", e.toString());
			throw new ProcessFileException(e);
		}
		
		return xmlNotaCredito;
		
	}
	
	public static File generarXmlNotaDebito (NotaDebitoDTO debitoDTO, String pathGenerateFile) 
			throws ProcessFileException {
		
		File xmlNotaDebito = null;
		
		try {
			JAXBContext jc = JAXBContext.newInstance(NotaDebitoDTO.class);
			xmlNotaDebito = generarXml(jc, debitoDTO, pathGenerateFile);
		} catch (JAXBException e) {
			logger.info("Error al generarXmlNotaDebito {}", e.toString());
			throw new ProcessFileException(e);
		} catch (Exception e) {
			logger.info("Error al generarXmlNotaDebito {}", e.toString());
			throw new ProcessFileException(e);
		}
		
		return xmlNotaDebito;
		
	}
	
	
	public static File generarXmlGuiaRemision (GuiaRemisionDTO guiaRemisionDTO, String pathGenerateFile) 
			throws ProcessFileException {
		
		File xmlGuiaRemision = null;
		
		try {
			JAXBContext jc = JAXBContext.newInstance(GuiaRemisionDTO.class);
			xmlGuiaRemision = generarXml(jc, guiaRemisionDTO, pathGenerateFile);
		} catch (JAXBException e) {
			logger.info("Error al generarXmlGuiaRemision {}", e.toString());
			throw new ProcessFileException(e);
		} catch (Exception e) {
			logger.info("Error al generarXmlGuiaRemision {}", e.toString());
			throw new ProcessFileException(e);
		}
		
		return xmlGuiaRemision;
		
	}
	
	private static File generarXml (JAXBContext jc, Object object, String pathGenerateFile) throws JAXBException {
		File file = new File(pathGenerateFile);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(object, file);
		return file;
	}
	
}
