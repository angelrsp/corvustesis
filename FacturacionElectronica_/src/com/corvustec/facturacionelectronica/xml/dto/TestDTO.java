package com.corvustec.facturacionelectronica.xml.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;


public class TestDTO {

	
	public static void main(String[] args) {
		FacturaDTO fac=new FacturaDTO();
		fac.setId("aa");
		fac.setVersion("1.0");
		fac.setPrueba("zzz");
		
		InfoTributariaDTO in=new InfoTributariaDTO();
		in.setAmbiente("am");
		in.setRazonSocial("razon");
		in.setTipoEmision("tipo");
		
		fac.setInfoTributariaDTO(in);
		
        try {
    		javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(FacturaDTO.class);
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
	        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        //marshaller.marshal(fac, System.out);
	        OutputStream os = new FileOutputStream( "D:\\nosferatu.xml" );
	        marshaller.marshal( fac, os );
	        os.close();
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //NOI18N
        catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static File generarXmlFactura(FacturaDTO facturaDTO, String pathGenerateFile){
		File xmlFactura = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(FacturaDTO.class);
			xmlFactura = generarXml(jc, facturaDTO, pathGenerateFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return xmlFactura;
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
