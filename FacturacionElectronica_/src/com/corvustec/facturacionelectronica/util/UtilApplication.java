package com.corvustec.facturacionelectronica.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class UtilApplication {

	
	
public static byte[] fileToByte(File file) {
		
		InputStream fileInputStream = null;
		
		try {
			
			byte[] bFile = new byte[(int) file.length()];
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			
//			for (int i = 0; i < bFile.length; i++) {
//				System.out.print((char) bFile[i]);
//			}
			return bFile;
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (Exception e) {
			
		}
		return null;
	}
}
