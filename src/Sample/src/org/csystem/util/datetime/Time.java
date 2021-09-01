package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Time {
    private int m_hour, m_minute, m_second, m_millisecond;

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute)
                && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static boolean isValidForHour(int hour)
    {
        return isValidForBounds(hour, 23);
    }

    private static boolean isValidForMinute(int minute)
    {
        return isValidForBounds(minute, 59);
    }

    private static boolean isValidForSecond(int second)
    {
        return isValidForBounds(second, 59);
    }

    private static boolean isValidForMillisecond(int millisecond)
    {
        return isValidForBounds(millisecond, 999);
    }

    private static boolean isValidForBounds(int val, int max)
    {
        return 0 <= val && val <= max;
    }

    private static void doWorkForException(String msg)
    {
        throw new DateTimeException(msg);
    }

    private static void controlForTime(int hour, int minute, int second, int millisecond)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException("Invalid time");
    }

    private static void controlForHour(int hour)
    {
        if (!isValidForHour(hour))
            doWorkForException("Invalid Hour");
    }

    private static void controlForMinute(int minute)
    {
        if (!isValidForMinute(minute))
            doWorkForException("Invalid Minute");
    }

    private static void controlForSecond(int second)
    {
        if (!isValidForSecond(second))
            doWorkForException("Invalid Second");
    }

    private static void controlForMillisecond(int millisecond)
    {
        if (!isValidForMillisecond(millisecond))
            doWorkForException("Invalid Millisecond");
    }

    public static Time randomTime()
    {
        return randomTime(new Random());
    }

    public static Time randomTime(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60), r.nextInt(1000));
    }

    //...

    void setTime(Time time)
    {
        m_hour = time.m_hour;
        m_minute = time.m_minute;
        m_second = time.m_second;
        m_millisecond = time.m_millisecond;
    }

    Time(Time time)
    {
        setTime(time);
    }

    public Time() //Çağrıldığında sistemin zamanını alır
    {
        Calendar now = Calendar.getInstance();

        m_hour = now.get(Calendar.HOUR_OF_DAY);
        m_minute = now.get(Calendar.MINUTE);
        m_second = now.get(Calendar.SECOND);
        m_millisecond = now.get(Calendar.MILLISECOND);
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        controlForTime(hour, minute, second, millisecond);
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public int getHour() {return m_hour;}

    public void setHour(int hour)
    {
        if (hour == m_hour)
            return;

        controlForHour(hour);
        m_hour = hour;
    }

    public int getMinute() {return m_minute;}
    public void setMinute(int minute)
    {
        if (minute == m_minute)
            return;

        controlForMinute(minute);
        m_minute = minute;
    }

    public int getSecond() {return m_second;}
    public void setSecond(int second)
    {
        if (second == m_second)
            return;

        controlForSecond(second);
        m_second = second;
    }

    public int getMillisecond() {return m_millisecond;}

    public void setMillisecond(int millisecond)
    {
        if (millisecond == m_millisecond)
            return;

        controlForMillisecond(millisecond);
        m_millisecond = millisecond;
    }

    public String toString()
    {
        return String.format("%s:%02d", toShortTimeString(), m_second);
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }
}
