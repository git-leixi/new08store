package com.aaa.store08.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String getCurrentDateStr() {
		//生成随机订单号
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");
		String dates = dateFormat.format(date);
		long startTime = System.currentTimeMillis();
		return dates+startTime;
	}
}
