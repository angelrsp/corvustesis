package com.corvustec.apce.files.main;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.corvustec.apce.files.commons.util.ReportUtil;
import com.corvustec.apce.files.dto.factura.DetalleFacturaDTO;
import com.corvustec.apce.files.dto.factura.DetallesDTO;
import com.corvustec.apce.files.dto.factura.FacturaDTO;
import com.corvustec.apce.files.dto.factura.ImpuestoDTO;
import com.corvustec.apce.files.dto.factura.ImpuestosDTO;
import com.corvustec.apce.files.dto.factura.InfoFacturaDTO;
import com.corvustec.apce.files.dto.factura.InfoTributariaDTO;
import com.corvustec.apce.files.dto.factura.TotalConImpuestosDTO;
import com.corvustec.apce.files.dto.factura.TotalImpuestoDTO;


public class TestPdf {

	
	public static void mainPDF() {
	
		String filepath = "D:\\FacturacionElectronica\\2301201401171679011600110010012004000851234560117.xml";
				
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		Document document;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.parse(filepath);
			
			
			NodeList infoTributaria = document.getElementsByTagName("infoTributaria");
			NodeList infoFactura = document.getElementsByTagName("infoFactura");
						
			InfoTributariaDTO infoTributariaDTO=new InfoTributariaDTO();
			InfoFacturaDTO infoFacturaDTO=new InfoFacturaDTO();
			
			for (int temp = 0; temp < infoTributaria.getLength(); temp++) {
				Node infoTributariaNode = infoTributaria.item(temp);
				
				if (infoTributariaNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) infoTributariaNode;
		 
					infoTributariaDTO.setAmbiente(eElement.getElementsByTagName("ambiente").item(0).getTextContent());
					infoTributariaDTO.setTipoEmision(eElement.getElementsByTagName("tipoEmision").item(0).getTextContent());
					infoTributariaDTO.setRazonSocial(eElement.getElementsByTagName("razonSocial").item(0).getTextContent());
					infoTributariaDTO.setNombreComercial(eElement.getElementsByTagName("nombreComercial").item(0).getTextContent());
					infoTributariaDTO.setRuc(eElement.getElementsByTagName("ruc").item(0).getTextContent());
					infoTributariaDTO.setClaveAcceso(eElement.getElementsByTagName("claveAcceso").item(0).getTextContent());
					infoTributariaDTO.setCodDoc(eElement.getElementsByTagName("codDoc").item(0).getTextContent());
					infoTributariaDTO.setEstab(eElement.getElementsByTagName("estab").item(0).getTextContent());
					infoTributariaDTO.setPtoEmi(eElement.getElementsByTagName("ptoEmi").item(0).getTextContent());
					infoTributariaDTO.setSecuencial(eElement.getElementsByTagName("secuencial").item(0).getTextContent());
					infoTributariaDTO.setDirMatriz(eElement.getElementsByTagName("dirMatriz").item(0).getTextContent());
				}
				
			}
			
			TotalConImpuestosDTO totalConImpuestosDTO=new TotalConImpuestosDTO();
			
