package com.dragon.codingol.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.util.StringUtils;

public class DateCommon {
	public  final static String  YEAR ="year", MONTH = "month", WEEK = "week", DAY = "day";
	public static Date currentDate(){
		 return  new   Date(System.currentTimeMillis());
	}
	
	public static String getCurrentDate(){
		 SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd");     
		 Date   curDate   =   new   Date(System.currentTimeMillis());
		 return formatter.format(curDate);    
	}
	
	public static String getFirstYearMonth(){
		 SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-01-1");     
		 Date   curDate   =   new   Date(System.currentTimeMillis());
		 return formatter.format(curDate);    
	}
	
	public static String getCurrentMonth(){
		 SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM");     
		 Date   curDate   =   new   Date(System.currentTimeMillis());
		 return formatter.format(curDate);    
	}
	
	public static Date getDateByLong(long value){
		 Date date=new Date(value);
		 return date;
	}
	
	public static String addDate(Date date, int add){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, add);
		SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd");
		return formatter.format(calendar.getTime()); 
	}
	
	public static String getDateString(Object date, String format){
		if(StringUtils.isEmpty(format)){
			format = "yyyy-MM-dd";
		}
		 SimpleDateFormat   formatter   =   new   SimpleDateFormat(format);  
		 return formatter.format(date);   
	}
	
	public static Date getDateByString(String value)throws Exception {
		if (value.length() > 19)
			value = value.substring(0, 19);

		Calendar calendar = Calendar.getInstance();
		String[] dateStr = value.split(" ");
		String[] dateInfo = dateStr[0].split("-");
		if (dateInfo.length != 3) {
			dateInfo = dateStr[0].split("/"); // 让 yyyy/mm/dd 的格式也支持
		}
		if (dateInfo.length == 3) {
			int year = Integer.parseInt(dateInfo[0]);
			int month = Integer.parseInt(dateInfo[1]) - 1; // 0~11
			int day = Integer.parseInt(dateInfo[2]);
			calendar.set(year, month, day);
		} else {
			throw new Exception("日期格式不正确");
		}
		if (dateStr.length > 1) {// 有时间（限定格式 hh:mm:ss）
			String[] timeStr = dateStr[1].split(":");
			if (timeStr.length == 3) {
				int hour = Integer.parseInt(timeStr[0]);
				int minute = Integer.parseInt(timeStr[1]);
				int second = Integer.parseInt(timeStr[2]);
				calendar.set(Calendar.HOUR_OF_DAY, hour);
				calendar.set(Calendar.MINUTE, minute);
				calendar.set(Calendar.SECOND, second);
			} else {
				return null; // 格式不正确
			}
		}
		return calendar.getTime();
	}
	
	
	public static List<String> getAnalysisCategorieList(String start, String end, String type)  {
		if (StringUtils.isEmpty(start) || StringUtils.isEmpty(end) ) {
			return null;
		}
		List<String> cate = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sdf.parse(start);
			endDate = sdf.parse(end);
		} catch (ParseException e1) { 
		}
		
		if (endDate.compareTo(startDate) < 0) {
			return null;
		}
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		endCalendar.setTime(endDate);
		switch (type.toLowerCase()) {
		case DateCommon.YEAR: {

			int s = startCalendar.get(Calendar.YEAR);
			int e = endCalendar.get(Calendar.YEAR);
			for (int i = s; i <= e; i++) {
				cate.add(String.valueOf(i));
			}
			break;
		}
		case DateCommon.MONTH: {
			while (startCalendar.before(endCalendar) ){
				cate.add(DateCommon.getDateString(startCalendar.getTime(), "yyyy-MM") );
				startCalendar.add(Calendar.MONTH, 1);
			}
			break;
		}
	 
		case DateCommon.WEEK: {
			startCalendar.setFirstDayOfWeek(2);
			endCalendar.setFirstDayOfWeek(2);
			int startWeek = startCalendar.get(Calendar.WEEK_OF_YEAR);
			int endWeek = endCalendar.get(Calendar.WEEK_OF_YEAR);
			int s = startCalendar.get(Calendar.YEAR);
			int e = endCalendar.get(Calendar.YEAR);
			for (int i = s; i <= e; i++) {
				if (i < e) {
					Date lastDay = null;
					try {
						lastDay = sdf.parse(s + "-12-31");
					} catch (ParseException e1) { 
					}
					Calendar lasyCalendar = Calendar.getInstance();
					lasyCalendar.setTime(lastDay);
					int weekLength = lasyCalendar.get(Calendar.WEEK_OF_YEAR);
					for (int j = 1; j <= weekLength; j++) {
						cate.add(i + "-" + String.valueOf(j));
					}
				} else {
					for (int j = startWeek; j <= endWeek; j++) {
						cate.add(i + "-" + String.valueOf(j));
					}
				}
			}
			break;
		}

		case DateCommon.DAY: {
			long day = (endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24);
			for (int i = 0; i <= day; i++) {
				cate.add(startCalendar.get(Calendar.YEAR) + "-" + (startCalendar.get(Calendar.MONTH) + 1) + "-"
						+ startCalendar.get(Calendar.DAY_OF_MONTH));
				startCalendar.add(Calendar.DAY_OF_MONTH, 1);
			}
			break;
		}
		default:

			break;
		}
		return cate;
	}

}
