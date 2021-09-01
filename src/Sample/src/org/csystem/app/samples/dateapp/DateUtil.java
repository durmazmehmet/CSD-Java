package org.csystem.app.samples.dateapp;

import org.csystem.util.datetime.Date;

public class DateUtil {
	public static void displayDateEN(int day, int mon, int year)
	{
		System.out.println(new Date(day, mon, year).toLongDateStringEN());
	}
	
	public static void displayDateTR(int day, int mon, int year)
	{
		System.out.println(new Date(day, mon, year).toLongDateStringTR());
	}

	public static void printRandomDate()
	{
		System.out.println(Date.randomDate(1900, 2100).toStringEN());
	}
}
