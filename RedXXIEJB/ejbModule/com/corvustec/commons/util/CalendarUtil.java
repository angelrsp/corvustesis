package com.corvustec.commons.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtil {

	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static int getYear(Timestamp da) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(da);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static int getMonth(Timestamp da) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(da);
		int month = cal.get(Calendar.MONTH);
		return month + 1;
	}

	public static Calendar getCalendar(int year, int month, int day) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal;
	}

	public static Calendar getDate(Timestamp time) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(time.getTime());
		return cal;
	}

	public static Timestamp getTimeNowTimestamp() {
		Calendar calendar = Calendar.getInstance();
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	public static String getMonthName(Integer month)
	{
		String monthName = null;
		switch (month) {
		case 1:
			monthName="Enero";
			break;
		case 2:
			monthName="Febrero";
			break;
		case 3:
			monthName="Marzo";
			break;
		case 4:
			monthName="Abril";
			break;
		case 5:
			monthName="Mayo";
			break;
		case 6:
			monthName="Junio";
			break;
		case 7:
			monthName="Julio";
			break;
		case 8:
			monthName="Agosto";
			break;
		case 9:
			monthName="Septiembre";
			break;
		case 10:
			monthName="Obtubre";
			break;
		case 11:
			monthName="Noviembre";
			break;
		case 12:
			monthName="Diciembre";
			break;

		}
		return monthName;
	}

}
