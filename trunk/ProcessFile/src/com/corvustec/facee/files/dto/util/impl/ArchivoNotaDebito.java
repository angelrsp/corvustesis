/**
 * 
 */
package com.corvustec.facee.files.dto.util.impl;

import static com.corvustec.facee.files.commons.util.Constantes.AMBIENTE;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_IMPUESTO_ND;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_NOTACREDITO;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_INFO_TRIBUTARIA_ND;
import static com.corvustec.facee.files.commons.util.Constantes.IDENTIFICADOR_MOTIVOS;
import static com.corvustec.facee.files.commons.util.Constantes.TIPO_EMISION_NORMAL;
import static com.corvustec.facee.files.commons.util.Constantes.URL_PLANTILLA_NOTADEBITO;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_ID;
import static com.corvustec.facee.files.commons.util.Constantes.XML_ATRIBUTO_VERSION;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_IMPUESTO_ND;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_NOTADEBITO;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_INFO_TRIBUTARIA_ND;
import static com.corvustec.facee.files.commons.util.Constantes.XPATH_MOTIVOS;


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
import com.corvustec.facee.files.xml.factura.ImpuestosDTO;
import com.corvustec.facee.files.xml.notaDebito.InfoNotaDebitoDTO;
import com.corvustec.facee.files.xml.notaDebito.MotivoDTO;
import com.corvustec.facee.files.xml.notaDebito.MotivosDTO;
import com.corvustec.facee.files.xml.notaDebito.NotaDebitoDTO;

/**
 * @author wilmerPC
 *
 */
public class ArchivoNotaDebito extends Archivo{
	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoNotaDebito.class);


//	public ArchivoNotaDebito(String urlCarpetaProcesados){
//		super(urlCarpetaProcesados);
//	}
	
	public ArchivoNotaDebito (Map<String, String> estructuraArchivos) {
		super(estructuraArchivos);
	}

	@Override
	public void procesarArchivo(File file) {
		// TODO Auto-generated method stub
		logger.info("se va ha procesar el archivo {} ArchivoNotaDebito", file.getName());
		try {
			procesarNotaDebito(file);
		} catch (ProcessFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void procesarNotaDebito(File file) throws ProcessFileException, IOException{
		List<String> lineasArchivo = UtilApplication.leerArchivo(file);
		
		if (CollectionUtils.isNotEmpty(lineasArchivo)) {
			
			NotaDebitoDTO notaDebitoDTO = new NotaDebitoDTO();
			InfoTributariaDTO infoTributariaDTO = null;
			InfoNotaDebitoDTO infoNotaDebitoDTO = null;
			List<ImpuestoDTO> impuestos = new ArrayList<ImpuestoDTO>();
			List<MotivoDTO> motivos = new ArrayList<MotivoDTO>();
			
			for (String linea : lineasArchivo) {
				if (linea.startsWith(IDENTIFICADOR_INFO_TRIBUTARIA_ND)) {
					
					infoTributariaDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_NOTADEBITO,
									XPATH_INFO_TRIBUTARIA_ND,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoTributariaDTO());
					
					infoTributariaDTO.setAmbiente(AMBIENTE);
					infoTributariaDTO.setTipoEmision(TIPO_EMISION_NORMAL);
					
//					logger.info(infoTributariaDTO.toString());
					
				} else if (linea.startsWith(IDENTIFICADOR_INFO_NOTACREDITO)) {
					
					infoNotaDebitoDTO = UtilXML
							.getInstancia().construirObject(
									URL_PLANTILLA_NOTADEBITO,
									XPATH_INFO_NOTADEBITO,
									UtilApplication.getLineaProcesar(new StringBuilder(linea.trim())),
									new InfoNotaDebitoDTO());
					
//					logger.info(infoNotaCReditoDTO.toString());
					
					
				} else if (linea.startsWith(IDENTIFICADOR_IMPUESTO_ND)) {
					ImpuestoDTO impuestoDTO = UtilXML.getInstancia()
							.construirObject(
									URL_PLANTILLA_NOTADEBITO,
									XPATH_IMPUESTO_ND,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new ImpuestoDTO());
					impuestos.add(impuestoDTO);
					
//					logger.info(impuestoDTO.toString());
//					logger.info("detalles.size()==0 {} ", detalles.size());
					
				} else if (linea.startsWith(IDENTIFICADOR_MOTIVOS)) {
					MotivoDTO motivoDTO = UtilXML.getInstancia()
							.construirObject(
									URL_PLANTILLA_NOTADEBITO,
									XPATH_MOTIVOS,
									UtilApplication.getLineaProcesar(new StringBuilder(linea
											.trim())), new MotivoDTO());
					motivos.add(motivoDTO);
				
				} 
			} 
			
			infoTributariaDTO
			.setClaveAcceso(UtilApplication.getClaveAcceso(
					infoNotaDebitoDTO.getFechaEmision(),
					infoTributariaDTO.getCodDoc(),
					infoTributariaDTO.getRuc(),
					infoTributariaDTO.getAmbiente(),
					infoTributariaDTO.getSecuencial(), UtilApplication.getCodigoNumerico(),
					infoTributariaDTO.getTipoEmision(),
					infoTributariaDTO.getEstab(),
					infoTributariaDTO.getPtoEmi()));
	
			notaDebitoDTO.setInfoTributaria(infoTributariaDTO);
	
			ImpuestosDTO impuestosDTO = new ImpuestosDTO();
			impuestosDTO.setImpuesto(impuestos);
			infoNotaDebitoDTO.setImpuestos(impuestosDTO);
	
			MotivosDTO motivosDTO = new MotivosDTO();
			motivosDTO.setMotivo(motivos);
			notaDebitoDTO.setMotivos(motivosDTO);

			notaDebitoDTO.setInfoNotaDebito(infoNotaDebitoDTO);
			notaDebitoDTO.setId(XML_ATRIBUTO_ID);
			notaDebitoDTO.setVersion(XML_ATRIBUTO_VERSION);
	
			ComprobantesXmlUtil.generarXmlNotaDebito(
			notaDebitoDTO,UtilApplication.appendStringBuilder(getEstructuraArchivos().get(Constantes.carpertaXml),File.separator, infoTributariaDTO.getClaveAcceso(), ".xml").toString());
	
			UtilApplication.moverArchivoProcesado(file, getEstructuraArchivos().get(Constantes.carpetaProcesados));
			
		}
	}

}
