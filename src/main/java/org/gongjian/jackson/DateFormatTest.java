package org.gongjian.jackson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatTest {

	public static void main(String[] args) {
		// 2017-02-23T08:04:02+01:00
		String changedTime = "1986-05-04T00:00:00";
		String pattern = "yyyy-MM-dd'T'HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		df.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")));
		
		System.out.println(df.getTimeZone());

		try {
			Date date = df.parse(changedTime);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("abcdef".subSequence(1, 5));
	}

}
