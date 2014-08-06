package com.corvustec.rtoqab.process.util;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilApplication {

	private final static Logger logger = LoggerFactory.getLogger(UtilApplication.class);
	
	
	public static Timestamp stringToTimestamp(String stringDate){
		Timestamp timestamp = null;
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		    Date parsedDate = dateFormat.parse(stringDate);
		    timestamp = new Timestamp(parsedDate.getTime());
		}catch(Exception e){//this generic but you csan control another types of exception
			e.printStackTrace();
		}
		return timestamp;
	}
	
	public static String addSecond(String time,int segundo)
	{
		String newTime = null;
		 SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		 Date d;
		try {
			d = df.parse(time);
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(d);
			 cal.add(Calendar.SECOND, segundo);
			 newTime = df.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		 return newTime;
	}

	public static String addMinute(String time,int minuto)
	{
		String newTime = null;
		 SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		 Date d;
		try {
			d = df.parse(time);
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(d);
			 cal.add(Calendar.MINUTE, minuto);
			 newTime = df.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		 return newTime;
	}

	
	
	public static Date convertTimetoDate(String time)
	{
		SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
		java.util.Date d = null;
		try {
			d = df.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	public static Date convertStringtoDate(String time)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d = null;
		try {
			d = df.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	
	public static void moverArchivo(File fileOrigen, String pathDestino){
		File fdest;
		try {
			fdest = new File(pathDestino);
			if(fdest.exists())
				fdest.delete();
			FileUtils.moveFile(fileOrigen, fdest);
			fdest.setWritable(false);
			fdest.setReadOnly();
			logger.info(String.valueOf(fdest.canWrite()));
		} catch (Exception e) {
			logger.info("Error al mover el archivo {}", e.getCause().toString());
		}
	}

	public static void eliminarArchivo(File file){
		try {
			file.delete();
		} catch (Exception e) {
			logger.info("Error al mover el archivo {}", e.getCause().toString());
		}
	}

	
}
