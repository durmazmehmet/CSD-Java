package org.csystem.util.datetime;

import java.util.Random;

public class DateTime {
    private Date m_date;
    private Time m_time;

    private DateTime(Date date, Time time)
    {
        m_date = date;
        m_time = time;
    }

    public static DateTime randomDateTime()
    {
        return randomDateTime(new Random());
    }

    public static DateTime randomDateTime(Random r)
    {
        int year = new Date().getYear();

        return randomDateTime(r, year);
    }

    public static DateTime randomDateTime(int year)
    {
        return randomDateTime(new Random(), year);
    }

    public static DateTime randomDateTime(Random r, int year)
    {
        return randomDateTime(year, year);
    }

    public static DateTime randomDateTime(int minYear, int maxYear)
    {
        return randomDateTime(new Random(), minYear, maxYear);
    }

    public static DateTime randomDateTime(Random r, int minYear, int maxYear)
    {
        Date date = Date.randomDate(r, minYear, maxYear);
        Time time = Time.randomTime(r);

        return new DateTime(date, time);
    }

    public DateTime()
    {
        m_date = new Date();
        m_time = new Time();
    }

    public DateTime(int day, int mon, int year, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(day, mon, year);
        m_time = new Time(hour, minute, second, millisecond);
    }

    public int getDay()  //delegate method
    {
        return m_date.getDay();
    }

    public int getMonthValue()
    {
        return m_date.getMonthValue();
    }

    public Month getMonth()
    {
        return m_date.getMonth();
    }

    public int getYear()
    {
        return m_date.getYear();
    }

    public DayOfWeek getDayOfWeek()
    {
        return m_date.getDayOfWeek();
    }

    public String getDayOfWeekTR()
    {
        return m_date.getDayOfWeekTR();
    }

    public String getDayOfWeekEN()
    {
        return m_date.getDayOfWeekEN();
    }

    public int getDayOfYear()
    {
        return m_date.getDayOfYear();
    }

    public int getHour()
    {
        return m_time.getHour();
    }

    public int getMinute()
    {
        return m_time.getMinute();
    }

    public int getSecond()
    {
        return m_time.getSecond();
    }

    public int getMillisecond()
    {
        return m_time.getMillisecond();
    }

    public boolean isLeapYear()
    {
        return m_date.isLeapYear();
    }

    public boolean isWeekend()
    {
        return m_date.isWeekend();
    }

    public boolean isNotWeekend()
    {
        return m_date.isNotWeekend();
    }

    public Date getDate() {return new Date(m_date);}

    public Time getTime() {return new Time(m_time);}

    public void setDay(int day)
    {
        m_date.setDay(day);
    }

    public void setMonthValue(int mon)
    {
        m_date.setMonthValue(mon);
    }

    public void setMonth(Month mon)
    {
        m_date.setMonth(mon);
    }

    public void setYear(int year)
    {
        m_date.setYear(year);
    }

    public void setHour(int hour)
    {
        m_time.setHour(hour);
    }

    public void setMinute(int minute)
    {
        m_time.setMinute(minute);
    }

    public void setSecond(int second)
    {
        m_time.setSecond(second);
    }

    public void setMillisecond(int millisecond)
    {
        m_time.setMillisecond(millisecond);
    }

    public void setDate(Date date)
    {
        m_date.setDate(date);
    }

    public void setTime(Time time)
    {
        m_time.setTime(time);
    }

    public String toString()
    {
        return toString('/');
    }

    public String toString(char delim)
    {
        return String.format("%s %s", m_date.toString(delim), m_time.toString());
    }

    public String toStringEN()
    {
        return String.format("%s %s", m_date.toStringEN(), m_time.toString());
    }

    public String toLongDateTimeStringTR()
    {
        return String.format("%s %s", m_date.toLongDateStringTR(), m_time.toLongTimeString());
    }

    public String toLongDateTimeStringEN()
    {
        return String.format("%s %s", m_date.toLongDateStringEN(), m_time.toLongTimeString());
    }
}
