/**
 * 
 */
package com.corvustec.facee.files.dto.util.impl;

import static com.corvustec.facee.files.commons.util.Constantes.AMBIENTE;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_DETALLE;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_IMPUESTOS;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_FACTURA;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_TRIBUTARIA;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_RETENCIONES;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_TOTAL_IMPUESTOS;
import static com.corvustec.facee.files.commons.util.Constantes.MONEDA;
import static com.corvustec.facee.files.commons.util.Constantes.TIPO_EMISION_NORMAL;
import static com.corvustec.facee.files.commons.util.Constantes.URL_PLANTILLA_FACTURA;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_ID;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_VERSION;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_DETALLE;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_IMPUESTOS;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_FACTURA;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_TRIBUTARIA;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_RETENCIONES;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_TOTAL_IMPUESTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.exception.ProcessFileException;
import com.corvustec.facee.files.commons.util.ComprobantesXmlUtil;
import com.corvustec.facee.files.commons.util.Constantes;
import com.corvustec.facee.files.commons.util.UtilApplication;
import com.corvustec.facee.files.commons.util.UtilMail;
import com.corvustec.facee.files.commons.util.UtilXML;
import com.corvustec.facee.files.webService.ComprobantesElectronicosWs;
import com.corvustec.facee.files.xml.commons.ImpuestoDTO;
import com.corvustec.facee.files.xml.commons.InfoTributariaDTO;
import com.corvustec.facee.files.xml.commons.TotalConImpuestosDTO;
import com.corvustec.facee.files.xml.factura.DetalleFacturaDTO;
import com.corvustec.facee.files.xml.factura.DetallesDTO;
import com.corvustec.facee.files.xml.factura.FacturaDTO;
import com.corvustec.facee.files.xml.factura.InfoFacturaDTO;
import com.corvustec.facee.files.xml.factura.RetencionDTO;
import com.corvustec.facee.files.xml.factura.RetencionesDTO;

import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

/**
 * @author wilmerPC
 *
 */
