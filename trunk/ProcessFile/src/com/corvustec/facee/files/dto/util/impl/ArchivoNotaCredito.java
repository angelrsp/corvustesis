/**
 * 
 */
package com.corvustec.facee.files.dto.util.impl;

import static com.corvustec.facee.files.commons.util.Constantes.AMBIENTE;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_DETALLE_NC;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_IMPUESTOS_NC;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_NOTACREDITO;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_TRIBUTARIA_NC;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_TOTAL_IMPUESTOS_NC;
import static com.corvustec.facee.files.commons.util.Constantes.MONEDA;
import static com.corvustec.facee.files.commons.util.Constantes.TIPO_EMISION_NORMAL;
import static com.corvustec.facee.files.commons.util.Constantes.URL_PLANTILLA_NOTACREDITO;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_ID;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_VERSION;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_DETALLE_NC;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_IMPUESTOS_NC;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_NOTACREDITO;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_TRIBUTARIA_NC;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_TOTAL_IMPUESTO_NC;

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
import com.corvustec.facee.files.commons.util.UtilXML;
import com.corvustec.facee.files.xml.commons.ImpuestoDTO;
import com.corvustec.facee.files.xml.commons.InfoTributariaDTO;
import com.corvustec.facee.files.xml.commons.TotalConImpuestosDTO;
import com.corvustec.facee.files.xml.notaCredito.DetalleNotaCreditoDTO;
import com.corvustec.facee.files.xml.notaCredito.DetallesNotaDTO;
import com.corvustec.facee.files.xml.notaCredito.InfoNotaCreditoDTO;
import com.corvustec.facee.files.xml.notaCredito.NotaCreditoDTO;

/**
 * @author wilmerPC
 * 
 *
 */
public class ArchivoNotaCredito extends Archivo{
	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoNotaCredito.class);
	
//	public ArchivoNotaCredito(String urlCarpetaProcesados){
//		super(urlCarpetaProcesados);
//	}
	
	public ArchivoNotaCredito (Map<String, String> estructuraArchivos) {
		super(estructuraArchivos);
	}

	@Override
	public void procesarArchivo(File file) {
		logger.info("se va ha procesar el archivo {} ArchivoNotaCredito", file.getName());
		try {
			procesarNotaCredito(file);
		} catch (ProcessFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void procesarNotaCredito(File file) throws ProcessFileException, IOException{
		List<String> lineasArchivo = UtilApplication.leerArchivo(file);
		
		if (CollectionUtils.isNotEmpty(lineasArchivo)) {
			
			NotaCreditoDTO notaCreditoDTO = new NotaCreditoDTO();
			InfoTributariaDTO infoTributariaDTO = null;
			InfoNotaCreditoDTO infoNotaCreditoDTO = null;
			List<ImpuestoDTO> totalConImpuestos = new ArrayList<ImpuestoDTO>();
			List<DetalleNotaCreditoDTO> detallesNota = new ArrayList<DetalleNotaCreditoDTO>();
			
			
			for (String linea : lineasArchivo) {
				if (linea.startsWith(IDENTIFICADOR_INFO_TRIBUTARIA_NC)) {
					
					infoTributariaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_NOTACREDITO,
									XPATH_INFO_TRIBUTARIA_NC,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoTributariaDTO());
					
					infoTributariaDTO.setAmbiente(AMBIENTE);
					infoTributariaDTO.setTipoEmision(TIPO_EMISION_NORMAL);
					
//					logger.info(infoTributariaDTO.toString());
					
				} else if (linea.startsWith(IDENTIFICADOR_INFO_NOTACREDITO)) {
					
					infoNotaCreditoDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_NOTACREDITO,
									XPATH_INFO_NOTACREDITO,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoNotaCreditoDTO());
					infoNotaCreditoDTO.setMoneda(MONEDA); 
					
//					logger.info(infoNotaCReditoDTO.toString());
					
				} else if (linea.startsWith(IDENTIFICADOR_TOTAL_IMPUESTOS_NC)) {
					
					ImpuestoDTO impuestoDTO = UtilXML.getInstancia()
							.construirObject(
									URL_PLANTILLA_NOTACREDITO,
									XPATH_TOTAL_IMPUESTO_NC,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new ImpuestoDTO());
//					logger.info(impuestoDTO.toString());
					totalConImpuestos.add(impuestoDTO);
				} else if (linea.startsWith(IDENTIFICADOR_DETALLE_NC)) {
					
					DetalleNotaCreditoDTO detallesNotaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_NOTACREDITO,
									XPATH_DETALLE_NC,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new DetalleNotaCreditoDTO());
					
//					logger.info(detalleNotaCreditoDTO.toString());
					detallesNota.add(detallesNotaDTO);
					
				} else if (linea.startsWith(IDENTIFICADOR_IMPUESTOS_NC)) {
					ImpuestoDTO impuestoDTO = UtilXML.getInstancia()
							.construirObject(
									URL_PLANTILLA_NOTACREDITO,
									XPATH_IMPUESTOS_NC,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new ImpuestoDTO());
					
//					logger.info(impuestoDTO.toString());
//					logger.info("detalles.size()==0 {} ", detalles.size());
					
					if (detallesNota.get(detallesNota.size()-1).getImpuestos().getImpuesto()==null) {
						detallesNota.get(detallesNota.size()-1).getImpuestos().setImpuesto((new ArrayList<ImpuestoDTO>()));
					}
					detallesNota.get(detallesNota.size()-1).getImpuestos().getImpuesto().add(impuestoDTO);
					
				} 
				
			}
			
			infoTributariaDTO
					.setClaveAcceso(UtilApplication.getClaveAcceso(
							infoNotaCreditoDTO.getFechaEmision(),
							infoTributariaDTO.getCodDoc(),
							infoTributariaDTO.getRuc(),
							infoTributariaDTO.getAmbiente(),
							infoTributariaDTO.getSecuencial(), UtilApplication.getCodigoNumerico(),
							infoTributariaDTO.getTipoEmision(),
							infoTributariaDTO.getEstab(),
							infoTributariaDTO.getPtoEmi()));
			
			notaCreditoDTO.setInfoTributaria(infoTributariaDTO);
			
			TotalConImpuestosDTO totalConImpuestosDTO = new TotalConImpuestosDTO();
			totalConImpuestosDTO.setTotalImpuesto(totalConImpuestos);
			infoNotaCreditoDTO.setTotalConImpuestos(totalConImpuestosDTO);
			
	
			if (CollectionUtils.isNotEmpty(detallesNota)) {
				DetallesNotaDTO detalleNotaCredito= new DetallesNotaDTO();
				detalleNotaCredito.setDetalle(detallesNota);
				notaCreditoDTO.setDetalles(detalleNotaCredito);
			}

			notaCreditoDTO.setInfoNotaCredito(infoNotaCreditoDTO);
			notaCreditoDTO.setId(XML_ATRIBUTO_ID);
			notaCreditoDTO.setVersion(XML_ATRIBUTO_VERSION);
			
			ComprobantesXmlUtil.generarXmlNotaCredito(
					notaCreditoDTO,UtilApplication.appendStringBuilder(getEstructuraArchivos().get(Constantes.carpertaXml),File.separator, infoTributariaDTO.getClaveAcceso(), ".xml").toString());
			
			UtilApplication.moverArchivoProcesado(file, getEstructuraArchivos().get(Constantes.carpetaProcesados));
		}
		
	}
	
}
