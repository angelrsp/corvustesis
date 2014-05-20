package com.corvustec.firmaelectronica.test;

import com.corvustec.firmaelectronica.formato.XAdESBESSignature;

public class TesterFirma {

	public static void main(String[] args) {
		
		try{
			if(args[0]==null)
				System.out.println("No se encontro argumento args[0]");
			if(args[1]==null)
				System.out.println("No se encontro argumento args[1]");
			if(args[2]==null)
				System.out.println("No se encontro argumento args[2]");
			if(args[3]==null)
				System.out.println("No se encontro argumento args[3]");
			
			XAdESBESSignature.firmar(args[0], args[1], args[2], args[3],args[4]);
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.out.println("Los parametros estan mal ingresados");
		}
	}

}
