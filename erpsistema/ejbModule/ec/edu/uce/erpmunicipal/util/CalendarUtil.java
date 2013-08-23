package ec.edu.uce.erpmunicipal.util;

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
		return month+1;
	}

	public static Calendar getCalendar(int year, int month, int day) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal;
	}

}
