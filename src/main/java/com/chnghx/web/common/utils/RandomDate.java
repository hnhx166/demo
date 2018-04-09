package com.chnghx.web.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 随机生成时间
 * @author Administrator
 *
 */
public class RandomDate extends SimpleDateFormat{
	
	
	private static final long serialVersionUID = 2034080534582081403L;

	public static String randomDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 0, 1);
		long start = cal.getTimeInMillis();
		long end = System.currentTimeMillis();
		Date d = new Date(start + (long) (new Random().nextDouble() * (end - start)));
		return new SimpleDateFormat("yyyy-MM-dd hh:ss:mm").format(d);
	}
	
}
