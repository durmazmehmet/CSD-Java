package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private static final String [] DAYS_OF_WEEK_TR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
    private static final String [] DAYS_OF_WEEK_EN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String [] MONTHS_TR =
            {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private static final String [] MONTHS_EN =
            {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private int m_day, m_mon, m_year;
    private int m_dayOfYear;

    private static int getDayOfYear(int day, int mon, int year)
    {
        int dayOfYear = day;

        for (int m = mon - 1; m >= 1; --m)
            dayOfYear += Month.values()[m - 1].days();

        if (mon > 2 && Month.isLeapYear(year))
            ++dayOfYear;

        return dayOfYear;
    }

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days = Month.values()[mon - 1].daysByYear(year);

        return day <= days;
    }

    private static void control(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day, mon, year))
            doWorkForException(msg);
    }

    private static void controlForCtor(int day, int mon, int year)
    {
        control(day, mon, year, "Invalid date");
    }

    private static void doWorkForException(String msg)
    {
        throw new DateTimeException(msg);
    }

    private void controlForDay(int day)
    {
        control(day, m_mon, m_year, "Invalid day");
    }

    private void controlForMonth(int mon)
    {
        control(m_day, mon, m_year, "Invalid month");
    }

    private void controlForYear(int year)
    {
        control(m_day, m_mon, year, "Invalid year");
    }

    private int getDayOfWeek(int day, int mon, int year)
    {
        int dayOfYear = m_dayOfYear;

        for (int y = 1900; y < year; ++y)
            dayOfYear += Month.isLeapYear(y) ? 366 : 365;

        return dayOfYear % 7;
    }

    private int getDayOfWeekValue() {return getDayOfWeek(m_day, m_mon, m_year);}
    private void calculateDayOfYear()
    {
        m_dayOfYear = getDayOfYear(m_day, m_mon, m_year);
    }

    private String getDayPostfix()
    {
        String postfix;

        switch (m_day) {
            case 1: case 21: case 31:
                postfix = "st";
                break;
            case 2: case 22:
                postfix = "nd";
                break;
            case 3: case 23:
                postfix = "rd";
                break;
            default:
                postfix = "th";
        }

        return postfix;
    }

    public static Date randomDate()
    {
        return randomDate(new Random());
    }

    public static Date randomDate(Random r)
    {
        Date now = new Date();

        return randomDate(r, now.m_year);
    }

    public static Date randomDate(Random r, int year)
    {
        return randomDate(r, year, year);
    }

    public static Date randomDate(int year)
    {
        return randomDate(new Random(), year);
    }

    public static Date randomDate(int minYear, int maxYear) //[minYear, maxYear]
    {
        return randomDate(new Random(), minYear, maxYear);
    }

    public static Date randomDate(Random r, int minYear, int maxYear) //[minYear, maxYear]
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int mon = r.nextInt(12) + 1;
        int day = mon == 2 && Month.isLeapYear(year) ? r.nextInt(29) + 1 : r.nextInt(Month.values()[mon - 1].days()) + 1;

        return new Date(day, mon, year);
    }

    void setDate(Date date)
    {
        m_day = date.m_day;
        m_mon = date.m_mon;
        m_year = date.m_year;
        m_dayOfYear = date.m_dayOfYear;
    }
    Date(Date date)
    {
        setDate(date);
    }

    public Date() //Çağrıldığında sistemin tarihini alır
    {
        Calendar now = Calendar.getInstance();

        m_day = now.get(Calendar.DAY_OF_MONTH);
        m_mon = now.get(Calendar.MONTH) + 1;
        m_year = now.get(Calendar.YEAR);
        calculateDayOfYear();
    }

    public Date(int day, int mon, int year)
    {
        controlForCtor(day, mon, year);
        m_day = day;
        m_mon = mon;
        m_year = year;
        calculateDayOfYear();
    }

    public Date(int day, Month mon, int year)
    {
        this(day, mon.ordinal() + 1, year);
    }

    public int getDay() {return m_day;}

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        controlForDay(day);
        m_day = day;
        calculateDayOfYear();
    }

    public int getMonthValue() {return m_mon;}
    public Month getMonth() {return Month.values()[m_mon - 1];}
    public void setMonthValue(int mon)
    {
        if (mon == m_mon)
            return;

        controlForMonth(mon);
        m_mon = mon;
        calculateDayOfYear();
    }

    public void setMonth(Month mon)
    {
        setMonthValue(mon.ordinal() + 1);
    }

    public int getYear() {return m_year;}

    public void setYear(int year)
    {
        if (year == m_year)
            return;

        controlForYear(year);
        m_year = year;
        calculateDayOfYear();
    }

    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[getDayOfWeekValue()];}
    public String getDayOfWeekTR() {return DAYS_OF_WEEK_TR[getDayOfWeekValue()];}
    public String getDayOfWeekEN() {return DAYS_OF_WEEK_EN[getDayOfWeekValue()];}
    public int getDayOfYear() {return m_dayOfYear;}

    public boolean isLeapYear() {return Month.isLeapYear(m_year);}

    public boolean isWeekend()
    {
        DayOfWeek dow = getDayOfWeek();

        return dow == DayOfWeek.SAT || dow == DayOfWeek.SUN;
    }

    public boolean isNotWeekend() {return !isWeekend();}

    public String toString() {return toString('/');}

    public String toString(char delim)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delim, m_mon, delim, m_year);
    }

    public String toStringEN()
    {
        return String.format("%02d%s %s %04d", m_day, getDayPostfix(), MONTHS_EN[m_mon], m_year);
    }

    public String toLongDateStringTR()
    {
        return String.format("%02d %s %04d %s", m_day, MONTHS_TR[m_mon], m_year, getDayOfWeekTR());
    }

    public String toLongDateStringEN()
    {
        return String.format("%02d %s %04d %s", m_day, MONTHS_EN[m_mon], m_year, getDayOfWeekEN());
    }
}
