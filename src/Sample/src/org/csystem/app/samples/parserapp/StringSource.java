package org.csystem.app.samples.parserapp;

public class StringSource implements ISource {
    private String m_str;
    private int m_index;

    public StringSource(String str)
    {
        m_str = str;
    }

    public int getChar()
    {
        return m_index == m_str.length() ? -1 : m_str.charAt(m_index++);
    }
}
