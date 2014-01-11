/**
 * 
 */
package com.corvustec.apce.files.commons.util;

import static com.corvustec.apce.files.commons.util.Constantes.SPLIT_ARCHIVOS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.apce.files.commons.exception.ProcessFileException;

/**
 * @author wilmerPC
 *
 */
public final class UtilApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(UtilApplication.class);
	
	private static final String separadorNombre = MessagesApplication.getInstancia().getString("com.corvustec.apce.files.separador.nombres");
	private static final SimpleDateFormat sdf = new SimpleDateFormat(MessagesApplication.getInstancia().getString("com.corvustec.apce.files.formato.fecha"));
	
//	private static final UtilApplication INSTANCIA = new UtilApplication();
//	
	private UtilApplication () {}
	
//	/**
//	 * Devolvemos la instancia de la clase
//	 * @return INSTANCIA
//	 */
//	public static UtilApplication getInstancia() {
//		return INSTANCIA;
//	}
	
	/**
	 * 
	 * @param file
	 */
	public static void moverArchivoProcesado(File file, String urlCarpetaProcesados) throws ProcessFileException{
		
		File fdest = new File(new StringBuilder().append(urlCarpetaProcesados)
				.append(File.separator).append(sdf.format(new Date())).append(File.separator).append(obtenerNuevoNombreArchivo(file)).toString());
		
		try {
			FileUtils.moveFile(file, fdest);
		} catch (Exception e) {
			logger.info("Error al mover el archivo {}", e.getCause().toString());
			throw new ProcessFileException();
		}
	}
	
	/**
	 * Validar si es un archivo valido antes de procesar
	 * @param file
	 * @param suffix
	 * @return
	 */
	public static Boolean esArchivoValido(File file, final String suffix){
		return file.getName().endsWith(suffix.toLowerCase())  || file.getName().endsWith(suffix.toUpperCase());
	}
	
	private static String obtenerNuevoNombreArchivo(File file){
		String nombre = file.getName().substring(0,file.getName().lastIndexOf("."));
		String extension = file.getName().substring(file.getName().lastIndexOf("."),file.getName().length());
		return appendStringBuilder(nombre, separadorNombre, String.valueOf(System.currentTimeMillis()), extension).toString();
	}
	
	/**
	 * M&eacute;todo para concatenar varios StringBuilder
	 * @param values
	 * @return StringBuilder
	 */
	public static StringBuilder appendStringBuilder(Object... values) {
			
		StringBuilder builder = new StringBuilder();
		
		for (Object value : values) {
			if (value == null) {
				builder.append(String.valueOf(value));
			}
			builder.append(value);
		}
		return builder;
	}
	
	
	public static List<String> leerArchivo(File file) throws ProcessFileException, IOException{
		
		List<String> lineasArchivo = null;
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			if (file == null) {
				
				throw new ProcessFileException("No se recibio el archivo para procesar");
				
			} else {
				
				lineasArchivo = new ArrayList<String>();
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				// Lectura del fichero
				String linea;
				
				while ((linea=br.readLine()) != null) {
//					logger.info(linea);
					lineasArchivo.add(linea);
				}
				
			}

		} catch (FileNotFoundException e) {
			logger.info("No se encontro el archivo para procesar");
			throw new ProcessFileException(e);
		} catch(Exception e){
			logger.info("No se pudo procesar el archivo");
			throw new ProcessFileException(e);
		} finally {
			fr.close();
			br.close();
		}
		return lineasArchivo;
	}
	
	public static Date formatStringToDate(String date, String pattern) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.parse(date);
		} catch (ParseException e) {
			logger.info("No se pudo transformar la fecha ingresada");
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatDateToString(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	
	public static String getClaveAcceso(Date fechaEmision, String codDoc,
			String ruc, String ambiente, String secuencial,
			String codigoNumerio, String tipoEmision, String estab, String ptoEmi){
		
		String serie = appendStringBuilder(estab, ptoEmi).toString();

		String dato = appendStringBuilder(
				formatDateToString(fechaEmision,Constantes.FORMATO_FECHA_CLAVE_ACCESO), codDoc, ruc, ambiente, serie, secuencial, codigoNumerio,tipoEmision)
				.toString();
		
		if (dato.length() == 48 ){
			int digitoVerificador = getVerificadorDigit(dato);
			return appendStringBuilder(dato, digitoVerificador).toString();
		}
		
		return null;
		
	}

	public static int getVerificadorDigit(String dato)
	{
		int[] secuencia=new int[]{2,3,4,5,6,7};
        
        int acum=0;
        int resul=0;
        
        for(int i=dato.length();i>0;i--)
        {
  		  	acum=(acum<secuencia.length)?acum:0;
			resul+=Integer.parseInt(dato.substring(i-1, i))*secuencia[acum];
  		  	acum++;
        }
        
        resul=resul%11;
        
        resul=11-resul;
        
        switch (resul) {
			case 10:
				resul=1;
				break;
			case 11:
				resul=0;
				break;
        }
        return resul;
	}
	
	public static String getCodigoNumerico() {
		String dato = String.valueOf(System.currentTimeMillis());
		return dato.substring(dato.length()-8, dato.length());
	}
	
	/**
	 * Eliminar el identificador de la linea a procesar
	 * @param linea
	 * @return
	 */
	public static StringBuilder getLineaProcesar (StringBuilder linea) {
		
		int posicion = linea.indexOf(SPLIT_ARCHIVOS);
		linea.delete(0, posicion+1);
		
		return linea;
	}
	
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
	
	public static void enviarMail()
	{
		
	}
}
