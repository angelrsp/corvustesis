/**
 * 
 */
package com.corvustec.facee.files.commons.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.enums.EnumTipoArchivo;
import com.corvustec.facee.files.commons.exception.ProcessFileException;
import com.corvustec.facee.files.dto.util.impl.Archivo;
import com.corvustec.facee.files.dto.util.impl.ArchivoComprobanteRetencion;
import com.corvustec.facee.files.dto.util.impl.ArchivoFactura;
import com.corvustec.facee.files.dto.util.impl.ArchivoGuiaRemision;
import com.corvustec.facee.files.dto.util.impl.ArchivoListener;
import com.corvustec.facee.files.dto.util.impl.ArchivoNotaCredito;
import com.corvustec.facee.files.dto.util.impl.ArchivoNotaDebito;

/**
 * @author wilmerPC
 * 
 */
public class UtilFileMonitor {
	
	private final static Logger logger = LoggerFactory.getLogger(UtilFileMonitor.class);
	private static final Long pollingInterval = Long.valueOf(Constantes.TIME_CHECK);
	private static final String sufijo = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.sufijo.tipo.archivo");
	
	private static void iniciarListener(final Map<String, String> estructuraArchivos) {
		
		final String urlFolderPorProcesar = estructuraArchivos.get(Constantes.carpetaPorProcesar);
		
		logger.info("iniciar listener a la carpeta {}", urlFolderPorProcesar);
		
		try {
			
			File fileFolder = new File(urlFolderPorProcesar);
			
			if (!fileFolder.exists()) {
				logger.info("Directory not found: {}", urlFolderPorProcesar);
				throw new RuntimeException("Directory not found: " + urlFolderPorProcesar);
			}
			
			FileAlterationObserver observer = new FileAlterationObserver(fileFolder);
			FileAlterationMonitor monitor = new FileAlterationMonitor(pollingInterval);
			
			FileAlterationListener listener = new FileAlterationListenerAdaptor() {
				// Is triggered when a file is created in the monitored folder
				@Override
				public void onFileCreate(File file) {
					try {
						
						Long inicio = System.currentTimeMillis();
						logger.info("Tiempo inicio: {}", inicio);
						
						// "file" is the reference to the newly created file
						logger.info("File created: {}", file.getCanonicalPath());
						
						if (UtilApplication.esArchivoValido(file, sufijo)) {
							
							Archivo archivo = crearTipoArchivo(file.getName().substring(0, 2), estructuraArchivos);
							
							if (archivo == null) {
								logger.info("el archivo {} no es valido para ser procesado", file.getName());
							} else {
								archivo.procesarArchivo(file);
							}
							
						} else {
							logger.info("El archivo {} no es valido", file.getName());
						}
						
						Long fin = System.currentTimeMillis();
						logger.info("Tiempo fin: {}", fin);
						
						Long total = fin-inicio;
						logger.info("total: {}", total);
						
						Timestamp totalSeg = new Timestamp(total);
						logger.info("totalSeg.getSeconds(): {}", totalSeg.getSeconds());
						logger.info("totalSeg.getNanos(): {}", totalSeg.getNanos());
						
					} catch (IOException e) {
						e.printStackTrace(System.err);
					}
				}
				
				// Is triggered when a file is deleted from the monitored folder
				@Override
				public void onFileDelete(File file) {
					try {
						logger.info("File removed: {}", file.getCanonicalPath());
					} catch (IOException e) {
						e.printStackTrace(System.err);
					}
				}
			};
			
			observer.addListener(listener);
			monitor.addObserver(observer);
			
			monitor.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static List<ArchivoListener> leerArchivoUrlClientes(File file) throws IOException, ProcessFileException{
		
		List<ArchivoListener> listaArchivoListener = new ArrayList<ArchivoListener>();
		
		final String comentarioProperties = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.comentario.properties");
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			if (file!=null){
				
				ArchivoListener archivoListener = null;
				
				fr = new FileReader (file);
				br = new BufferedReader(fr);
				// Lectura del fichero
				String linea;
				
				while ((linea=br.readLine()) != null) {
					
					if (StringUtils.isNotEmpty(linea) && !linea.startsWith(comentarioProperties)) {
						
						String [] line = linea.split(Constantes.SPLIT_IGUAL);
						
						if (line!=null && line.length==2) {
							
							String urlCarpetaPorProcesar = UtilApplication.appendStringBuilder(line[1].trim(), Constantes.carpetaPorProcesar).toString();
							String urlCarpetaProcesados = UtilApplication.appendStringBuilder(line[1].trim(), Constantes.carpetaProcesados).toString();
							String urlCarpetaPendientes = UtilApplication.appendStringBuilder(line[1].trim(), Constantes.capertaPendientes).toString();
							String urlCarpetaXml = UtilApplication.appendStringBuilder(line[1].trim(), Constantes.carpertaXml).toString();
							
							Map<String, String> estructuraArchivos = new HashMap<String, String>();
							estructuraArchivos.put(Constantes.carpetaPorProcesar, urlCarpetaPorProcesar);
							estructuraArchivos.put(Constantes.carpetaProcesados, urlCarpetaProcesados);
							estructuraArchivos.put(Constantes.capertaPendientes, urlCarpetaPendientes);
							estructuraArchivos.put(Constantes.carpertaXml, urlCarpetaXml);
							
							archivoListener = new ArchivoListener(estructuraArchivos);
							archivoListener.verificarEstructuraArchivos();
							
							listaArchivoListener.add(archivoListener);
							
						} else {
							br.close();
							logger.info("Url mal formada: {}", linea);
							throw new ProcessFileException(UtilApplication.appendStringBuilder("Url mal formada: ", linea).toString());
						}
					}
				}
			}
			
		}catch(Exception e){
			logger.info("No se pudo leer el archivo de ruta de los archivos del cliente");
			throw new ProcessFileException(e);
		}finally{
			if( null != fr ){
				fr.close();
			}
		}
		
		return listaArchivoListener;
	}
	
	public static void iniciarListenerClientes() throws ProcessFileException, IOException{
		
		//leer el archivo de rutas para saber cuantos listener de archivo inicializar
		File file = new File(Constantes.URL_ARCHIVO_CLIENTES);
		
		List<ArchivoListener> listaArchivoListener = leerArchivoUrlClientes(file);
		
		if (CollectionUtils.isEmpty(listaArchivoListener)) {
			
			logger.info("El achivo de los clientes esta vacio o no tiene url validas");
			throw new ProcessFileException("El achivo de los clientes esta vacio o no tiene url validas");
			
		} else {
			for (ArchivoListener listener : listaArchivoListener) {
				iniciarListener(listener.getEstructuraArchivos());
			}
		}
		
	}
	
	private static Archivo crearTipoArchivo(String prefijo, Map<String, String> estructuraArchivos) {
		
		if (prefijo.equals(EnumTipoArchivo.FACTURA.getId())) {
			
			return new ArchivoFactura(estructuraArchivos);
			
		} else if (prefijo.equals(EnumTipoArchivo.NOTACREDITO.getId())) {
			
			return new ArchivoNotaCredito(estructuraArchivos);
			
		} else if (prefijo.equals(EnumTipoArchivo.NOTADEBITO.getId())) {
			
			return new ArchivoNotaDebito(estructuraArchivos);
			
		} else if (prefijo.equals(EnumTipoArchivo.GUIAREMISION.getId())) {
			
			return new ArchivoGuiaRemision(estructuraArchivos);
			
		} else if (prefijo.equals(EnumTipoArchivo.COMPROBANTERETENCION.getId())) {
			
			return new ArchivoComprobanteRetencion(estructuraArchivos);
			
		}
		
		return null;
		
	}

}
