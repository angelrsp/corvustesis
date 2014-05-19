package com.corvustec.facturacionelectronica.webservice;

import java.io.File;

import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;

public class TestWebService {

	public static void main(String[] args) {
		File file=new File("D:\\FacturacionElectronica\\pruebaFirmada.xml");
		
		//Envio de comprobantes
		//Desarrollo
		Object a = ComprobantesElectronicosWs.verificarConectividad("1", ComprobantesElectronicosWs.SERVICIO_RECEPCION);
        if(a==null)
        {
        	System.out.println("No se pudo conectar");
        }
        else
        {
            RespuestaSolicitud response = ComprobantesElectronicosWs.enviarComprobante(file);
            
            System.out.println("estado "+response.getEstado());
            System.out.println("respuesta: "+ComprobantesElectronicosWs.getMensajeRespuestaEnvio(response));
        }
        
        
        String claveAcceso="1605201401019037177800110000010000000010000000119";
        //Autorizacion comprobantes
        RespuestaComprobante responseAut=new RespuestaComprobante();
        try{
            Object aut= AutorizacionComprobantesElectronicosWs.verificarConectividad("1", AutorizacionComprobantesElectronicosWs.SERVICIO_AUTORIZACION);
            if(aut == null) {
                System.out.println("No se puede conectar al servicio Autorizacion del SRI implementar envio contingencia");
                responseAut.setClaveAccesoConsultada("No se puede conectar al servicio Autorizacion del SRI implementar envio contingencia");
            }
            else{
                responseAut=AutorizacionComprobantesElectronicosWs.autorizacionComprobante(claveAcceso);
            }
        }catch(Exception e){
            e.printStackTrace();
            responseAut.setClaveAccesoConsultada(e.toString());
        }
        
        for(Autorizacion item : responseAut.getAutorizaciones().getAutorizacion())
        {
        	System.out.println("estado "+item.getEstado());	
        }
        
        
        
	}
}