			for (int temp = 0; temp < infoFactura.getLength(); temp++) {
				Node infoFacturaNode = infoFactura.item(temp);
				
				if (infoFacturaNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) infoFacturaNode;
		 
					infoFacturaDTO.setFechaEmision(eElement.getElementsByTagName("fechaEmision").item(0).getTextContent());
					infoFacturaDTO.setDirEstablecimiento(eElement.getElementsByTagName("dirEstablecimiento").item(0).getTextContent());
					infoFacturaDTO.setContribuyenteEspecial(eElement.getElementsByTagName("contribuyenteEspecial").item(0).getTextContent());
					infoFacturaDTO.setObligadoContabilidad(eElement.getElementsByTagName("obligadoContabilidad").item(0).getTextContent());
					infoFacturaDTO.setTipoIdentificacionComprador(eElement.getElementsByTagName("tipoIdentificacionComprador").item(0).getTextContent());
					infoFacturaDTO.setGuiaRemision(eElement.getElementsByTagName("guiaRemision").item(0).getTextContent());
					infoFacturaDTO.setRazonSocialComprador(eElement.getElementsByTagName("razonSocialComprador").item(0).getTextContent());
					infoFacturaDTO.setIdentificacionComprador(eElement.getElementsByTagName("identificacionComprador").item(0).getTextContent());
					infoFacturaDTO.setTotalSinImpuestos(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("totalSinImpuestos").item(0).getTextContent())));
					infoFacturaDTO.setTotalDescuento(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("totalDescuento").item(0).getTextContent())));
					infoFacturaDTO.setPropina(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("propina").item(0).getTextContent())));
					infoFacturaDTO.setImporteTotal(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("importeTotal").item(0).getTextContent())));
					
					NodeList totalConImpuestos = eElement.getElementsByTagName("totalImpuesto");
					
					
					
					List<TotalImpuestoDTO> totalImpuestoDTOList=new ArrayList<TotalImpuestoDTO>();
					
					for(int i=0;i<totalConImpuestos.getLength();i++){
					
						Node totalConImpuestosNode = totalConImpuestos.item(i);
						if (totalConImpuestosNode.getNodeType() == Node.ELEMENT_NODE) {
							
							Element eElement1 = (Element) totalConImpuestosNode;
							
							TotalImpuestoDTO totalImpuestoDTO =new TotalImpuestoDTO();
							
							totalImpuestoDTO.setCodigo(eElement1.getElementsByTagName("codigo").item(0).getTextContent());
							totalImpuestoDTO.setCodigoPorcentaje(eElement1.getElementsByTagName("codigoPorcentaje").item(0).getTextContent());
							totalImpuestoDTO.setBaseImponible(eElement1.getElementsByTagName("baseImponible").item(0).getTextContent());
							totalImpuestoDTO.setValor(eElement1.getElementsByTagName("valor").item(0).getTextContent());
							
							totalImpuestoDTOList.add(totalImpuestoDTO);
						}
					}
					totalConImpuestosDTO.setTotalImpuesto(totalImpuestoDTOList);
				}
				
			}
			
			infoFacturaDTO.setTotalConImpuestos(totalConImpuestosDTO);
			
			NodeList detalles = document.getElementsByTagName("detalles").item(0).getChildNodes();
			DetallesDTO detallesDTO=new DetallesDTO();
			
			List<DetalleFacturaDTO> detalleFacturaDTOList=new ArrayList<DetalleFacturaDTO>();
			
			for (int temp = 0; temp < detalles.getLength(); temp++) {
				Node detallesNode = detalles.item(temp);
				if (detallesNode.getNodeType() == Node.ELEMENT_NODE) {
				
					Element eElement = (Element) detallesNode;
					
					DetalleFacturaDTO detalleFacturaDTO=new  DetalleFacturaDTO();
					
					detalleFacturaDTO.setCodigoPrincipal(eElement.getElementsByTagName("codigoPrincipal").item(0).getTextContent());
					detalleFacturaDTO.setCodigoAuxiliar(eElement.getElementsByTagName("codigoAuxiliar").item(0).getTextContent());
					detalleFacturaDTO.setDescripcion(eElement.getElementsByTagName("descripcion").item(0).getTextContent());
					detalleFacturaDTO.setCantidad(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("cantidad").item(0).getTextContent())));
					detalleFacturaDTO.setPrecioUnitario(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("precioUnitario").item(0).getTextContent())));
					detalleFacturaDTO.setDescuento(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("descuento").item(0).getTextContent())));
					detalleFacturaDTO.setPrecioTotalSinImpuesto(BigDecimal.valueOf(Double.valueOf(eElement.getElementsByTagName("precioTotalSinImpuesto").item(0).getTextContent())));
					
					detalleFacturaDTOList.add(detalleFacturaDTO);
					
					NodeList impuestos= eElement.getElementsByTagName("impuestos");
					
					ImpuestosDTO impuestosDTO=new ImpuestosDTO();
					
					List<ImpuestoDTO> impuestoDTOList=new ArrayList<ImpuestoDTO>();
					
					for(int i=0;i<impuestos.getLength();i++)
					{
						Node impuestosNode = impuestos.item(i);
						if(impuestosNode.getNodeType() == Node.ELEMENT_NODE){
							Element eElement1 = (Element) detallesNode;
							ImpuestoDTO impuestoDTO=new ImpuestoDTO();
							
							impuestoDTO.setCodigo(Integer.valueOf(eElement1.getElementsByTagName("codigo").item(0).getTextContent()));
							impuestoDTO.setCodigoPorcentaje(Integer.valueOf(eElement1.getElementsByTagName("codigoPorcentaje").item(0).getTextContent()));
							impuestoDTO.setTarifa(Double.valueOf(eElement1.getElementsByTagName("tarifa").item(0).getTextContent()));
							impuestoDTO.setBaseImponible(BigDecimal.valueOf(Double.valueOf(eElement1.getElementsByTagName("baseImponible").item(0).getTextContent())));
							impuestoDTO.setValor(BigDecimal.valueOf(Double.valueOf(eElement1.getElementsByTagName("valor").item(0).getTextContent())));
							
							impuestoDTOList.add(impuestoDTO);
							
						}
					}
					
					impuestosDTO.setImpuesto(impuestoDTOList);
					
					detalleFacturaDTO.setImpuestos(impuestosDTO);
					
				}
			}
			
			detallesDTO.setDetalle(detalleFacturaDTOList);
			
			FacturaDTO facturaDTO=new FacturaDTO();
			facturaDTO.setDetalles(detallesDTO);
			facturaDTO.setInfoFactura(infoFacturaDTO);
			facturaDTO.setInfoTributaria(infoTributariaDTO);
			
			facturaDTO.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().get(0).getCodigo().equals("2");
			
			facturaDTO.setIva(facturaDTO.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().get(0).getCodigo().equals("2")?facturaDTO.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().get(0).getValor():"0");
			
			exportFactura(facturaDTO,"123456789","2014-02-01");
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void exportFactura(FacturaDTO fact,String autorizacion,String fechaHoraAuto)
	{
		fact.setAutorizacion(autorizacion);
		fact.setFechaHoraAutorizacion(fechaHoraAuto);
		List<FacturaDTO> factLis=new ArrayList<FacturaDTO>();
		
		factLis.add(fact);
		JasperPrint jasperPrint;
		try {
			jasperPrint = ReportUtil.init("C:\\_javaee\\ProcessFileXML\\report\\factura.jasper", new HashMap(),factLis);
			OutputStream output = new FileOutputStream(new File("D:\\FacturacionElectronica\\"+fact.getInfoTributaria().getClaveAcceso()+".pdf")); 
			JasperExportManager.exportReportToPdfStream(jasperPrint, output); 
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
