package org.gongjian.jackson;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CustomDateFormat extends SimpleDateFormat {

	private static final long serialVersionUID = 1L;

	@Override
	public Date parse(String source, ParsePosition pos) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		cal.set(Calendar.YEAR, Integer.parseInt(source.substring(0, 4)));
		cal.set(Calendar.MONTH, Integer.parseInt(source.substring(5, 7)) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(source.substring(8, 10)));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}

}
