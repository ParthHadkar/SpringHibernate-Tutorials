package com.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	// read a date string and parse/convert to a date
	public static Date parseDate(String dateStr) throws ParseException {
		Date date = simpleDateFormat.parse(dateStr);
		return date;
	}
	
	 // read a date and format/convert to a string
	public static String formatDate(Date date) {
		String result = null;
		if(date != null) {
			result = simpleDateFormat.format(date);
		}
		return result;
	}
}
