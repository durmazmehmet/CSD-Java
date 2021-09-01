/*----------------------------------------------------------------------------------------------------------------------
    Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public final class Date {
    private static final String [] DAYS_OF_WEEK_TR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
    private static final String [] DAYS_OF_WEEK_EN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String [] MONTHS_TR = {"",
            "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
            "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"
    };
    private static final String [] MONTHS_EN = {"",
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };
    private int m_day, m_mon, m_year;
    private int m_dayOfWeekValue;

    private static void control(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day, mon, year))
            doWorkForException(msg);
    }

    private static int getDayOfWeek(int day, int mon, int year)
    {
        int dayOfYear = getDayOfYear(day, mon, year);

        int totalDays = dayOfYear;

        for (int y = 1900; y < year; ++y)
            totalDays += Month.isLeapYear(y) ? 366 : 365;

        return totalDays % 7;
    }

    private static int getDayOfYear(int day, int mon, int year)
    {
        int dayOfYear = day;

        for (int m = mon - 1; m >= 1; --m)
            dayOfYear += Month.values()[m - 1].getDays(year);

        if (mon > 2 && Month.isLeapYear(year))
            ++dayOfYear;

        return dayOfYear;
    }

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days = Month.values()[mon - 1].getDays(year);

        return day <= days;
    }

    private static void doWorkForException(String msg)
    {
        throw new DateTimeException(msg);
    }

    private void set(int day, int mon, int year)
    {
        m_day = day;
        m_mon = mon;
        m_year = year;
        m_dayOfWeekValue = getDayOfWeek(m_day, m_mon, m_year);
    }

    private static String getDayPostfix(int day)
    {
        String postfix = "th";

        switch (day) {
            case 1:
            case 21:
            case 31:
                postfix = "st";
                break;
            case 2:
            case 22:
                postfix = "nd";
                break;
            case 3:
            case 23:
                postfix = "rd";
                break;
        }

        return postfix;
    }

    public static Date randomDate()
    {
        return randomDate(new Random());
    }

    public static Date randomDate(Random r)
    {
        return randomDate(r, new Date().m_year);
    }

    public static Date randomDate(int year)
    {
        return randomDate(new Random(), year);
    }

    public static Date randomDate(Random r, int year)
    {
        return randomDate(r, year, year);
    }

    public static Date randomDate(int minYear, int maxYear)
    {
        return randomDate(new Random(), minYear, maxYear);
    }

    public static Date randomDate(Random r, int minYear, int maxYear) //[minYear, maxYear]
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int mon = r.nextInt(12) + 1;
        int day = r.nextInt(Month.values()[mon - 1].getDays(year)) + 1;

        return new Date(day, mon, year);
    }

    Date(Date date)
    {
        this.setDate(date.m_day, date.m_mon, date.m_year);
    }

    public Date() //Sistemde o anki tarih bilgisini alıyor
    {
        Calendar now = Calendar.getInstance();

        set(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
    }

    public Date(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }

    public Date(int day, int mon, int year)
    {
        setDate(day, mon, year);
    }

    public int getDay()
    {
        return m_day;
    }
    public int getMon()
    {
        return m_mon;
    }
    public int getYear()
    {
        return m_year;
    }
    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[m_dayOfWeekValue];}
    public int getDayOfYear() {return getDayOfYear(m_day, m_mon, m_year);}
    public boolean isLeapYear() {return Month.isLeapYear(m_year);}

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        control(day, m_mon, m_year, "Invalid day value");
        set(day, m_mon, m_year);
    }

    public void setMonth(Month month)
    {
        setMonthValue(month.ordinal() + 1);
    }

    public void setMonthValue(int mon)
    {
        if (mon == m_mon)
            return;

        control(m_day, mon, m_year, "Invalid month value");
        set(m_day, mon, m_year);
    }

    public void setYear(int year)
    {
        if (year == m_year)
            return;

        control(m_day, m_mon, year, "Invalid year value");
        set(m_day, m_mon, year);
    }

    public void setDate(int day, Month month, int year)
    {
        setDate(day, month.ordinal() + 1, year);
    }

    public void setDate(int day, int mon, int year)
    {
        control(day, mon, year, "Invalid date values");
        set(day, mon, year);
    }

    public String toString()
    {
        return toString('/');
    }

    public String toString(char delim)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delim, m_mon, delim, m_year);
    }

    public String toStringEN()
    {
        return toStringEN('/');
    }

    public String toStringTR()
    {
        return toStringTR('/');
    }

    public String toStringTR(char delim)
    {
        return String.format("%s %s",
                toString(), DAYS_OF_WEEK_TR[m_dayOfWeekValue]);
    }

    public String toStringEN(char delim)
    {
        return String.format("%s %s",
                toString(), DAYS_OF_WEEK_EN[m_dayOfWeekValue]);
    }

    public String toLongDateStringTR()
    {
        return String.format("%02d %s %04d %s", m_day, MONTHS_TR[m_mon], m_year, DAYS_OF_WEEK_TR[m_dayOfWeekValue]);
    }

    public String toLongDateStringEN()
    {
        return String.format("%02d%s %s %04d %s", m_day, getDayPostfix(m_day), MONTHS_EN[m_mon], m_year,
                DAYS_OF_WEEK_EN[m_dayOfWeekValue]);
    }
}
