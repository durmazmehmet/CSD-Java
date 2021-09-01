package org.csystem.util;

public class MutableString {
    private String m_str;

    public MutableString(String str)
    {
        m_str = str;
    }

    public MutableString append(String str)
    {
        m_str += str;

        return this;
    }
    //...
    public String toString()
    {
        return m_str;
    }
}
