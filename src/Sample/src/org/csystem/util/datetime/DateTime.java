/*----------------------------------------------------------------------------------------------------------------------
    DateTime sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

public class DateTime {
    private Date m_date;
    private Time m_time;

    public DateTime(Date date, Time time)
    {
        m_date = new Date(date);
        m_time = new Time(time);
    }

    public int getDay() {return m_date.getDay();}

    public int getMon()
    {
        return m_date.getMon();
    }

    public int getYear()
    {
        return m_date.getYear();
    }

    public DayOfWeek getDayOfWeek()
    {
        return m_date.getDayOfWeek();
    }

    public int getDayOfYear()
    {
        return m_date.getDayOfYear();
    }

    public boolean isLeapYear()
    {
        return m_date.isLeapYear();
    }

    public void setDay(int day)
    {
        m_date.setDay(day);
    }

    public void setMonth(Month month)
    {
        m_date.setMonth(month);
    }

    public void setMonthValue(int mon)
    {
        m_date.setMonthValue(mon);
    }

    public void setYear(int year)
    {
        m_date.setYear(year);
    }

    public void setDate(int day, Month month, int year)
    {
        m_date.setDate(day, month, year);
    }

    public void setDate(int day, int mon, int year)
    {
        m_date.setDate(day, mon, year);
    }

    public String toString()
    {
        return String.format("%s %s", m_date.toString(), m_time.toString());
    }
}