public class ArchivoFactura extends Archivo {
	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoFactura.class);
	
	public ArchivoFactura(Map<String, String> estructuraArchivos) {
		super(estructuraArchivos);
	}

	@Override
	public void procesarArchivo(File file) {
		logger.info("se va ha procesar el archivo {} ", file.getName());
		try {
			procesarFactura(file);
		} catch (ProcessFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private File generarXmlFromFile (File file) throws ProcessFileException, IOException {
		
		List<String> lineasArchivo = UtilApplication.leerArchivo(file);
		
		if (CollectionUtils.isNotEmpty(lineasArchivo)) {
			
			FacturaDTO facturaDTO = new FacturaDTO();
			InfoTributariaDTO infoTributariaDTO = null;
			InfoFacturaDTO infoFacturaDTO = null;
			List<ImpuestoDTO> totalConImpuestos = new ArrayList<ImpuestoDTO>();
			List<DetalleFacturaDTO> detalles = new ArrayList<DetalleFacturaDTO>();
			List<RetencionDTO> retenciones = new ArrayList<RetencionDTO>();
			
			for (String linea : lineasArchivo) {
				
				if (linea.startsWith(IDENTIFICADOR_INFO_TRIBUTARIA)) {
					
					infoTributariaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_FACTURA,
									XPATH_INFO_TRIBUTARIA,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoTributariaDTO());
					
					infoTributariaDTO.setAmbiente(AMBIENTE);
					infoTributariaDTO.setTipoEmision(TIPO_EMISION_NORMAL);
					
				} else if (linea.startsWith(IDENTIFICADOR_INFO_FACTURA)) {
					
					infoFacturaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_FACTURA,
									XPATH_INFO_FACTURA,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoFacturaDTO());
					infoFacturaDTO.setMoneda(MONEDA);
					infoFacturaDTO.getFechaEmision();
					
				} else if (linea.startsWith(IDENTIFICADOR_TOTAL_IMPUESTOS)) {
					
					ImpuestoDTO impuestoDTO = UtilXML.getInstancia()
							.construirObject(
									URL_PLANTILLA_FACTURA,
									XPATH_TOTAL_IMPUESTO,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new ImpuestoDTO());
					totalConImpuestos.add(impuestoDTO);
					
				} else if (linea.startsWith(IDENTIFICADOR_DETALLE)) {
					
					DetalleFacturaDTO detalleFacturaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_FACTURA,
									XPATH_DETALLE,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new DetalleFacturaDTO());
					
					detalles.add(detalleFacturaDTO);
					
				} else if (linea.startsWith(IDENTIFICADOR_IMPUESTOS)) {
					ImpuestoDTO impuestoDTO = UtilXML.getInstancia()
							.construirObject(
									URL_PLANTILLA_FACTURA,
									XPATH_IMPUESTOS,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new ImpuestoDTO());
					
					if (detalles.get(detalles.size()-1).getImpuestos().getImpuesto()==null) {
						detalles.get(detalles.size()-1).getImpuestos().setImpuesto((new ArrayList<ImpuestoDTO>()));
					}
					detalles.get(detalles.size()-1).getImpuestos().getImpuesto().add(impuestoDTO);
					
				} else if (linea.startsWith(IDENTIFICADOR_RETENCIONES)) {
					
					RetencionDTO retencionDTO = UtilXML.getInstancia()
							.construirObject(
									URL_PLANTILLA_FACTURA,
									XPATH_RETENCIONES,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new RetencionDTO());
					retenciones.add(retencionDTO);
				}
				
			}
			
			infoTributariaDTO
					.setClaveAcceso(UtilApplication.getClaveAcceso(
							infoFacturaDTO.getFechaEmisionDate(),
							infoTributariaDTO.getCodDoc(),
							infoTributariaDTO.getRuc(),
							infoTributariaDTO.getAmbiente(),
							infoTributariaDTO.getSecuencial(), UtilApplication.getCodigoNumerico(),
							infoTributariaDTO.getTipoEmision(),
							infoTributariaDTO.getEstab(),
							infoTributariaDTO.getPtoEmi()));
			
			facturaDTO.setInfoTributaria(infoTributariaDTO);
			
			if (CollectionUtils.isNotEmpty(totalConImpuestos) && totalConImpuestos.size()>0) {
				TotalConImpuestosDTO totalConImpuestosDTO = new TotalConImpuestosDTO();
				totalConImpuestosDTO.setTotalImpuesto(totalConImpuestos);
				infoFacturaDTO.setTotalConImpuestos(totalConImpuestosDTO);
			}
			
			if (CollectionUtils.isNotEmpty(detalles) && detalles.size()>0) {
				DetallesDTO detallesFactura = new DetallesDTO();
				detallesFactura.setDetalle(detalles);
				facturaDTO.setDetalles(detallesFactura);
			}
			
			if (CollectionUtils.isNotEmpty(retenciones) && retenciones.size()>0) {
				RetencionesDTO retencionesDto = new RetencionesDTO();
				retencionesDto.setRetencion(retenciones);
				facturaDTO.setRetenciones(retencionesDto);
			}
			
			
			facturaDTO.setInfoFactura(infoFacturaDTO);
			facturaDTO.setId(XML_ATRIBUTO_ID);
			facturaDTO.setVersion(XML_ATRIBUTO_VERSION);
			
			return ComprobantesXmlUtil.generarXmlFactura(
					facturaDTO,UtilApplication.appendStringBuilder(getEstructuraArchivos().get(Constantes.carpertaXml),File.separator, infoTributariaDTO.getClaveAcceso(), ".xml").toString());
		}
		
		return null;
	}
	
	private void procesarFactura(File file) throws ProcessFileException, IOException {
		
		try {
			
			File xmlFile = generarXmlFromFile(file);
			
//			if (Signature.Xml(xmlFile, "Z://firma//Sifuturo//juan_carlos_araujo_donoso.p12","Kt9oLrPpHaCt/KH6+jB0Jw==")){
				
				Object a = ComprobantesElectronicosWs.verificarConectividad(Constantes.AMBIENTE, ComprobantesElectronicosWs.SERVICIO_RECEPCION);
				
				if (a == null) {
					logger.info("No se puede conectar al servicio del SRI implementar envio contingencia");
				} else {
					
					RespuestaSolicitud response = ComprobantesElectronicosWs.enviarComprobante(xmlFile);
					//logger.info("response.getEstado(): {}", response.getEstado());
					logger.info("Respuesta WS: {}", response.getEstado());
					
					if (response.getEstado().equals(ComprobantesElectronicosWs.RESPUESTA_RECIBIDA)) {
						
						
						
						UtilMail.enviar(xmlFile);
						UtilApplication.moverArchivoProcesado(file, getEstructuraArchivos().get(Constantes.carpetaProcesados));
						//Agregado por FPU
						
					} else {
						String mensaje = ComprobantesElectronicosWs.getMensajeRespuestaEnvio(response);
						
						logger.info("mensaje: {}", mensaje);
					}
				}
				
//			} else {
//				logger.info("No se pudo firmar el archivo {} ", file.getCanonicalPath());
//			}
		} catch (ProcessFileException e) {
			logger.info("No se pudo firmar el archivo {}, {} ", file.getCanonicalPath(), e.toString());
		}
	} 
	
}
	
