/*----------------------------------------------------------------------------------------------------------------------
    Time sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public final class Time {
    private int m_hour, m_minute, m_second, m_millisecond;

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute)
                && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static boolean isValidForHour(int val)
    {
        return isValidForBounds(val, 0, 23);
    }

    private static boolean isValidForMinute(int val)
    {
        return isValidForBounds(val, 0, 59);
    }

    private static boolean isValidForSecond(int val)
    {
        return isValidForBounds(val, 0, 59);
    }

    private static boolean isValidForMillisecond(int val)
    {
        return isValidForBounds(val, 0, 999);
    }

    private static boolean isValidForBounds(int val, int min, int max) //[min, max]
    {
        return min <= val && val <= max;
    }

    private static void doWorkForException(String msg)
    {
       throw new DateTimeException(msg);
    }

    public static Time randomTime()
    {
        return randomTime(new Random());
    }

    public static Time randomTime(Random r)
    {
        int hour = r.nextInt(24);
        int minute = r.nextInt(60);
        int second = r.nextInt(60);
        int millisecond = r.nextInt(1000);

        return new Time(hour, minute, second, millisecond);
    }

    Time(Time time)
    {
        this.setTime(time.m_hour, time.m_minute, time.m_second, time.m_millisecond);
    }


    public Time() // O anki zamanı sistemden alıyor
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
        setTime(hour, minute, second, millisecond);
    }

    public int getHour() {return m_hour;}
    public int getMinute() {return m_minute;}
    public int getSecond() {return m_second;}
    public int getMillisecond() {return m_millisecond;}

    public void setHour(int hour)
    {
        if (hour == m_hour)
            return;

        if (!isValidForHour(hour))
            doWorkForException("Invalid hour");

        m_hour = hour;
    }

    public void setMinute(int minute)
    {
        if (minute == m_minute)
            return;

        if (!isValidForMinute(minute))
            doWorkForException("Invalid minute");

        m_minute = minute;
    }

    public void setSecond(int second)
    {
        if (second == m_second)
            return;

        if (!isValidForSecond(second))
            doWorkForException("Invalid second");

        m_second = second;
    }

    public void setMillisecond(int millisecond)
    {
        if (millisecond == m_millisecond)
            return;

        if (!isValidForMillisecond(millisecond))
            doWorkForException("Invalid millisecond");

        m_millisecond = millisecond;
    }


    public void setTime(int hour, int minute, int second, int millisecond)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException("Invalid Time");

        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }

    public String toString()
    {
        return String.format("%s:%02d", toShortTimeString(), m_second);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }
}
