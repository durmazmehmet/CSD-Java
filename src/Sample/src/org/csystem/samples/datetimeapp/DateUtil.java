package org.csystem.samples.datetimeapp;

public class DateUtil {
	public static void displayDateTR(int day, int mon, int year)
	{
		int dayOfWeek = getDayOfWeek(day, mon, year);

		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}

		String [] weekDays = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};

		System.out.printf("%02d/%02d/%04d %s%n", day, mon, year, weekDays[dayOfWeek]);
	}
	
	public static int getDayOfWeek(int day, int mon, int year)
	{
		int dayOfYear = getDayOfYear(day, mon, year);
		
		if (dayOfYear < 0 || year < 1900)
			return -1;
		
		int totalDays = dayOfYear;
		
		for (int y = 1900; y < year; ++y)
			totalDays += isLeapYear(y) ? 366 : 365;		
		
		return totalDays % 7;				
	}
	
	public static int getDayOfYear(int day, int mon, int year)
	{
		if (!isValidDate(day, mon, year))
			return -1;

		int dayOfYear = day;
		int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		for (int m = mon - 1; m >= 1; --m)
			dayOfYear += daysOfMonths[m];

		if (mon > 2 && isLeapYear(year))
			++dayOfYear;
		
		return dayOfYear;
	}
	public static boolean isValidDate(int day, int mon, int year)
	{
		if (day < 1 || day > 31 || mon < 1 || mon > 12)
			return false;
		
		int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int days = mon == 2 && isLeapYear(year) ? 29 : daysOfMonths[mon];
		
		return day <= days;		
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
