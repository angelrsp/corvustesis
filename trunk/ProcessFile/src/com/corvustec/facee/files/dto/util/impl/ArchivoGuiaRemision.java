/**
 * 
 */
package com.corvustec.facee.files.dto.util.impl;

import static com.corvustec.facee.files.commons.util.Constantes.AMBIENTE;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_DESTINATARIOS;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_DETALLE_GUIA;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_GUIAREMISION;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_TRIBUTARIA_GR;
import static com.corvustec.facee.files.commons.util.Constantes.TIPO_EMISION_NORMAL;
import static com.corvustec.facee.files.commons.util.Constantes.URL_PLANTILLA_GUIAREMISION;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_ID;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_VERSION;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_DESTINATARIOS;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_DETALLE_GUIA;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_GUIAREMISION;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_TRIBUTARIA_GR;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.exception.ProcessFileException;
import com.corvustec.facee.files.commons.util.ComprobantesXmlUtil;
import com.corvustec.facee.files.commons.util.Constantes;
import com.corvustec.facee.files.commons.util.UtilApplication;
import com.corvustec.facee.files.commons.util.UtilXML;
import com.corvustec.facee.files.xml.commons.InfoTributariaDTO;
import com.corvustec.facee.files.xml.guiaRemision.DestinatariosDTO;
import com.corvustec.facee.files.xml.guiaRemision.DetalleGuiaDTO;
import com.corvustec.facee.files.xml.guiaRemision.DetallesGuiaDTO;
import com.corvustec.facee.files.xml.guiaRemision.GuiaRemisionDTO;
import com.corvustec.facee.files.xml.guiaRemision.InfoGuiaRemisionDTO;




/**
 * @author wilmerPC
 *
 */
public class ArchivoGuiaRemision extends Archivo{
	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoGuiaRemision.class);

	
//	public ArchivoGuiaRemision(String urlCarpetaProcesados){
//		super(urlCarpetaProcesados);
//	}
	
	public ArchivoGuiaRemision (Map<String, String> estructuraArchivos) {
		super(estructuraArchivos);
	}

	@Override
	public void procesarArchivo(File file) {
		// TODO Auto-generated method stub
		logger.info("se va ha procesar el archivo {} ArchivoGuiaRemision", file.getName());
		
			try {
				procesarGuiaRemision(file);
			} catch (ProcessFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	private void procesarGuiaRemision (File file) throws ProcessFileException, IOException {
		
		List<String> lineasArchivo = UtilApplication.leerArchivo(file);
		
		if (CollectionUtils.isNotEmpty(lineasArchivo)) {
			
			GuiaRemisionDTO guiaRemisionDTO = new GuiaRemisionDTO();
			InfoTributariaDTO infoTributariaDTO = null;
			InfoGuiaRemisionDTO infoGuiaRemisionDTO = null;
			DestinatariosDTO  destinatariosDTO = null;
			List<DetalleGuiaDTO> detallesGuia = new ArrayList<DetalleGuiaDTO>();
			
			for (String linea : lineasArchivo) {
				if (linea.startsWith(IDENTIFICADOR_INFO_TRIBUTARIA_GR)) {
					
					infoTributariaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_GUIAREMISION,
									XPATH_INFO_TRIBUTARIA_GR,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoTributariaDTO());
					
					infoTributariaDTO.setAmbiente(AMBIENTE);
					infoTributariaDTO.setTipoEmision(TIPO_EMISION_NORMAL);
					
//					logger.info(infoTributariaDTO.toString());
					
				} else if (linea.startsWith(IDENTIFICADOR_INFO_GUIAREMISION)) {
					
					infoGuiaRemisionDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_GUIAREMISION,
									XPATH_INFO_GUIAREMISION,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoGuiaRemisionDTO());
					infoGuiaRemisionDTO.getFechaIniTransporte();
//					logger.info(infoNotaCReditoDTO.toString());
					
				} else if (linea.startsWith(IDENTIFICADOR_DESTINATARIOS)) {
					
					destinatariosDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_GUIAREMISION,
									XPATH_DESTINATARIOS,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new DestinatariosDTO());
					
	//				logger.info(destinatariosDTO.toString());

		
				} else if (linea.startsWith(IDENTIFICADOR_DETALLE_GUIA)) {
					
					DetalleGuiaDTO detalleGuiaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_GUIAREMISION,
									XPATH_DETALLE_GUIA,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new DetalleGuiaDTO());
					
//					logger.info(detalleNotaCreditoDTO.toString());
					
				detallesGuia.add(detalleGuiaDTO);
				
				}
				
			}
			
			String claveAcceso = UtilApplication.getClaveAcceso(
					infoGuiaRemisionDTO.getFechaIniTransporteDate(),
					infoTributariaDTO.getCodDoc(),
					infoTributariaDTO.getRuc(),
					infoTributariaDTO.getAmbiente(),
					infoTributariaDTO.getSecuencial(), UtilApplication.getCodigoNumerico(),
					infoTributariaDTO.getTipoEmision(),
					infoTributariaDTO.getEstab(),
					infoTributariaDTO.getPtoEmi());
			
			if (StringUtils.isEmpty(claveAcceso)) {
				logger.info("Clave de acceso no generada");
				throw new ProcessFileException("Clave de acceso no generada");
			} else {
				infoTributariaDTO.setClaveAcceso(claveAcceso);
			}
			
			guiaRemisionDTO.setInfoTributaria(infoTributariaDTO);
			
			guiaRemisionDTO.setId(XML_ATRIBUTO_ID);
			guiaRemisionDTO.setVersion(XML_ATRIBUTO_VERSION);
			
			guiaRemisionDTO.setInfoTributaria(infoTributariaDTO);
			guiaRemisionDTO.setInfoGuiaRemision(infoGuiaRemisionDTO);
			
			DetallesGuiaDTO detallesGuiaDTO = new DetallesGuiaDTO();
			detallesGuiaDTO.setDetalle(detallesGuia);
			
			destinatariosDTO.setDetalles(detallesGuiaDTO);
			
			guiaRemisionDTO.setDestinatarios(destinatariosDTO);
			
			ComprobantesXmlUtil.generarXmlGuiaRemision(
					guiaRemisionDTO,UtilApplication.appendStringBuilder(getEstructuraArchivos().get(Constantes.carpertaXml),File.separator, infoTributariaDTO.getClaveAcceso(), ".xml").toString());
			
			UtilApplication.moverArchivoProcesado(file, getEstructuraArchivos().get(Constantes.carpetaProcesados));
			
			}
		
		}
}
