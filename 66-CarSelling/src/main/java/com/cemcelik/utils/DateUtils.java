package com.cemcelik.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getCurrentDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
		return simpleDateFormat.format(date);
	}

}
