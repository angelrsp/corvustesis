package com.corvustec.rtoqab.process.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilApplication {

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
}
