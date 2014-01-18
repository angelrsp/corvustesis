package ec.edu.uce.silsag.commons.test;

import ec.edu.uce.silsag.commons.util.EncriptarUtil;

public class TestApplication {
	
	public static void main (String ...args){
		testEncriptar();
	}
	
	public static void testEncriptar () {
		
		String original = "Hello";
		
		System.out.println("Original: " + original);
		
		String originalEncriptado = EncriptarUtil.getFactory().encriptar(original);
		
		System.out.println("encriptar: " + originalEncriptado);
		
		String originalDesencriptado = EncriptarUtil.getFactory().desencriptar(originalEncriptado);
		
		System.out.println("desencriptar: " + originalDesencriptado);
			
	}

}
