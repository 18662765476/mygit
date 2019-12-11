package com.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import org.junit.jupiter.api.Test;

public class DateUtil {
	
	//求年龄
	@Test
	public void t1() {
		long age = getAge("1998-09-07");
		System.out.println("1998-09-07   年龄:"+age);
	}
	//根据传入的参数获取该日期的月初日期
	@Test
	public void t2() {
		String dateByMonthInit = getDateByMonthInit("1998-09-07");
		System.out.println("1998-09-07 月初"+dateByMonthInit);
	}
	//根据传入的参数获取该日期的月末日期
	@Test
	public void t5() {
		String dateByMonthLast = getDateByMonthLast("1998-09-07");
		System.out.println("1998-09-07 月末"+dateByMonthLast);
	}
	//求未来日期离今天还剩的天数
	@Test
	public void t3() {
		long daysByFuture = getDaysByFuture("2020-01-13");
		System.out.println("距2020-01-13有"+daysByFuture);
	}
	//求过去日期离今天过去的天数
	@Test
	public void t4() {
		long daysByFuture = getDaysByDeparted("2019-12-10");
		System.out.println("距2019-12-10过去"+daysByFuture);
	}
	//求年龄
	public static long getAge(String date) {
		LocalDate pp = LocalDate.parse(date);
		LocalDate now = LocalDate.now();
		long l = ChronoUnit.YEARS.between(pp, now);
		return l;
	}
	//根据传入的参数获取该日期的月初日期
	public static String getDateByMonthInit (String date) {
		LocalDate mm = LocalDate.parse(date).with(TemporalAdjusters.firstDayOfMonth());
		String ss = LocalDateTime.MIN.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		return mm+" "+ss;
	}
	//根据传入的参数获取该日期的月末日期
	public static String getDateByMonthLast (String date) {
		LocalDate mm = LocalDate.parse(date).with(TemporalAdjusters.lastDayOfMonth());
		String ss = LocalDateTime.MAX.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		return mm+" "+ss;
	}
	//求未来日期离今天还剩的天数
	public static long getDaysByFuture (String future) {
		LocalDate pp = LocalDate.parse(future);
		LocalDate now = LocalDate.now();
		long l = ChronoUnit.DAYS.between(now, pp);
		return l;
	}
	//求过去日期离今天过去的天数
	public static long getDaysByDeparted  (String departed) {
		LocalDate pp = LocalDate.parse(departed);
		LocalDate now = LocalDate.now();
		long l = ChronoUnit.DAYS.between(pp,now);
		return l;
	}
}
