package com.corvustec.signture.main;

import java.io.File;

import com.corvustec.signature.xml.Signature;


public class Test {

	public static void main(String[] args) {
		
		File file=new File("D:\\FacturacionElectronica\\clientes\\Prueba\\xml\\0710201301179125123700110010650000000107791051216.xml");

		Signature.executeEncrypted(file, "D:\\FacturacionElectronica\\clientes\\Prueba\\firmado\\0710201301179125123700110010650000000107791051216.xml", "D:\\FacturacionElectronica\\clientes\\Prueba\\firma\\francisco_arturo_velez_rojas.p12", "ulygGd+Hh/4di7WinfA1NA=");
		
	}
	
}
